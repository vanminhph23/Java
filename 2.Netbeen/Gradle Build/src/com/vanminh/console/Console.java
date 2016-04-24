package com.vanminh.console;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Console {

    private IConsoleEvent consoleEvent;
    private Process process;
    private Object data;
    private String cmds = "";

    public Console() {
    }
    
    

    @Override
    protected void finalize() throws Throwable {
        destroy();
        super.finalize();
    }

    public void registerEvent(IConsoleEvent consoleEvent, Object data) {
        this.consoleEvent = consoleEvent;
        this.data = data;
    }

    public boolean executeAsync(String directoryWork, String pathTool, String commands) {
        return executeEx(directoryWork, pathTool, commands, false);
    }

    public boolean execute(String directoryWork, String pathTool, String commands) {
        return executeEx(directoryWork, pathTool, commands, true);
    }

    private boolean executeEx(String directoryWork, String pathTool, String commands, boolean bSync) {
        this.cmds = commands;
        try {
            Runtime runtime = Runtime.getRuntime();

            if (directoryWork == null) {
                String cmds = pathTool + " " + commands;
                System.out.println(cmds);
                process = runtime.exec(cmds);
            } else {
                String cmds = "cmd.exe /c " + pathTool + " " + commands;
                System.out.println(cmds);
                process = runtime.exec(cmds, null, new File(directoryWork));
            }

            BufferedReader bufReaderStdOut = new BufferedReader(new InputStreamReader(process.getInputStream(), Charset.defaultCharset()));

            ConsoleThread conThreadStdOut = new ConsoleThread(bufReaderStdOut, new IConsoleStringEvent() {
                @Override
                public void OnString(String strOut) {
                    if (consoleEvent != null) {
                        consoleEvent.onStdOutString(strOut, data);
                    }
                }

            });

            BufferedReader bufReaderStdErr = new BufferedReader(new InputStreamReader(process.getErrorStream(), Charset.defaultCharset()));
            ConsoleThread conThreadStdErr = new ConsoleThread(bufReaderStdErr, new IConsoleStringEvent() {
                @Override
                public void OnString(String strOut) {
                    if (consoleEvent != null) {
                        consoleEvent.onStdErrString(strOut, data);
                    }
                }
            });

            ConsoleFinishThread conThreadFinish = new ConsoleFinishThread(conThreadStdOut, conThreadStdErr, new IConsoleFinishEvent() {

                @Override
                public boolean OnFinished() {
                    if (consoleEvent != null) {
                        return consoleEvent.onExecFinished(data);
                    }

                    return false;
                }

            });

            conThreadStdOut.start();
            conThreadStdErr.start();
            conThreadFinish.start();

            if (bSync) {
                try {
                    conThreadFinish.join();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            //return conThreadFinish.result;
            return true;
        } catch (IOException ex) {
            Logger.getLogger(Console.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public void destroy() {
        if (process != null) {
            process.destroy();
            process = null;
        }
        
        
    }

    public String getCmds() {
        return cmds;
    }
    
    
}

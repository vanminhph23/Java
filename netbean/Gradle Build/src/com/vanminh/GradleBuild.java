/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vanminh;

import com.vanminh.console.Console;
import com.vanminh.console.IConsoleEvent;
import com.vanminh.dialog.ChooseDevice;
import java.awt.Toolkit;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.Preferences;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.text.DefaultCaret;

/**
 *
 * @author sev_user
 */
public class GradleBuild extends javax.swing.JFrame {

    private final List<String> listTask;
    private final List<Byte> listTaskID;
    private final List<String> ALL_TASK;
    private final String PRE_AUTO_INSTALL = "auto_install", PRE_PATH_GRADLE = "path_gradle", PRE_PATH_PROJECT = "path_project", PRE_TASK_ID = "task_id", PRE_PATH_ADB = "path_adb";
    private final Preferences preferences;
    private String pathGradle;
    private boolean buildSuccessfully = false;
    private final String pathAPK = "\\app\\build\\outputs\\apk\\app-debug.apk";
    private String pathADB;
    private String pathProject;
    private boolean mAutoInstall = false;
    private String IPDevice = "";
    private Console console;
    private final String TASK_REFRESH = "task";
    private boolean isExecute = false;
    private String deviceInstall = "";
    private boolean isDeviceDefault = false;
    private List<String> listDevice;
    private final String searchCmd = "devices";
    private JFrame parent;
    private boolean isInstall = false;

    /**
     * Creates new form GradleBuild
     */
    public GradleBuild() {
        this.ALL_TASK = new ArrayList<>(Arrays.asList("assembleDebug", "assembleRelease", "clean"));
        listDevice = new ArrayList<>();
        parent = this;

        setResizable(false);

        initComponents();
        setLocationRelativeTo(null);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("iconLogo.png")));
        DefaultCaret caret = (DefaultCaret) txtConsole.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        preferences = Preferences.userNodeForPackage(this.getClass());
        pathProject = preferences.get(PRE_PATH_PROJECT, "");
        txtProject.setText(pathProject);
        pathGradle = preferences.get(PRE_PATH_GRADLE, "");
        pathADB = preferences.get(PRE_PATH_ADB, "");
        mAutoInstall = preferences.getBoolean(PRE_AUTO_INSTALL, mAutoInstall);
        autoInstall.setSelected(mAutoInstall);

        listTaskID = toByteList(preferences.getByteArray(PRE_TASK_ID, null));
        listTask = new ArrayList<String>();
        for (Byte task : listTaskID) {
            listTask.add(ALL_TASK.get(task));
        }
        if (listTask != null) {
            cbTask.setModel(new DefaultComboBoxModel(listTask.toArray()));
        }

        console = new Console();
        console.registerEvent(new IConsoleEvent() {

            @Override
            public void onStdOutString(String str, Object data) {
                txtConsole.append(str + "\n");
                if (console.getCmds().equals(TASK_REFRESH)) {
                    for (int i = 0; i < ALL_TASK.size(); i++) {
                        if (str.contains(ALL_TASK.get(i)) && !listTask.contains(ALL_TASK.get(i))) {
                            listTask.add(ALL_TASK.get(i));
                            listTaskID.add((byte) i);
                        }
                    }
                } else if (console.getCmds().equals(ALL_TASK.get(0))) {
                    if (mAutoInstall) {
                        if (str.contains("BUILD SUCCESSFUL")) {
                            buildSuccessfully = true;
                        }
                    }
                } else if (console.getCmds().equals(searchCmd)) {
                    if (str.contains("\t")) {
                        listDevice.add(str.replace("\t", " "));
                    }
                }
            }

            @Override
            public void onStdErrString(String str, Object data) {
                txtConsole.append(str + "\n");
            }

            @Override
            public boolean onExecFinished(Object data) {
                setEnableButton(true);
                if (console.getCmds().equals(TASK_REFRESH)) {
                    cbTask.setModel(new DefaultComboBoxModel(listTask.toArray()));
                    preferences.putByteArray(PRE_TASK_ID, toByteArray(listTaskID));
                } else if (console.getCmds().equals(ALL_TASK.get(0))) {
                    if (buildSuccessfully) {
                        installAPK(true);
                    }
                } else if (console.getCmds().equals(searchCmd)) {
                    boolean exist = false;
                    for (String device : listDevice) {
                        if (device.equals(deviceInstall)) {
                            exist = true;
                        }
                    }
                    if (!isDeviceDefault || !exist) {
                        isDeviceDefault = false;
                        deviceInstall = "";
                        String[] devices = new String[listDevice.size()];
                        devices = listDevice.toArray(devices);
                        ChooseDevice chooseDevice = new ChooseDevice(parent, true, devices);
                        chooseDevice.setVisible(true);
                        if (chooseDevice.getDevice() != "") {
                            deviceInstall = chooseDevice.getDevice();
                            if (deviceInstall.split(":").length > 1) {
                                IPDevice = deviceInstall.split(":")[0];
                            }
                            isDeviceDefault = chooseDevice.isSetDefault();
                            installAPK(false);

                        }
                    }

                }
                return false;
            }
        }, null);
    }

    private void clearListTask() {
        listTask.clear();
        listTaskID.clear();
    }

    private void clearConsole() {
        txtConsole.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtProject = new javax.swing.JTextField();
        btnOpenProject = new javax.swing.JButton();
        cbTask = new javax.swing.JComboBox();
        btnRefresh = new javax.swing.JButton();
        btnRun = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtConsole = new javax.swing.JTextArea();
        btnInstall = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        settingMenu = new javax.swing.JMenu();
        settingGradle = new javax.swing.JMenuItem();
        settingADB = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        settingDevice = new javax.swing.JMenu();
        autoInstall = new javax.swing.JCheckBoxMenuItem();
        refreshDevice = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gradle Build");

        txtProject.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtProject.setEnabled(false);

        btnOpenProject.setText("Open");
        btnOpenProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenProjectActionPerformed(evt);
            }
        });

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        btnRun.setText("Run");
        btnRun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRunActionPerformed(evt);
            }
        });

        txtConsole.setColumns(20);
        txtConsole.setRows(5);
        txtConsole.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtConsole.setEnabled(false);
        jScrollPane1.setViewportView(txtConsole);

        btnInstall.setText("Install");
        btnInstall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInstallActionPerformed(evt);
            }
        });

        settingMenu.setMnemonic('s');
        settingMenu.setText("Setting");

        settingGradle.setMnemonic('g');
        settingGradle.setText("Gradle");
        settingGradle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingGradleActionPerformed(evt);
            }
        });
        settingMenu.add(settingGradle);

        settingADB.setMnemonic('a');
        settingADB.setText("ADB");
        settingADB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingADBActionPerformed(evt);
            }
        });
        settingMenu.add(settingADB);

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        settingMenu.add(exitMenuItem);

        menuBar.add(settingMenu);

        settingDevice.setMnemonic('d');
        settingDevice.setText("Device");
        settingDevice.setToolTipText("");

        autoInstall.setMnemonic('a');
        autoInstall.setSelected(true);
        autoInstall.setText("Auto Install APK");
        autoInstall.setToolTipText("");
        autoInstall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autoInstallActionPerformed(evt);
            }
        });
        settingDevice.add(autoInstall);

        refreshDevice.setMnemonic('r');
        refreshDevice.setText("Refresh");
        refreshDevice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshDeviceActionPerformed(evt);
            }
        });
        settingDevice.add(refreshDevice);

        menuBar.add(settingDevice);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cbTask, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtProject, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnOpenProject, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRefresh, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRun, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                            .addComponent(btnInstall, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtProject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOpenProject)
                    .addComponent(btnInstall))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbTask, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRefresh)
                    .addComponent(btnRun))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void btnOpenProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenProjectActionPerformed
        JFileChooser fileChooser = new JFileChooser(new File(pathProject));
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.showOpenDialog(null);
        if (fileChooser.getSelectedFile() == null) {
            return;
        }
        pathProject = fileChooser.getSelectedFile().getAbsolutePath();
        txtProject.setText(pathProject);
        preferences.put(PRE_PATH_PROJECT, pathProject);
        clearListTask();
    }//GEN-LAST:event_btnOpenProjectActionPerformed


    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed

        clearListTask();
        clearConsole();

        if ("".equals(pathProject)) {
            JOptionPane.showMessageDialog(null, "Please choose project to run!", "Alert", JOptionPane.WARNING_MESSAGE);
            return;
        }
        setEnableButton(false);
        console.executeAsync(pathProject, pathGradle, TASK_REFRESH);
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void setEnableButton(boolean e) {
        if (e) {
            btnOpenProject.setEnabled(e);
            btnRefresh.setEnabled(e);
            btnRun.setText("Run");
            isExecute = false;
        } else {
            isExecute = true;
            btnOpenProject.setEnabled(e);
            btnRefresh.setEnabled(e);
            btnRun.setText("Cancel");
        }

    }

    private byte[] toByteArray(List<Byte> listByte) {
        byte[] data = new byte[listByte.size()];
        for (int i = 0; i < data.length; i++) {
            data[i] = (byte) listByte.get(i);
        }
        return data;
    }

    private List<Byte> toByteList(byte[] arrayByte) {
        List<Byte> listByte = new ArrayList<Byte>();
        if (arrayByte == null) {
            return listByte;
        }
        for (byte b : arrayByte) {
            listByte.add(b);
        }
        return listByte;
    }

    private void btnRunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRunActionPerformed
        if (!isExecute) {
            clearConsole();
            setEnableButton(false);
            buildSuccessfully = false;
            String cmd = cbTask.getSelectedItem().toString();
            if (cmd == null) {
                JOptionPane.showMessageDialog(null, "Please choose task to run!", "Alert", JOptionPane.WARNING_MESSAGE);
                return;
            }

            if ("".equals(pathProject)) {
                JOptionPane.showMessageDialog(null, "Please choose project to run!", "Alert", JOptionPane.WARNING_MESSAGE);
                return;
            }
            console.executeAsync(pathProject, pathGradle, cmd);
        } else {
            console.destroy();
            setEnableButton(true);
        }
    }//GEN-LAST:event_btnRunActionPerformed

    private void installAPK(boolean search) {
        if (pathADB.equals("")) {
            JOptionPane.showMessageDialog(null, "Please setting ADB!", "Alert", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (search) {
            searchDevice(false);
        }

        if (deviceInstall.equals("")) {
            return;
        }

        if (!IPDevice.equals("")) {
            setEnableButton(false);
            console.executeAsync(null, pathADB, " connect " + IPDevice);
        }
        setEnableButton(false);
        console.executeAsync(null, pathADB, "-s " + deviceInstall.split(" ")[0] + " install -r \"" + pathProject + pathAPK+"\"");
        isInstall = false;
    }

    private void searchDevice(boolean async) {
        listDevice.clear();
        IPDevice = "";
        setEnableButton(false);
        if (async) {
            console.executeAsync(null, pathADB, searchCmd);
        } else {
            console.execute(null, pathADB, searchCmd);
        }
    }

    private void settingGradleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settingGradleActionPerformed
        JFileChooser fileChooser = new JFileChooser(new File(pathGradle));
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.addChoosableFileFilter(new FileFilter() {

            @Override
            public boolean accept(File f) {
                if (f.isDirectory()) {
                    return true;
                }
                if (f.getName().endsWith("gradle.bat")) {
                    return true;
                }
                return false;
            }

            @Override
            public String getDescription() {
                return "gradle.bat";
            }
        });

        fileChooser.showOpenDialog(null);
        if (fileChooser.getSelectedFile() == null) {
            return;
        }
        pathGradle = fileChooser.getSelectedFile().getAbsolutePath();
        System.out.println(pathGradle);
        preferences.put(PRE_PATH_GRADLE, pathGradle);
    }//GEN-LAST:event_settingGradleActionPerformed

    private void settingADBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settingADBActionPerformed
        JFileChooser fileChooser = new JFileChooser(new File(pathADB));
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.addChoosableFileFilter(new FileFilter() {

            @Override
            public boolean accept(File f) {
                if (f.isDirectory()) {
                    return true;
                }
                if (f.getName().endsWith("adb.exe")) {
                    return true;
                }
                return false;
            }

            @Override
            public String getDescription() {
                return "adb.exe";
            }
        });

        fileChooser.showOpenDialog(null);
        if (fileChooser.getSelectedFile() == null) {
            return;
        }
        pathADB = fileChooser.getSelectedFile().getAbsolutePath();
        System.out.println(pathADB);
        preferences.put(PRE_PATH_ADB, pathADB);
    }//GEN-LAST:event_settingADBActionPerformed

    private void autoInstallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_autoInstallActionPerformed
        mAutoInstall = autoInstall.getState();
        preferences.putBoolean(PRE_AUTO_INSTALL, mAutoInstall);
    }//GEN-LAST:event_autoInstallActionPerformed

    private void refreshDeviceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshDeviceActionPerformed
        isDeviceDefault = false;
        searchDevice(true);
    }//GEN-LAST:event_refreshDeviceActionPerformed


    private void btnInstallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInstallActionPerformed
        searchDevice(true);
        isInstall = true;
    }//GEN-LAST:event_btnInstallActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GradleBuild.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GradleBuild.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GradleBuild.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GradleBuild.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GradleBuild().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBoxMenuItem autoInstall;
    private javax.swing.JButton btnInstall;
    private javax.swing.JButton btnOpenProject;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnRun;
    private javax.swing.JComboBox cbTask;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem refreshDevice;
    private javax.swing.JMenuItem settingADB;
    private javax.swing.JMenu settingDevice;
    private javax.swing.JMenuItem settingGradle;
    private javax.swing.JMenu settingMenu;
    private javax.swing.JTextArea txtConsole;
    private javax.swing.JTextField txtProject;
    // End of variables declaration//GEN-END:variables

}

package com.vanminh.console;

import java.io.BufferedReader;
import java.io.IOException;


public class ConsoleThread extends Thread {

	private BufferedReader m_bufReader;
	private IConsoleStringEvent m_conStrEvent;

	public ConsoleThread(BufferedReader bufReader, IConsoleStringEvent conStrEvent) {
		m_bufReader = bufReader;
		m_conStrEvent = conStrEvent;
	}

	@Override
	public void run() {
		String strLine;
		try {
			while ((strLine = m_bufReader.readLine()) != null) {
				m_conStrEvent.OnString(strLine);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	

}

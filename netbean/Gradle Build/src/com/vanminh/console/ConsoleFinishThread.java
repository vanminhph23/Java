package com.vanminh.console;

public class ConsoleFinishThread extends Thread {
	private Thread m_stdOutThread;
	private Thread m_stdErrThread;
	private IConsoleFinishEvent m_conFinishEvent;

	public ConsoleFinishThread(Thread stdOutThread, Thread stdErrThread, IConsoleFinishEvent conFinishEvent) {
		m_stdOutThread = stdOutThread;
		m_stdErrThread = stdErrThread;
		m_conFinishEvent = conFinishEvent;
		this.result = false;
	}

	@Override
	public void run() {
		if (m_stdOutThread != null && m_stdErrThread != null) {
			try {
				m_stdOutThread.join();
				m_stdErrThread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			// while(m_stdOutThread.isAlive() || m_stdErrThread.isAlive());
			// m_stdOutThread.wait();

			if (m_conFinishEvent != null) {
				result = m_conFinishEvent.OnFinished();
			}
		}

		super.run();
	}

	public boolean result;

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}
}

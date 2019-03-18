package com.vanminh.console;

public interface IConsoleEvent {
	void onStdOutString(String str, Object data);
	void onStdErrString(String str, Object data);
	boolean onExecFinished(Object data);
}

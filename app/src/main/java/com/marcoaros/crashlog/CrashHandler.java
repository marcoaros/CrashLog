package com.marcoaros.crashlog;

import com.google.code.microlog4android.Logger;
import com.google.code.microlog4android.LoggerFactory;

import java.lang.Thread.UncaughtExceptionHandler;

/**
 * 自定义的 异常处理类 , 实现了 UncaughtExceptionHandler接口
 * 
 * @author marcoaros
 * 
 */
public class CrashHandler implements UncaughtExceptionHandler {
	private Thread.UncaughtExceptionHandler a;
	private static final Logger logger = LoggerFactory.getLogger();

	CrashHandler() {
		this.a = Thread.getDefaultUncaughtExceptionHandler();
	}

	@Override
	public void uncaughtException(Thread thread, Throwable ex) {
		if (a != null) {
			logger.error(ex.getMessage() + "  " + ex.getLocalizedMessage() + "\n");
			Throwable cause = ex.getCause();
			if (cause != null) {
				StackTraceElement[] st = cause.getStackTrace();
				for (StackTraceElement stackTraceElement : st) {
					String className = stackTraceElement.getClassName();
					String methodName = stackTraceElement.getMethodName();
					logger.error("[class:" + className + "] method:" + methodName
							+ "  lineNum:" + stackTraceElement.getLineNumber()
							+ "  ExceptionName:" + ex.getClass().getName());
				}
			}
			StackTraceElement[] st = ex.getStackTrace();
			for (StackTraceElement stackTraceElement : st) {
				String className = stackTraceElement.getClassName();
				String methodName = stackTraceElement.getMethodName();
				logger.error("[class:" + className + "] method:" + methodName
						+ "  lineNum:" + stackTraceElement.getLineNumber()
						+ "  ExceptionName:" + ex.getClass().getName());
			}
			a.uncaughtException(thread, ex);

		}
	}
}

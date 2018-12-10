package com.mrliuxia.heiheihei.a45156;

/**
 * @Description
 * @Date 2017/3/19
 */
public class TaskRunner implements Runnable {

	private Task mTask;

	public TaskRunner(Task task) {
		mTask = task;
	}

	@Override
	public void run() {
		mTask.execute();
	}
}

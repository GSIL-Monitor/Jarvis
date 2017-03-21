package heiheihei.a45156;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description
 * @Author liuxiao
 * @Date 2017/3/19
 */
public class MyTaskExecutor implements TaskExecutor {

	private static List<TaskRunner> runnerPool;

	private MyTaskExecutor() {}

	public static List<TaskRunner> getTaskQueueInstance() {
		if (runnerPool == null) {
			synchronized (MyTaskExecutor.class) {
				runnerPool = new LinkedList<>();
			}
		}
		return runnerPool;
	}

	@Override
	public void addTask(Task task) {
		getTaskQueueInstance().add(new TaskRunner(task));
	}
}

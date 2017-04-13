package heiheihei.a45156;

/**
 * @Description
 * @Date 2017/3/19
 */
public class MyTask implements Task {

	private String name;

	public MyTask(String name) {
		this.name = name;
	}

	@Override
	public void execute() {

	}

	@Override
	public String getName() {
		return name;
	}
}

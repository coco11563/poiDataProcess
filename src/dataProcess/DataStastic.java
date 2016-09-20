package dataProcess;

public class DataStastic {
	private int verynear = 0;
	private int near = 0;
	private int normal = 0;
	private int far = 0;
	private int veryfar = 0;
	private int num = 0;
	public void stastic(double distance) {
		if (distance < 50.0) {
			verynear ++;
		} else if (distance < 100.0) {
			near ++;
		} else if (distance < 200.0) {
			normal ++;
		} else if (distance < 300.0) {
			far ++;
		} else {
			veryfar ++;
		}
		num ++;
	}
	public double veryNearRate() {
		return (double)verynear / num;
	}
	public double nearRate() {
		return (double)near / num;
	}
	public double normalRate() {
		return (double)normal / num;
	}
	public double farRate() {
		return (double)far / num;
	}
	public double veryFarRate() {
		return (double)veryfar / num;
	}
	@Override 
	public String toString() {
		return "很近点 ：" + verynear + "个" + "\n" +
				"近点 ：" + near + "个" + "\n" +
				"普通点 ：" + normal + "个" + "\n" +
				"较远点 ：" + far + "个" + "\n" +
				"很远点 ：" + veryfar + "个" + "\n"
				;
	}
}

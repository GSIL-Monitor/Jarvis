package heiheihei.date0331;

/**
 * @Description 点
 * @Date 2017/3/31
 */
public class Point {

	private double x;
	private double y;

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public Point(Point point) {
		this.x = point.x;
		this.y = point.y;
	}

	public void move(double dx, double dy) {
		x += dx;
		y += dy;
	}

	public void rotate(double alpha) {
		double cpx = x, cpy = y;
		x = cpx * Math.cos(alpha) - cpy * Math.sin(alpha);
		y = cpx * Math.sin(alpha) + cpy * Math.cos(alpha);
		x = format(x);
		y = format(y);
	}

	private double format(double d) {
		return Double.parseDouble(String.format("%.2f", d));
	}

	@Override
	public String toString() {
		return String.format("x=%s, y=%s", x, y);
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Point)) {
			return false;
		}
		Point point = ((Point) obj);
		return point.x == x && point.y == y;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}
}

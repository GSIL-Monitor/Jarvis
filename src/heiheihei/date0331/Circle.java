package heiheihei.date0331;

/**
 * @Description 圆形
 * @Date 2017/3/31
 */
public class Circle extends Graphics {

	private double radius;
	private Point centerPoint;

	public Circle(String color, double lineWidth, Point centerPoint, double radius) {
		super(color, lineWidth);
		this.radius = radius;
		this.centerPoint = centerPoint;
		generatePoints();
	}

	@Override
	public void move(double dx, double dy) {
		super.move(dx, dy);
		centerPoint.move(dx, dy);
	}

	@Override
	public void rotate(double alpha) {
		super.rotate(alpha);
		centerPoint.rotate(alpha);
	}

	@Override
	public void generatePoints() {
		double radix = Math.PI / 3;
		for (int i = 0; i < 6; i++) {
			addPoint(getCirclePoint(centerPoint, radix * i, radius));
		}
	}

	private Point getCirclePoint(Point center, double alpha, double radius) {
		double x = center.getX() + radius * Math.cos(alpha);
		double y = center.getY() + radius * Math.sin(alpha);
		x = Double.parseDouble(String.format("%.2f", x));
		y = Double.parseDouble(String.format("%.2f", y));
		return new Point(x, y);
	}

	@Override
	public String toString() {
		return String.format("Kind: 圆\n%s", super.toString());
	}
}

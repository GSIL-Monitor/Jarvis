package heiheihei.date0331;

import java.util.Collections;
import java.util.Comparator;

/**
 * @Description 直线
 * @Date 2017/3/31
 */
public class Line extends Graphics {

	private Point p1;
	private Point p2;

	public Line(String color, double lineWidth, Point p1, Point p2) {
		super(color, lineWidth);
		this.p1 = p1;
		this.p2 = p2;
		generatePoints();
	}

	@Override
	public void generatePoints() {
		Point p3 = new Point(p1.getX() - p2.getX() + p1.getX(), p1.getY() - p2.getY() + p1.getY());
		Point p4 = new Point(p2.getX() + p2.getX() - p1.getX(), p2.getY() + p2.getY() - p1.getY());
		addPoint(p1);
		addPoint(p2);
		addPoint(p3);
		addPoint(p4);
		Collections.sort(getPoints(), new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				return ((int) (o1.getX() - o2.getX()));
			}
		});
	}


	@Override
	public String toString() {
		return String.format("Kind: 直线\n%s", super.toString());
	}
}

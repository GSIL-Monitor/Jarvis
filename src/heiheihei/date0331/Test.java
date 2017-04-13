package heiheihei.date0331;

/**
 * @Description
 * @Date 2017/3/31
 */
public class Test {

	public static void main(String[] args) {
		// 直线
		Line line = new Line("red", 1.0, new Point(1, 1), new Point(2, 2));
		System.out.println("-----------------------------");
		System.out.println(line);

		line.move(1, 2);
		System.out.println("直线向右平移1，向上平移2");
		System.out.println(line);

		line.rotate(Math.PI / 2);
		System.out.println("直线逆时针旋转90度");
		System.out.println(line);

		// 圆
		Circle circle = new Circle("white", 0.5, new Point(0, 0), 2);
		System.out.println("-----------------------------");
		System.out.println(circle);

		circle.move(-1, -2);
		System.out.println("圆向左平移1，向下平移2");
		System.out.println(circle);

		circle.rotate(Math.PI);
		System.out.println("圆向逆时针旋转180度");
		System.out.println(circle);

		// 多边形
		Polygon polygon = new Polygon("green", 1.2, new Point(1, 1), new Point(3, 1), new Point(3, 2), new Point(2, 3), new Point(1, 3));
		System.out.println("-----------------------------");
		System.out.println(polygon);

		polygon.move(1, -2);
		System.out.println("多边形向右平移1，向下平移2");
		System.out.println(polygon);

		polygon.rotate(Math.PI * 3 / 2);
		System.out.println("多边形顺时针旋转90度");
		System.out.println(polygon);
	}

}

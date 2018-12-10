package com.mrliuxia.heiheihei.date0331;

/**
 * @Description 多边形
 * @Date 2017/3/31
 */
public class Polygon extends Graphics {

	public Polygon(String color, double lineWidth, Point... points) {
		super(color, lineWidth);
		for (Point point : points) {
			addPoint(point);
		}
	}

	@Override
	public void generatePoints() {
	}

	@Override
	public String toString() {
		return String.format("Kind: 多边形\n%s", super.toString());
	}
}

package com.mrliuxia.heiheihei.date0331;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description 图形 基类
 * @Date 2017/3/31
 */
public abstract class Graphics {

	private String color;
	private double lineWidth;
	private List<Point> points;

	public Graphics(String color, double lineWidth) {
		this.color = color;
		this.lineWidth = lineWidth;
		points = new LinkedList<>();
	}

	public abstract void generatePoints();

	public void move(double dx, double dy) {
		if (points == null) {
			return;
		}
		Iterator iterator = points.iterator();
		while (iterator.hasNext()) {
			Point currPoint = (Point) iterator.next();
			currPoint.move(dx, dy);
		}
	}

	public void rotate(double alpha) {
		if (points == null) {
			return;
		}
		Iterator iterator = points.iterator();
		while (iterator.hasNext()) {
			Point currPoint = (Point) iterator.next();
			currPoint.rotate(alpha);
		}
	}

	public void addPoint(Point point) {
		points.add(point);
	}

	public String getColor() {
		return color;
	}

	public double getLineWidth() {
		return lineWidth;
	}

	public List<Point> getPoints() {
		return points;
	}

	@Override
	public String toString() {
		StringBuilder pointStr = new StringBuilder();
		Iterator iterator = points.iterator();
		while (iterator.hasNext()) {
			Point currPoint = (Point) iterator.next();
			pointStr.append(String.format("[%s] ", currPoint.toString()));
		}
		return String.format("Color: %s\nLine width: %s\nPoints: %s\n", color, lineWidth, pointStr.toString());
	}

}

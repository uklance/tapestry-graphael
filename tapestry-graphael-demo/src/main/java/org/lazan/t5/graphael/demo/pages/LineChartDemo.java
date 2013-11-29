package org.lazan.t5.graphael.demo.pages;

import org.lazan.t5.graphael.model.Point;

public class LineChartDemo {
	public Point[] getFooValues() {
		return new Point[] {
			new Point(0, 0), new Point(1, 1), new Point(2, 2)  
		};
	}
	public Point[] getBarValues() {
		return new Point[] {
			new Point(3, 0), new Point(2, 1), new Point(1, 2)  
		};
	}
	public Point[] getBazValues() {
		return new Point[] {
			new Point(4, 2), new Point(3, 3), new Point(1, 2)
		};
	};
}

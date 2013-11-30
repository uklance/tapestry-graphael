package org.lazan.t5.graphael.demo.pages;

import java.util.ArrayList;
import java.util.List;

import org.lazan.t5.graphael.model.Point;
import org.apache.tapestry5.annotations.Import;

@Import(library = "LineChartDemo.js")
public class LineChartDemo {
	public List<Point> getSinValues() {
		return createPoints(-5, 5, new Function() {
			public Double apply(Double number) {
				return Math.sin(number);
			}
		});
	}
	
	public List<Point> getCosValues() {
		return createPoints(-5, 5, new Function() {
			public Double apply(Double number) {
				return Math.cos(number);
			}
		});
	}
	
	public List<Point> getZeroValues() {
		return createPoints(-5, 5, new Function() {
			public Double apply(Double number) {
				return 0d;
			}
		});
	}
	
	protected List<Point> createPoints(int xStart, int xEnd, Function function) {
		double step = 0.1;
		int pointCount = (int) ((xEnd - xStart) / step);
		List<Point> points = new ArrayList<Point>(pointCount);
		for (double x = xStart; x <= xEnd; x += step) {
			points.add(new Point(x, function.apply(x)));
		}
		return points;
	}
	
	static interface Function {
		Double apply(Double number);
	}
}

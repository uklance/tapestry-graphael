package org.lazan.t5.graphael.model;

import java.util.Collection;

public class LineSeriesModel {
	private String label;
	private String color;
	private Collection<Point> values;
	
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Collection<Point> getValues() {
		return values;
	}
	public void setValues(Collection<Point> values) {
		this.values = values;
	}
}

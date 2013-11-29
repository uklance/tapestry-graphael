package org.lazan.t5.graphael.components;

import java.util.Collection;

import org.apache.tapestry5.annotations.AfterRender;
import org.apache.tapestry5.annotations.Environmental;
import org.apache.tapestry5.annotations.Parameter;
import org.lazan.t5.graphael.model.LineModel;
import org.lazan.t5.graphael.model.LineSeriesModel;
import org.lazan.t5.graphael.model.Point;

public class LineSeries {
	@Parameter
	private String label;
	
	@Parameter
	private String color;
	
	@Parameter(required=true)
	private Collection<Point> values;
	
	@Environmental
	private LineModel model;
	
	@AfterRender
	void afterRender() {
		LineSeriesModel series = new LineSeriesModel();
		series.setColor(color);
		series.setValues(values);
		series.setLabel(label);
		model.addSeries(series);
	}
}

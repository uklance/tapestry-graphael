package org.lazan.t5.graphael.components;

import org.apache.tapestry5.annotations.Environmental;
import org.apache.tapestry5.annotations.Parameter;
import org.lazan.t5.graphael.model.PieChartModel;
import org.lazan.t5.graphael.model.PieSeriesModel;

public class PieSeries {
	@Parameter
	private String label;
	
	@Parameter(required=true)
	private Number value;
	
	@Parameter
	private String color;
	
	@Environmental
	private PieChartModel model;
	
	void afterRender() {
		PieSeriesModel series = new PieSeriesModel();
		series.setColor(color);
		series.setValue(value);
		series.setLabel(label);
		model.addSeries(series);
	}
}

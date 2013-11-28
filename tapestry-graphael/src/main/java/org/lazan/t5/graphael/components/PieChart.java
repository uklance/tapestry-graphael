package org.lazan.t5.graphael.components;

import java.util.List;

import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.MarkupWriter;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.SupportsInformalParameters;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.ioc.internal.util.CollectionFactory;
import org.apache.tapestry5.json.JSONArray;
import org.apache.tapestry5.json.JSONObject;
import org.apache.tapestry5.services.Environment;
import org.apache.tapestry5.services.javascript.JavaScriptSupport;
import org.lazan.t5.graphael.model.PieModel;
import org.lazan.t5.graphael.model.PieSeriesModel;

@Import(library={ "raphael.js", "g.raphael-min.js", "g.pie-min.js" })
@SupportsInformalParameters
public class PieChart {
	@Parameter(defaultPrefix=BindingConstants.LITERAL, required=true)
	private int locx;

	@Parameter(defaultPrefix=BindingConstants.LITERAL, required=true)
	private int locy;
	
	@Parameter(defaultPrefix=BindingConstants.LITERAL, required=true)
	private int radius;
	
	@Parameter(defaultPrefix=BindingConstants.LITERAL)
	private JSONObject options;

	@Parameter(defaultPrefix=BindingConstants.LITERAL)
	private String postProcessor;
	
	@Inject
	private JavaScriptSupport jss;
	
	@Inject
	private Environment environment;
	
	@Inject
	private ComponentResources componentResources;
	
	private List<PieSeriesModel> seriesList;

	void setupRender() {
		seriesList = CollectionFactory.newList();
		PieModel pieModel = new PieModel() {
			public void addSeries(PieSeriesModel series) {
				seriesList.add(series);
			}
		};
		environment.push(PieModel.class, pieModel);
	}
	
	void afterRenderTemplate(MarkupWriter writer) {
		environment.pop(PieModel.class);

		String clientId = jss.allocateClientId(componentResources);
		writer.element("div", "id", clientId);
		componentResources.renderInformalParameters(writer);
		writer.end();
		if (options == null) {
			options = new JSONObject();
		}
		JSONArray values = new JSONArray();
		for (PieSeriesModel series : seriesList) {
			values.put(series.getValue());
		}
		String script = String.format(
				"Raphael('%s').piechart(%s, %s, %s, %s, %s)",
				clientId, locx, locy, radius, values, options
		);
		if (postProcessor != null) {
			script = String.format("%s(%s)", postProcessor, script);
		}
		jss.addScript(script);
	}
}

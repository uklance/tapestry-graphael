tapestry-graphael
=================

[Tapestry](http://tapestry.apache.org/) / [gRaphaël](http://g.raphaeljs.com) integration

### Note, nothing implemented yet.


The idea is to provide a tapestry component library for rendering gRaphaël charts. By default, charting should not require any javascript coding. Advanced usage may require snippets of javascript.

Here's some ideas:

[Pie Chart](http://g.raphaeljs.com/reference.html#Paper.piechart)
```xml
	<t:piechart locx="100" locx="100" locy="200" radius="250" options="{legendpos: 'west'}">
		<t:loop source="myCollection" value="current">
			<t:pieseries label="current.label" value="current.value" color="" />
		</t:loop>
		<t:chartpostprocessor>
		   function(chart) { 
		      chart.hover(function() { ... }, function() { ... }) }
		   }
	  </t:chartpostprocessor>
	</t:piechart>
```

[Line Chart](http://g.raphaeljs.com/reference.html#Paper.linechart)
```xml
	<t:linechart locx="" locy="" width="" height="" options="{foo:'bar'}">
		<t:loop source="allSeries" value="currentSeries">
			<t:barseries label="currentSeries.label" values="currentSeries.values" />
		</t:loop>
	<t:linechart>
	<t:chartpostprocessor>
	   function(chart) { 
	      chart.eachColumn(function() { ... });
	   }
	</t:chartpostprocessor>
```

tapestry-graphael
=================

[Tapestry](http://tapestry.apache.org/) / [gRaphaël](http://g.raphaeljs.com) integration

### Note, not fully implemented yet.


The idea is to provide a tapestry component library for rendering gRaphaël charts. Simple charts should not require any javascript coding. Simple charts can be decorated by a javascript ```postProcessor``` for advanced features such as animations.

Here's some high level ideas:

[Pie Chart](http://g.raphaeljs.com/reference.html#Paper.piechart)
```xml
<t:piechart locx="100" locy="200" radius="250" options="{legendpos: 'west'}">
   <t:loop source="myCollection" value="current">
      <t:pieseries label="current.label" value="current.value" color="current.color" />
   </t:loop>
   <t:postprocessor>
      function(chart) { 
         chart.hover(function() { ... }, function() { ... });
      }
   </t:postprocessor>
</t:piechart>
```

[Line Chart](http://g.raphaeljs.com/reference.html#Paper.linechart)
```xml
<t:linechart locx="100" locy="200" width="250" height="250" options="{axis:'0 0 1 1'}">
   <t:loop source="allSeries" value="current">
      <!-- values is a java.util.Map<Number,Number> -->
      <t:lineseries label="current.label" values="current.values" color="current.color" />
   </t:loop>
   <t:postprocessor>
      function(chart) {
         var axisItems = chart.axis[0].text.items
         for(var i = 0, l = axisItems.length; i < l; i++) {
            var date = new Date(parseInt(axisItems[i].attr("text")));
            // using the excellent dateFormat code from Steve Levithan
            axisItems[i].attr("text", dateFormat(date, "mm/dd, htt"));
         }
      }
   </t:postprocessor>
</t:linechart>
```

Documentation
- [Line Chart Tips](https://www.exratione.com/2011/10/a-few-tips-for-graphael-line-charts)
- [Reference Documentation](http://g.raphaeljs.com/reference.html)
- References to ```axisxstep``` and ```axisystep``` [here](https://gist.github.com/boazsender/447379)

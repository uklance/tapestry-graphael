tapestry-graphael
=================

[Tapestry](http://tapestry.apache.org/) / [gRaphaël](http://g.raphaeljs.com) integration

### Note, nothing implemented yet.


The idea is to provide a tapestry component library for rendering gRaphaël charts. By default, charting should not require any javascript coding. Advanced usage may require snippets of javascript.

Here's some ideas:

[Pie Chart](http://g.raphaeljs.com/reference.html#Paper.piechart)
```xml
<t:piechart locx="100" locy="200" radius="250" options="{legendpos: 'west'}">
   <t:loop source="myCollection" value="current">
      <t:pieseries label="current.label" value="current.value" color="current.color" />
   </t:loop>
   <t:chartpostprocessor>
      function(chart) { 
         chart.hover(function() { ... }, function() { ... }) }
      }
   </t:chartpostprocessor>
</t:piechart>
```

[Bar Chart](http://g.raphaeljs.com/reference.html#Paper.barchart)
```xml
<t:barchart locx="100" locy="200" width="250" height="250" options="{foo:'bar'}">
   <t:loop source="allSeries" value="current">
      <t:barseries label="current.label" values="current.values" color="current.color" />
   </t:loop>
   <t:chartpostprocessor>
      function(chart) { 
         chart.eachColumn(function() { ... });
      }
   </t:chartpostprocessor>
</t:barchar>
```

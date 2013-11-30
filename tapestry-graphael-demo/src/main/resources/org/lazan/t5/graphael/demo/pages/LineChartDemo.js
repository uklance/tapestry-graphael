var linechartdemo = {};

linechartdemo.postprocessor = function(chart, r) {
	chart.hoverColumn(function () {
        this.set = r.set(
            r.circle(this.x, this.y[0]),
            r.circle(this.x, this.y[1]),
            r.circle(this.x, this.y[2])
        );
    }, function () {
        this.set.remove();
    });
};
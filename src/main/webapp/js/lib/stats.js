var Stats = function() {

    var startTime = Date.now(),
        prevTime = startTime;
    var ms = 0,
        msMin = Infinity,
        msMax = 0;

    var frames = 0,
        mode = 0;

    var container = document.createElement('div');
    container.id = 'stats';
    container.addEventListener('mousedown', function(event) {
        event.preventDefault();
        setMode(++mode % 2)
    }, false);
    container.style.cssText = 'width:80px;opacity:0.9;cursor:pointer';



    var msDiv = document.createElement('div');
    msDiv.id = 'ms';
    msDiv.style.cssText = 'padding:0 0 3px 3px;text-align:left;background-color:#020;display:none';
    container.appendChild(msDiv);


    var setMode = function(value) {

        mode = value;

        switch (mode) {

            case 0:

                msDiv.style.display = 'none';
                break;
            case 1:

                msDiv.style.display = 'block';
                break;
        }

    };

    var updateGraph = function(dom, value) {

        var child = dom.appendChild(dom.firstChild);
        child.style.height = value + 'px';

    };

    return {

        REVISION: 12,

        domElement: container,

        setMode: setMode,

        begin: function() {

            startTime = Date.now();

        },

        end: function() {

            var time = Date.now();

            ms = time - startTime;
            msMin = Math.min(msMin, ms);
            msMax = Math.max(msMax, ms);
            frames++;

            if (time > prevTime + 1000) {
                prevTime = time;
                frames = 0;
            }

            return time;

        },

        update: function() {

            startTime = this.end();

        }

    }

};

if (typeof module === 'object') {

    module.exports = Stats;

}
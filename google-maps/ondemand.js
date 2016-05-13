var ondemand = {

	googleMaps: {
	    loaded: false,
	    start: 0,
	    end: 0,
	    time: 0,
	    url: "https://maps.googleapis.com/maps/api/js?callback=ondemand.googleMapsCallback"
	},
	
	jquery: {
	    loaded: false,
	    start: 0,
	    end: 0,
	    time: 0,
	    url: "jquery-1.12.3.min.js"
	},
	
    loadGoogleMaps: function() {
        if (!ondemand.googleMaps.loaded) {
            ondemand.googleMaps.loaded = true;
            ondemand.googleMaps.start = new Date();
            ondemand.loadExternal(ondemand.googleMaps.url);
        }
    },
    
    loadJQuery: function() {
        if (!ondemand.jquery.loaded) {
            ondemand.jquery.loaded = true;
            ondemand.jquery.start = new Date();
            ondemand.loadExternal(ondemand.jquery.url, ondemand.jqueryCallback);
        }
    },
    
    googleMapsCallback: function() {
        ondemand.googleMaps.end = new Date();
        ondemand.googleMaps.time = ondemand.googleMaps.end.getTime() - ondemand.googleMaps.start.getTime();
        document.getElementById("googlemapstime").innerHTML= ondemand.googleMaps.time + " ms";
        mapsExample.createMap();
    },
    
    jqueryCallback: function() {
        ondemand.jquery.end = new Date();
        ondemand.jquery.time = ondemand.jquery.end.getTime() - ondemand.jquery.start.getTime();
        document.getElementById("jquerytime").innerHTML= ondemand.jquery.time + " ms";
    },
    
    loadExternal: function(url, f) {
        var script = document.createElement('script');
        script.setAttribute("type", "text/javascript");
        if (f == null) {
            console.log("Ignoring onload function.");
        }
        else {
            script.onload = f;
        }
        script.setAttribute("src", url);
        document.getElementsByTagName("head")[0].appendChild(script);
    },
    
    setup: function() {
        document.getElementById("loadgooglemaps").onclick = ondemand.loadGoogleMaps;
        document.getElementById("loadjquery").onclick = ondemand.loadJQuery;
    }
};

console.log("ondemand defined.");
window.onload = ondemand.setup;

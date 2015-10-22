// Google Maps API Example singleton.

var mapsExample = {

	addCircles: 5,
	addTriangles: 5,
	addStars: 5,
	circles: 0,
	triangles: 0,
	stars: 0,
	constrainZoom: false,
	minZoom: 9,
	lastZoomReset: false,
    
    initMap: function(id, latitude, longitude, zoomLevel) {
        mapsExample.id = id;
        mapsExample.zoom = zoomLevel;
        mapsExample.setup = {
	        center: {
	            lat: latitude,
	            lng: longitude
	        },
	        zoom: zoomLevel,
	        panControl: true
	    };
    },
    
    createMap: function() {
        mapsExample.controls = {
            constrainZoom: document.getElementById("constrainZoom"),
            circles: document.getElementById("circles"),
            triangles: document.getElementById("triangles"),
            stars: document.getElementById("stars")
        };
        mapsExample.controls.circles.value = mapsExample.addCircles;
        mapsExample.controls.triangles.value = mapsExample.addTriangles;
        mapsExample.controls.stars.value = mapsExample.addStars;
        mapsExample.controls.constrainZoom.onchange = mapsExample.constrainZoomChanged;
        mapsExample.controls.circles.onchange = mapsExample.circlesChanged;
        mapsExample.controls.triangles.onchange = mapsExample.trianglesChanged;
        mapsExample.controls.stars.onchange = mapsExample.starsChanged;
        mapsExample.container = document.getElementById(mapsExample.id);
        mapsExample.map = new google.maps.Map(mapsExample.container, mapsExample.setup);
        mapsExample.map.addListener("idle", mapsExample.idle);
        mapsExample.map.addListener("zoom_changed", mapsExample.zoomChanged);
        document.getElementById("version").innerHTML = google.maps.version;
        mapsExample.redCircle = mapsExample.createImage("red-circle.svg");
        mapsExample.greenTriangle = mapsExample.createImage("green-triangle.svg");
        mapsExample.blueStar = mapsExample.createImage("blue-star.svg");
        mapsExample.map.controls[google.maps.ControlPosition.RIGHT_CENTER].push(
            document.getElementById('legend'));
    },
    
    constrainZoomChanged : function() {
        mapsExample.constrainZoom = this.checked;
        console.log("constrainZoom=" + mapsExample.constrainZoom);
    },
    
    circlesChanged : function() {
        mapsExample.addCircles = this.value;
        console.log("addCircles=" + mapsExample.addCircles);
    },
    
    trianglesChanged : function() {
        mapsExample.addTriangles = this.value;
        console.log("addTriangles=" + mapsExample.addTriangles);
    },
    
    starsChanged : function() {
        mapsExample.addStars = this.value;
        console.log("addStars=" + mapsExample.addStars);
    },
    
    createImage: function(url) {
       var image = {
           url: url,
           size: new google.maps.Size(64, 64),
           scaledSize: new google.maps.Size(12, 12),
           origin: new google.maps.Point(0, 0),
           anchor: new google.maps.Point(0, 0)
       };
       return image;
    },
      
    idle: function(e) {
        mapsExample.metadata();
        mapsExample.updatePage();
    },
    
    metadata : function() {
        mapsExample.zoom = mapsExample.map.zoom;
        mapsExample.northEast = mapsExample.map.getBounds().getNorthEast();
        mapsExample.southWest = mapsExample.map.getBounds().getSouthWest();
        mapsExample.west = mapsExample.southWest.lng();
        mapsExample.width = mapsExample.northEast.lng() - mapsExample.west;
        mapsExample.south = mapsExample.southWest.lat();
        mapsExample.height = mapsExample.northEast.lat() - mapsExample.south;
        mapsExample.centre = mapsExample.map.getCenter();
        var centre = {
          lng: mapsExample.centre.lng(),
          lat: mapsExample.centre.lat()
        };
        var top = {
          lng: mapsExample.centre.lng(),
          lat: mapsExample.northEast.lat()
        };
        mapsExample.distanceInMetres = mapsExample.distance(centre, top);
        mapsExample.distanceInMiles = mapsExample.distanceInMetres / 1609.34;
    },
    
    radians: function(deg) {
        return deg * Math.PI / 180;
    },
    
    /*
     * Implements the Haversine formula. Modified version of an example from
     * http://www.movable-type.co.uk/scripts/latlong.html
     */
    distance: function(centre, top) {
        var R = 6371000; // metres
        var rad1 = mapsExample.radians(centre.lat);
        var rad2 = mapsExample.radians(top.lat);
        var deltaLat = mapsExample.radians(top.lat - centre.lat);
        var deltaLng = mapsExample.radians(top.lng - centre.lng);
        var a = Math.sin(deltaLat/2) * Math.sin(deltaLat/2) + Math.cos(rad1) * Math.cos(rad2) * Math.sin(deltaLng/2) * Math.sin(deltaLng/2);
        var c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        var d = R * c;
        return d;
    },
    
    updatePage: function() {
        console.log("Idle");
        if (mapsExample.lastZoomReset) {
            mapsExample.lastZoomReset = false;
    		console.log("Zoom constraint reached.");
        }
        else {
            console.log("Updating page.");
			document.getElementById("centre").innerHTML = mapsExample.centre;
			document.getElementById("ne").innerHTML = mapsExample.northEast;
			document.getElementById("sw").innerHTML = mapsExample.southWest;
			document.getElementById("zoom").innerHTML = mapsExample.zoom;
			document.getElementById("metres").innerHTML = mapsExample.distanceInMetres;
			document.getElementById("miles").innerHTML = mapsExample.distanceInMiles;
			for (var i = 0; i < mapsExample.addCircles; i++) {
				mapsExample.circles++;
				mapsExample.randomMarker(mapsExample.redCircle, "Circle " + mapsExample.circles);
			}
			for (var i = 0; i < mapsExample.addTriangles; i++) {
				mapsExample.triangles++;
				mapsExample.randomMarker(mapsExample.greenTriangle, "Triangle " + mapsExample.triangles);
			}
			for (var i = 0; i < mapsExample.addStars; i++) {
				mapsExample.stars++;
				mapsExample.randomMarker(mapsExample.blueStar, "Star " + mapsExample.stars);
			}
		}
    },
    
    randomMarker: function(icon, title) {
    	mapsExample.marker++;
    	var lat = (Math.random() * mapsExample.width) + mapsExample.west;
    	var lng = (Math.random() * mapsExample.height) + mapsExample.south;
    	var latlng = new google.maps.LatLng(lng, lat);
    	var marker = new google.maps.Marker({
            position: latlng,
            title: title,
            icon: icon
        });
        marker.setMap(mapsExample.map);
    },
    
    zoomChanged: function() {
        if (mapsExample.constrainZoom && mapsExample.map.zoom < mapsExample.minZoom) {
    		mapsExample.map.setZoom(mapsExample.minZoom);
    		mapsExample.lastZoomReset = true;
    		console.log("Zoom reset to minimum.");
        }
    }
    
};

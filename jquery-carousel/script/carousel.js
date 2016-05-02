var Carousel = function(settings) {
    this.id = "#carousel ul";
    this.leftButton = "#left";
    this.rightButton = "#right";
    this.waitTime = 5000;
    this.animateTime = 1000;
    this.animateDistance = 260;
    this.load(settings);
}
    
Carousel.prototype = {
    load: function(settings) {
		if (typeof settings != "undefined") {
			for (x in settings) {
				this[x] = settings[x];
			}
		}
    },
    
	clickLeft: function(event) {
		var self = event.data.context;
		var list = $(self.id);
		var distance = 0 - self.animateDistance;
		list.css({marginLeft: distance});
		var lastChild = list.find("li:last");
		list.prepend(lastChild);
		list.animate({marginLeft:0}, self.animateTime);
	},
	
	clickRight: function(event) {
		var self = event.data.context;
		var distance = 0 - self.animateDistance;	
		$(self.id).animate({marginLeft: distance}, self.animateTime, self.firstToLast);
	},

	timedRight: function() {
		var self = this;	
		var distance = 0 - self.animateDistance;
		$(self.id).animate({marginLeft: distance}, self.animateTime, self.firstToLast);
	},
	
	firstToLast: function() {
		var list = $(this);
		list.find("li:last").after(list.find("li:first"));
		list.css({marginLeft:0});
	},
				
	readyTimer: function() {
		var self = this;
		$(document).ready(function() {
			var t = setInterval(function() {
			    var distance = 0 - self.animateDistance;
				$(self.id).animate({marginLeft: distance}, self.animateTime, self.firstToLast); 
				}, self.waitTime);
		});
	},
	
	readyButtons: function() {
	   var self = this;
	   $(document).ready(function() {
		   $(self.leftButton).bind('click', {context: self}, self.clickLeft);
		   $(self.rightButton).bind('click', {context: self}, self.clickRight);
	   });
	}
}

var carousel = new Carousel();
carousel.readyButtons();

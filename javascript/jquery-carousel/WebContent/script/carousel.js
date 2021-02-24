var Carousel = function(settings) {
    this.id = "#carousel ul";
    this.pills = "#pills";
    this.activePillImage = "images/pill-active.png";
    this.inactivePillImage = "images/pill.png";
    this.leftButton = "#left";
    this.rightButton = "#right";
    this.fullSizeFrame = "#fullSizeFrame";
    this.fullSizePhoto = "#fullSizePhoto";
    this.fullSizeCaption = "#fullSizeCaption";
    this.fullSizeClose = "#fullSizeClose";
    this.waitTime = 5000;
    this.animateTime = 1000;
    this.animateDistance = 260;
    this.leftImage = 1;
    this.imageCount = 1;
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
		self.movePills(-1);
		var distance = 0 - self.animateDistance;
		list.css({marginLeft: distance});
		var lastChild = list.find("li:last");
		list.prepend(lastChild);
		list.animate({marginLeft:0}, self.animateTime);
	},
	
	clickRight: function(event) {
		var self = event.data.context;
		var distance = 0 - self.animateDistance;
		self.movePills(1);	
		$(self.id).animate({marginLeft: distance}, self.animateTime, self.firstToLast);
	},
	
	firstToLast: function() {
		var list = $(this);
		list.find("li:last").after(list.find("li:first"));
		list.css({marginLeft:0});
	},
	
	movePills: function(distance) {
		var pills = $(this.pills + " input");
		$(pills[this.leftImage - 1]).attr("src", this.inactivePillImage);
		this.leftImage += distance;
		if (this.leftImage < 1) {
			this.leftImage = this.imageCount + this.leftImage;
		}
		else if (this.leftImage > this.imageCount) {
			this.leftImage = this.leftImage - this.imageCount;
		}
		$(pills[this.leftImage - 1]).attr("src", this.activePillImage);
	},
	
	bindImageClick: function() {
		var self = this;
		var images = $(self.id + " img");
		var pills = $(self.pills + " input");
		self.imageCount = images.length;
		for (var i=0; i < self.imageCount; i++) {
			$(images[i]).bind('click', {context: self}, self.displayFullSize);
			$(pills[i]).bind('click', {context: self}, self.moveToImage);
		}
		$(self.fullSizeClose).bind('click', {context: self}, self.closeFullSize);
	},
	
	moveToImage: function(event) {
		var self = event.data.context;
		var imageSelected = $(this).attr("title");
		if (imageSelected > self.leftImage) {
			var moves = imageSelected - self.leftImage;
			for (i = 0; i < moves; i++) {
				self.clickRight(event);
			}
		}
		else if (imageSelected < self.leftImage) {
			var moves = self.leftImage - imageSelected;
			for (i = 0; i < moves; i++) {
				self.clickLeft(event);
			}
		}
	},
	
	displayFullSize: function(event) {
		var self = event.data.context;
		var fullsize = $(this).attr("data-fullsize");
		var title = $(this).attr("title");
		$(self.fullSizePhoto).attr("src", fullsize);
		$(self.fullSizeCaption).html(title);
		$(self.fullSizeFrame).show();
	},
	
	closeFullSize: function(event) {
		var self = event.data.context;
		$(self.fullSizeFrame).hide();
	},
				
	readyTimer: function() {
		var self = this;
		$(document).ready(function() {
			self.bindImageClick();
			var t = setInterval(function() {
			    self.movePills(1);	
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
		   self.bindImageClick();
	   });
	}
}

var carousel = new Carousel();
carousel.readyButtons();

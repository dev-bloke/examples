var express = require('express');
var router = express.Router();

var usercache = {
		
	cache : [],
	nextId : 0,
		
	create : function(firstName, lastName, email) {
		var user = {
			id : usercache.nextId++,
			firstName : firstName,
			lastName : lastName,
			email : email
		}
		usercache.cache[user.id] = user;
		return user;
	},

    get : function(id) {
    	return usercache.cache[id];
    },
    
    update : function(user) {
    	usercache.cache[user.id] = user;
    },
    
    remove : function(user) {
    	usercache.cache[user.id] = undefined;
    }
		
};

/* GET users listing. */
router.get('/', function(req, res, next) {
  res.send('respond with a resource');
});

module.exports = router;

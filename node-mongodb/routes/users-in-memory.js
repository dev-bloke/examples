var express = require('express');
var router = express.Router();

var usercache = require('./usercache');
var cache = usercache.UserCache();

cache.create("Martin","Ingram","martin@meridal.com");
cache.create("Dev","Bloke","dev.bloke@devbloke.me.uk");

/* GET all users. */
router.get('/', function(request, response) {
    response.json(cache.all());
});

/* GET by ID. */
router.get('/:id', function(request, response) {
    var id = parseInt(request.params.id);
    var user = cache.get(id);
    if (user != null) {
        response.json(user);
    }
    else {
        response.send(404);
    }
});

/*
 * POST a new user.
 */
router.post('/', function(request, response) {
    var user = request.body;
    var created = cache.create(user.firstName, user.lastName, user.email);
    response.json(created);
});

/*
 * PUT an updated user.
 */
router.put('/:id', function(request, response) {
	var id = parseInt(request.params.id);
	var update = request.body;
	var user = cache.update(id, update.firstName, update.lastName, update.email);
	if (user != null) {
	    response.json(user);
	}
	else {
	    response.send(404);
	}
});

/*
 * DELETE a user.
 */
router.delete('/:id', function(request, response) {
	var id = parseInt(request.params.id);
	if (cache.remove(id)) {
		response.send(200);
	}
	else {
		response.send(404);
	}
});

module.exports = router;

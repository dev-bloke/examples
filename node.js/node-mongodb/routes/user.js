var express = require("express");

var User = require("../models/user");

var router = express.Router();

/* Get all users, sorted by newest first. */

router.get("/", function(request, response, next) {
  User.find().allSortedbyCreateDate().exec(function(err, users) {
    if (err) {
      return next(err);
    }
    response.json(users);
  })
});

/* Get a user by email. */

router.get("/:email", function(request, response, next) {
  var email = request.params.email;
  User.find().byEmail(email).exec(function(err, user) {
    if (err) {
      return next(err);
    }
    if (user != null) {
      response.json(users);
    }
    else {
      response.send(404);
    }
  })
});

/*
 * POST a new user.
 */
router.post('/', function(request, response, next) {
  console.log(request.body);
  var user = new User(request.body);
  console.log(user);
  user.save(function(err, savedUser) {
	if (err) {
	  return next(err);
	}
	response.json(savedUser);
  });
});

/*
 * PUT an updated user.

router.put('/:email', function(request, response) {
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
*/

/*
 * DELETE a user.
 
router.delete('/:id', function(request, response) {
	var id = parseInt(request.params.id);
	if (cache.remove(id)) {
		response.send(200);
	}
	else {
		response.send(404);
	}
});
*/

module.exports = router;
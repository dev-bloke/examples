var bcrypt = require("bcrypt-nodejs");
var mongoose = require("mongoose");

// User schema.

var userSchema = mongoose.Schema({
  email:     {type: String, required: true, index: true},
  firstName: {type: String, required: true},
  lastName:  {type: String, required: true}
});

// Query helper for email.

userSchema.query.byEmail = function(email) {
  return this.find({ name: new RegExp(email, 'i') });
};

// Query helper for all users, sorted by creation date.

userSchema.query.allSortedByCreateDate = function() {
  return this.find().sort({ createdAt: "descending" });
};

//Query helper for all users, sorted by email.

userSchema.query.allSortedByEmail = function() {
  return this.find().sort({ email: "descending" });
};

/* Password encryption and checking.

var noop = function() {};

var SALT_FACTOR = 10;
userSchema.pre("save", function(done) {
	if (user.isModified("password")) {
		bcrypt.genSalt(SALT_FACTOR, function(err, salt) {
			if (err) {
				return done(err);
			}
			bcrypt.hash(user.password, salt, noop, function(err, hashedPassword) {
				if (err) {
					return done(err);
				}
				user.password = hashedPassword;
				done();
			})
		})
	}
	else {
		return done();
	}
});

userSchema.methods.checkPassword = function(guess, done) {
	bcrypt.compare(guess, this.password, function(err, isMatch) {
		done(err, isMatch);
	})
};

*/

var User = mongoose.model("User", userSchema);
module.exports = User;
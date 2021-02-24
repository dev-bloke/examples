function UserCache() {
    this.cache = [];
	this.nextId = 0;
}	

UserCache.prototype.add = function(id, firstName, lastName, email) {
	var user = {
	    id : id,
		firstName : firstName,
		lastName : lastName,
		email : email
	}
	this.cache[user.id] = user;
	return user;
};

UserCache.prototype.all = function() {
	var all = [];
	for (var i = 0; i < this.cache.length; i++) {
		if (this.cache[i] != null) {
			all.push(this.cache[i]);
		}
	}
    return all;
}

UserCache.prototype.create = function(firstName, lastName, email) {
    return this.add(this.nextId++, firstName, lastName, email);
}

UserCache.prototype.get = function(id) {
    return this.cache[id];
};

UserCache.prototype.exists = function(id) {
	return (id < this.cache.length && this.cache[id] != null);
};

UserCache.prototype.update = function(id, firstName, lastName, email) {
	var result = null;
	if (this.exists(id)) {
		var user = this.cache[id];
		user.firstName = firstName;
		user.lastName = lastName;
		user.email = email;
		result = user;
	}
    return result;
};
    
UserCache.prototype.remove = function(id) {
	var deleted = false;
    if (this.exists(id)) {
    	this.cache[id] = null;
    	deleted = true;
    }
    return deleted;
};

exports.UserCache = function() {
    return new UserCache();
};

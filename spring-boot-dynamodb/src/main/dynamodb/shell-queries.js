// Get a recording by ID.

var params = { 
    TableName: "recordings",
    Key: {
        "id": "d11e287a-1fd6-4a7b-8f5c-7b6b2af691e1"
    }
};

docClient.get(params, function(err, data) {
    if (err)
        console.log(JSON.stringify(err, null, 2));
    else
        console.log(JSON.stringify(data, null, 2));
});

// Get all the recordings.

var params = { 
	    TableName: "recordings"
	};

docClient.scan(params, function(err, data) {
	if (err)
	    console.log(JSON.stringify(err, null, 2));
	else
	    console.log(JSON.stringify(data, null, 2));
});

// Get a vehicle by ID.

var params = { 
    TableName: "vehicles",
    Key: {
        "make": "Ford",
        "model": "Focus ST"
    }
};

docClient.get(params, function(err, data) {
    if (err)
        console.log(JSON.stringify(err, null, 2));
    else
        console.log(JSON.stringify(data, null, 2));
});

// Get all the vehicles.

var params = { 
	    TableName: "vehicles"
	};

docClient.scan(params, function(err, data) {
	if (err)
	    console.log(JSON.stringify(err, null, 2));
	else
	    console.log(JSON.stringify(data, null, 2));
});
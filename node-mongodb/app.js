// Dependencies.

const bodyParser = require('body-parser');
const cookieParser = require('cookie-parser');
const express = require("express");
const favicon = require('serve-favicon');
const flash = require('connect-flash');
const http = require("http");
const logger = require("morgan");
const mongoose = require("mongoose");
const path = require("path");
const session = require('express-session');

// Routes.
const ui = require('./routes/ui');
const user = require('./routes/user');

var app = express();

// Connect to MongoDB.
mongoose.connect("mongodb://localhost:27017/examples");

// Morgan logger.
app.use(logger("short"));

// View engine setup.
var viewPath = path.resolve(__dirname, "views");
app.set('views', viewPath);
app.set('view engine', 'jade');
console.log("Views are being served from " + viewPath);

// Enable body and cookie parsing.
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: false }));
app.use(cookieParser());

// Support static content.
var staticPath = path.resolve(__dirname, "public");
console.log("Static content is being served from " + staticPath);
app.use(express.static(staticPath));

// Enable flash messaging.
app.use(flash());

//Enable routes.
app.use('/', ui);
app.use('/user', user);

// Catch 404 and forward to error handler.
app.use(function(req, res, next) {
  var err = new Error('Not Found');
  err.status = 404;
  next(err);
});

// The development error handler will print a stacktrace.
if (app.get('env') === 'development') {
  app.use(function(err, req, res, next) {
    res.status(err.status || 500);
    res.render('error', {
      message: err.message,
      error: err
    });
  });
}

// The production error handler ensures that no stacktraces are leaked to the user.
app.use(function(err, req, res, next) {
  res.status(err.status || 500);
  res.render('error', {
    message: err.message,
    error: {}
  });
});

http.createServer(app).listen(3000);
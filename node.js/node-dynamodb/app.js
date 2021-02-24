// Dependencies.
const express = require("express");
const logger = require("morgan");
const path = require("path");
const http = require("http");
const favicon = require('serve-favicon');
const cookieParser = require('cookie-parser');
const bodyParser = require('body-parser');

// Routes.
const routes = require('./routes/index');
const users = require('./routes/users');

var app = express();

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

// Enable routes.
app.use('/', routes);
app.use('/users', users);

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
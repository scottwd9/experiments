'use strict';

var express = require('express')
  , app = express()
  , search = require('./search');

app.set('view engine', 'ejs');
app.set('views', __dirname + '/views');
app.set('view options', { layout: false});

app.get('/', function(req, res) {
  res.render('index');
});

app.get('/search', function(req, res) {
  search(req.query.q, function(err, tweets) {
    if (err) { return; }
    res.render('search', {results: tweets, search: req.query.q});
  });
});

app.get('/echo/:say', function(req, res) {
  res.send({s: req.params.say});

});

app.listen(3000);

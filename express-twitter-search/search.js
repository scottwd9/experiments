'use strict';

var request = require('superagent');

module.exports = function search (query, fn) {
  request.get('http://search.twitter.com/search.json')
  .query( {q: query } )
  .end( function(res) {
    if (res.body && Array.isArray(res.body.results)) {
      return fn(null, res.body.results);
    }
    fn(new Error('bad twitter response'));
  });
};

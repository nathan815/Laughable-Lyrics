const searchCtrl = require('../controllers/search');

module.exports = function(app) {
  app.get('/search', searchCtrl.index);
};

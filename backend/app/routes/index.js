import searchCtrl from '../controllers/search.controller';

module.exports = function(app) {
  app.get('/search', searchCtrl.index);
};

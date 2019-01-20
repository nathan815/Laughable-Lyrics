const searchCtrl = require('../controllers/search');
const translationCtrl = require('../controllers/translation');

module.exports = function(app) {
  app.get('/search', searchCtrl.index);
  app.get('/song/:id', translationCtrl.song);
  app.get('/translations', translationCtrl.index);
  app.post('/translations', translationCtrl.create);
};

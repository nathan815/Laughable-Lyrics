const searchCtrl = require('../controllers/search');
const translationCtrl = require('../controllers/translation');
const songCtrl = require('../controllers/song');

module.exports = function(app) {
  app.get('/search', searchCtrl.index);
  app.get('/songs/:id', songCtrl.show);
  app.get('/translations', translationCtrl.index);
  app.get('/translations/:id', translationCtrl.show);
  app.post('/translations', translationCtrl.create);
};

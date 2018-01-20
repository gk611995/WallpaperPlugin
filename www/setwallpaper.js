var exec = require('cordova/exec');

exports.setImage = function (arg0, success, error) {
    exec(success, error, 'setwallpaper', 'setImage', [arg0]);
};

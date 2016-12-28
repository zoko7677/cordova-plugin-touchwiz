
var exec = require('cordova/exec');

var MdevicePlugin = {
    
    exitMdevice: function () {
        exec(null, null, "MdevicePlugin", "exitMdevice", []);
    },
    
    isInMdevice: function (callback) {
        if(/ios|iphone|ipod|ipad/i.test(navigator.userAgent)) {
            callback(false); // ios not supported - cannot be in kiosk
            return;
        }
        exec(function(out){
            callback(out == "true");
        }, function(error){
            alert("MdevicePlugin.isInMdevice failed: " + error);
        }, "MdevicePlugin", "isInMdevice", []);
    },
    
    isSetAsLauncher: function (callback) {
        if(/ios|iphone|ipod|ipad/i.test(navigator.userAgent)) {
            callback(false); // ios not supported - cannot be in kiosk
            return;
        }
        exec(function(out){
            callback(out == "true");
        }, function(error){
            alert("MdevicePlugin.isSetAsLauncher failed: " + error);
        }, "MdevicePlugin", "isSetAsLauncher", []);
    }
    
}

module.exports = MdevicePlugin;


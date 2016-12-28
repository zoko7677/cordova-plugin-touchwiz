Cordova Mdevice Mode
==================

Cordova plugin to create Cordova application with "kiosk mode" And edit by zoko7677. 
App with this plugin can be set as Android launcher.
If app starts as launcher, it blocks hardware buttons and statusbar,
so the user cannot close the app until the app request it.

Escape from app with this plugin is possible only using javascript call `KioskPlugin.exitKiosk()`
or by uninstalling app using `adb`. (Keeping USB debug allowed recommended.)
If applications starts as usual (not as launcher), no restrictions are applied.

* Official plugin website: https://github.com/honza889/cordova-plugin-kiosk
* Example app: https://github.com/honza889/cordova-kiosk-demo

**Note for iOS:** This plugin is for Android only for now. Support of iOS would be useless, because this feature is built in iOS as Guided Access (see Settings - General - Accessibility - Guided Access)

About
-----

By adding this Cordova plugin the Cordova app becomes the the homescreen (also known as launcher) of Android device and will block any atempt of user to escape.

To add plugin into existing Cordova / Phonegap application:

    cordova plugin add https://github.com/honza889/cordova-plugin-kiosk.git

The `AndroidManifest.xml` should be updated immediately. If not, you can force it by removing and re-adding Android platform:

    cordova platform rm android
    cordova platform add android

To it work user have to set this application as launcher (see below) and start it by pressing Home button.

**WARNING** Before installation ensure you have USB debug mode enabled. Without it you can have problem to remove app from device.

Exiting from Kiosk mode using Javascript:

    KioskPlugin.exitKiosk();

If the app is running in kiosk mode can be detected too:

    KioskPlugin.isInKiosk(function(isInKiosk){ ... });

For complete example see: https://github.com/honza889/cordova-kiosk-demo

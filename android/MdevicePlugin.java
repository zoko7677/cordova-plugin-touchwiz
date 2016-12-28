package jk.cordova.plugin.mdevice;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import org.apache.cordova.*;
import android.widget.*;
import android.view.Window;
import android.view.View;
import android.view.WindowManager;
import android.view.KeyEvent;
import android.view.ViewGroup.LayoutParams;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONArray;
import org.json.JSONException;
import jk.cordova.plugin.mdevice.MdeviceActivity;
import org.json.JSONObject;

public class MdevicePlugin extends CordovaPlugin {
    
    public static final String EXIT_MDEVICE = "exitMdevice";
    public static final String IS_IN_MDEVICE = "isInMdevice";
    public static final String IS_SET_AS_LAUNCHER = "isSetAsLauncher";
    
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        try {
            if (IS_IN_MDEVICE.equals(action)) {
                
                callbackContext.success(Boolean.toString(MdeviceActivity.running));
                return true;
                
            } else if (IS_SET_AS_LAUNCHER.equals(action)) {
                
                String myPackage = cordova.getActivity().getApplicationContext().getPackageName();
                callbackContext.success(Boolean.toString(myPackage.equals(findLauncherPackageName())));
                return true;
                
            } else if (EXIT_MDEVICE.equals(action)) {
                
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                
                Intent chooser = Intent.createChooser(intent, "Select destination...");
                if (intent.resolveActivity(cordova.getActivity().getPackageManager()) != null) {
                    cordova.getActivity().startActivity(chooser);
                }
                
                callbackContext.success();
                return true;
            }
            callbackContext.error("Invalid action");
            return false;
        } catch(Exception e) {
            System.err.println("Exception: " + e.getMessage());
            callbackContext.error(e.getMessage());
            return false;
        }
    }
    
    private String findLauncherPackageName() {
        final Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        final ResolveInfo res = this.cordova.getActivity().getPackageManager().resolveActivity(intent, 0);
        return res.activityInfo.packageName;
    }
}


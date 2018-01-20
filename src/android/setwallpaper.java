package cordova.plugin.setwallpaper;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.app.WallpaperManager;
import android.content.Context;
import java.io.IOException;
import android.os.Build;

import java.lang.Byte;
/**
 * This class echoes a string called from JavaScript.
 */
public class setwallpaper extends CordovaPlugin {
	public Context context = null;
    private static final boolean IS_AT_LEAST_LOLLIPOP = Build.VERSION.SDK_INT >= 21;
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
    context = IS_AT_LEAST_LOLLIPOP ? cordova.getActivity().getWindow().getContext() : cordova.getActivity().getApplicationContext();       
        if (action.equals("setImage")) {
            String message = args.getString(0);
            Bitmap myBitmapAgain = this.decodeBase64(message, callbackContext, context);
            return true;
        }
        return false;
        
    }

    private void coolMethod(String message, CallbackContext callbackContext) {
        if (message != null ) {
            callbackContext.success(message);
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }
    public static Bitmap decodeBase64(String input, CallbackContext callbackContext, Context context)
    {
           byte[] decodedBytes = Base64.decode(input, 0);
           WallpaperManager myWallpaperManager = WallpaperManager.getInstance(context);
           Bitmap yeyBitmapAgain = BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.length);
           try {
           myWallpaperManager.setBitmap(yeyBitmapAgain);
           }
           		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
           return BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.length);
    }
}

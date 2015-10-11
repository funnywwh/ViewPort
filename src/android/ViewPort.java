package com.tangide.viewport;

import android.util.Log;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;
import android.webkit.WebSettings;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.engine.SystemWebView;

public class ViewPort extends CordovaPlugin {
    private static final String LOG_TAG = "ViewPort";

    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
		
        super.initialize(cordova, webView);
        final SystemWebView swv = (SystemWebView) webView.getView();
        swv.post(new Runnable() {
            @Override
            public void run() {            	
				WebSettings ws = swv.getSettings();
				ws.setUseWideViewPort(true); 
				ws.setLoadWithOverviewMode(true);
				swv.reload();
    			Log.d(LOG_TAG, "ViewPort Enabled");
            }
        });
    }

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
    	Log.d(LOG_TAG, "No Method In This Plugin");
        return false;
    }
}

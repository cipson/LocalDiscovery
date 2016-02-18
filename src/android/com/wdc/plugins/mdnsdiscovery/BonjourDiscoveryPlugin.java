package com.wdc.plugins.mdnsdiscovery;

import android.content.Context;
import android.util.Log;

import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaInterface;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Copyright 2015 Western Digital Corporation. All rights reserved.
 */
public class BonjourDiscoveryPlugin extends CordovaPlugin  {
    private static final String TAG = BonjourDiscoveryPlugin.class.getName();
    private static final String COMMAND_START_SCAN = "start_scan";
    private static final String COMMAND_STOP_SCAN = "stop_scan";

    private DeviceScanner mDeviceScanner;

    private Context mContext;
    private CallbackContext callbackContext;

    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
        this.mContext = this.cordova.getActivity();
        mDeviceScanner = new DeviceScanner();
    }

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackCxt) throws JSONException {
        Log.e(TAG, "Cordova action "+action);
        this.callbackContext = callbackCxt;
        if (scanner == null){
            callbackContext.failure("scanner is null");
            return false;
        }

        if (action.equals(COMMAND_START_SCAN)) {
            scanner.openDmc(mActivity, new DeviceScanner.DeviceScannerListener() {
                @Override
                public void onSuccess(DNSDevice[] deviceList) {
                    if (deviceList != null){
                        for (int i = 0;i <deviceList.length;i++){
                            Log.d(tag, (deviceList[i].getIpAddress());
                        }
                        if (callbackContext != null){
                            callbackContext.success(deviceList);
                        }
                    }
                }

                @Override
                public void onFailure(String reason) {
                    callbackContext.failure(reason);
                }
            });
            return true;
        } else if (action.equals(COMMAND_STOP_SCAN)){
            scanner.closeDmc();
            return true;
        }
        return false;
    }
}

package com.sgoldm.plugin.joinImages;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.Base64;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import java.io.ByteArrayOutputStream;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.cordova.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Class that joins two images together using an Android Canvas and Bitmap.
 *
 * @author ocarty
 */
public class JoinImages extends CordovaPlugin {
    
    public static final String ACTION_JOIN_IMAGES_FROM_DATA = "joinImagesFromData";        
      
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        
        if (action.equals(ACTION_JOIN_IMAGES_FROM_DATA)) {
            String mes = joinImagesFromData(args);
            callbackContext.success(mes);
            return true;
        }        
        else {
            callbackContext.error("Invalid action");
            return false;
        }
    }
       
    private String joinImagesFromData(JSONArray args) {
        String hostName = "192.168.0.106";
        String userName = "it.duy";
		String passWord = "duy123";        
		FTPClient ftpClient = new FTPClient();
		try {
			ftpClient.connect(hostName, 21);
			boolean success = ftpClient.login(userName, passWord);
			if(success == true) {
				return "Login success";
			}
			else {
				return "Login failed";
			}
		}
		catch (Exception ex) {
            return "Connect server failed. Check connect internet." + ex.getMessage();
        }		        
    }        
}

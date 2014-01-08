package org.project.Test_ACS;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import com.appcelerator.cloud.sdk.*;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Login extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

    }

         public boolean performsignin(){
            boolean boolSuccess = false;
            ACSClient sdk = new ACSClient("iGXpZFRj2XCl9Aixrig80d0rrftOzRef");

            Map<String, Object> dataMap = new HashMap<String, Object>();
            dataMap.put("login", ((EditText) findViewById(R.id.login_user)).getText().toString());
            dataMap.put("password", ((EditText) findViewById(R.id.login_pass)).getText().toString());

            try {
                CCResponse response;
                response = sdk.sendRequest("users/login.json", CCRequestMethod.POST, dataMap);
                CCMeta meta = response.getMeta();
                if("ok".equals(meta.getStatus())
                        && meta.getCode() == 200
                        && "loginUser".equals(meta.getMethod())){
                    boolSuccess = true;
                }
                else{
                    boolSuccess = false;
                }
            } catch (ACSClientError e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return boolSuccess;
        }
}
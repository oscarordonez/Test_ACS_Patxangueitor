package org.project.Test_ACS;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.EditText;
import com.appcelerator.cloud.sdk.ACSClient;
import com.appcelerator.cloud.sdk.ACSClientError;
import com.appcelerator.cloud.sdk.CCRequestMethod;
import com.appcelerator.cloud.sdk.CCResponse;

import java.io.IOException;
import java.util.HashMap;
import java.lang.String;

public class SignUp extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        View signupButton = findViewById(R.id.signup);
        signupButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                performSignup();
                //Creamos el Intent
                Intent intent = new Intent(SignUp.this, ShowUsers.class);
                //Creamos la información a pasar entre actividades
                Bundle b = new Bundle();
                b.putString("User",((EditText) findViewById(R.id.first_name)).getText().toString());

                //Añadimos la información al intent
                intent.putExtras(b);

                //Iniciamos la nueva actividad
                startActivity(intent);
            }});
        View cancelButton = findViewById(R.id.cancel);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                finish();
            }});

        View showusersButton = findViewById(R.id.showusers);
        showusersButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                finish();
            }});
    }

    public void performSignup(){
        /*ACSClient sdk = new ACSClient("2tBiyjAxSafR75JYp6GwA3lqLUoVXJsv","ait42yYpNvsK5p592dMwed5CwCOer8MR");*/
        ACSClient sdk = new ACSClient("iGXpZFRj2XCl9Aixrig80d0rrftOzRef");

        String firstName = ((EditText) findViewById(R.id.first_name)).getText().toString();
        String lastName = ((EditText) findViewById(R.id.last_name)).getText().toString();
        String email = ((EditText) findViewById(R.id.email_address)).getText().toString();
        String password = ((EditText) findViewById(R.id.pw)).getText().toString();

        HashMap<String, Object> dataMap = new HashMap<String, Object>();
        dataMap.put("username", firstName);
        dataMap.put("email", email);
        dataMap.put("password", password);
        dataMap.put("password_confirmation", password);
        dataMap.put("first_name", firstName);
        dataMap.put("last_name", lastName);

        try {
            CCResponse response = sdk.sendRequest("users/create.json", CCRequestMethod.POST, dataMap);
            /*Intent intent = new Intent();
            setResult(RESULT_OK, intent);
            JSONObject jsonResponse = response.getResponseData();*/
        } catch (ACSClientError e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

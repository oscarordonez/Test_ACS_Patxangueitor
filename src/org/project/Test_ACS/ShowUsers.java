package org.project.Test_ACS;

import android.app.Activity;
import android.view.View;
import android.content.Intent;
import android.os.Bundle;

public class ShowUsers extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.users);

        View signupButton = findViewById(R.id.signup);
        signupButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                performSignup();
            }});

    }


}

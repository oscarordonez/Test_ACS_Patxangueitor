package org.project.Test_ACS;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainScreen extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainscreen);

        //Recuperamos la información pasada en el intent
        Bundle bundle = this.getIntent().getExtras();

        Toast toast1 =
                Toast.makeText(getApplicationContext(),
                        bundle.getString("Status"), Toast.LENGTH_LONG);
        toast1.show();
    }
}
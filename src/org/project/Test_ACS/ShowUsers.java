package org.project.Test_ACS;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowUsers extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.users);

        //Localizar los controles
        TextView txtOkCreation = (TextView)findViewById(R.id.textViewUser);

        //Recuperamos la información pasada en el intent
        Bundle bundle = this.getIntent().getExtras();

        //Construimos el mensaje a mostrar
        txtOkCreation.setText("Se ha creado el usuario: " + bundle.getString("User"));
    }


}

package com.example.jota.login2;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


public class Registro3 extends Activity{

    Spinner comida;
    String[] datos = {"sushi","pizza","comida italiana", "comida rapida"};
    Spinner diversion;
    String[] datos2 = {"cine","arte","conciertos","pintura","fotografia"};
    Spinner pasatiempo;
    String[] datos3 = {"pesca","Trekking","Camping","Casino","Futbol","Natacion","Seminario"};
    Spinner vestuario;
    String[] datos4 = {"Urbano","Freestyle","Formal","Deportivo","FormalSport"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro3);

        comida = (Spinner) findViewById(R.id.lista1);
        diversion = (Spinner) findViewById(R.id.lista2);
        pasatiempo = (Spinner) findViewById(R.id.lista3);
        vestuario = (Spinner) findViewById(R.id.lista4);

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, datos);
        comida.setAdapter(adaptador);

        ArrayAdapter<String> adaptador2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, datos2);
        diversion.setAdapter(adaptador2);

        ArrayAdapter<String> adaptador3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, datos3);
        pasatiempo.setAdapter(adaptador3);

        ArrayAdapter<String> adaptador4 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, datos4);
        vestuario.setAdapter(adaptador4);

        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Registro3.this, Registro4.class));
            }
        });

    }






    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_registro3, menu);
        return true;
    }


}

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


public class Registro4 extends Activity{

    Spinner temaDeInteres;
    String[] datos1a = {"Tendencia","Moda","Politica", "Deportes","Ciencia","Arte","Cultura","Crimen"};
    Spinner lugarDeInteres;
    String[] datos1b = {"Fantasilandia","Parques","Museos", "Biblitecas","Hipodromo","Estadio"};
    Spinner bebidas;
    String[] datos1c = {"Jugos naturales","Cerveza","Aperitivos", "Refresacantes","Energizantes","Adelgazantes","Te","Café"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro4);

        temaDeInteres = (Spinner) findViewById(R.id.lista1a);
        lugarDeInteres = (Spinner) findViewById(R.id.lista1b);
        bebidas = (Spinner) findViewById(R.id.lista1c);

        ArrayAdapter<String> adaptador1a = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, datos1a);
        temaDeInteres.setAdapter(adaptador1a);
        ArrayAdapter<String> adaptador1b = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, datos1b);
        lugarDeInteres.setAdapter(adaptador1b);
        ArrayAdapter<String> adaptador1c = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, datos1c);
        bebidas.setAdapter(adaptador1c);
        findViewById(R.id.button6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Registro4.this, Registrofin.class));
            }
        });


    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_registro4, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

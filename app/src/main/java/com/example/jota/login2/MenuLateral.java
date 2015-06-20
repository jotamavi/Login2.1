package com.example.jota.login2;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.ActionBarActivity;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

import java.io.FileReader;


public class MenuLateral extends ActionBarActivity{
    private String[] opciones;
    private DrawerLayout drawerLayout;
    private ListView listView;
    private CharSequence tituloSec;
    private CharSequence tituloApp;
    private ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_lateral);

        opciones = new String[]{"Perfil", "Mis Lugares", "Configuración", "Salir"};
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        listView = (ListView) findViewById(R.id.menuIzq);

        listView.setAdapter(new ArrayAdapter<String>(getSupportActionBar().getThemedContext(),
                android.R.layout.simple_list_item_1, opciones));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Fragment fragment = null;
                if (position == 0) {
                    fragment = new FragmentPerfil();
                }
                if (position == 1) {
                    fragment = new FragmentMisLugares();
                }
                if (position == 2) {
                    fragment = new FragmentConfiguracion();
                }

                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.container, fragment)
                        .commit();

                listView.setItemChecked(position, true);
                tituloSec = opciones[position];
                getSupportActionBar().setTitle(tituloSec);
                drawerLayout.closeDrawer(listView);


            }
        });

        tituloSec = getTitle();
        tituloApp = getTitle();


        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.drawable.ic_action_action_view_headline,
                R.string.abierto,
                R.string.cerrado) {

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                ActivityCompat.invalidateOptionsMenu(MenuLateral.this);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                ActivityCompat.invalidateOptionsMenu(MenuLateral.this);
            }

        };

        drawerLayout.setDrawerListener(drawerToggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        findViewById(R.id.button7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuLateral.this, MainMap.class));
            }
        });
    }

            @Override
            public boolean onCreateOptionsMenu(Menu menu){
               // if(!mNavigationDrawerFragment.isDrawerOpen()){

                    getMenuInflater().inflate(R.menu.menu_lateral,menu);
                    //restoreActionBar();
                    return true;
                }
               // return super.onCreateOptionsMenu(menu);


                @Override
                public boolean onOptionsItemSelected(MenuItem item){

                        if(drawerToggle.onOptionsItemSelected(item)){
                        return true;}


                    int id= item.getItemId();



                    if(id==R.id.action_settings){
                        return true;
                    }

                    return super.onOptionsItemSelected(item);
                }


                @Override
                protected void onPostCreate(Bundle savedInstanceState) {
                    super.onPostCreate(savedInstanceState);
                    drawerToggle.syncState();
                }

                @Override
                public void onConfigurationChanged(Configuration newConfig) {
                    super.onConfigurationChanged(newConfig);
                    drawerToggle.onConfigurationChanged(newConfig);
                }
            }
package com.example.mytallerdomingo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;




import com.google.android.material.navigation.NavigationView;



public class MainActivity extends AppCompatActivity implements  NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout myDrawer;
    NavigationView myNav;
    Toolbar myToolbar;




    ActionBarDrawerToggle toogle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDrawer = findViewById(R.id.myDrawer);
        myNav = findViewById(R.id.myNavigationView);
        myToolbar = findViewById(R.id.myToolbar);




        setSupportActionBar(myToolbar);
        myNav.setNavigationItemSelectedListener(this);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.myFrame, new Fragment1())
                .commit();
        setTitle("Registro de revision");


        toogle = setDrawerToogle();
        myDrawer.addDrawerListener(toogle);


    }

    private ActionBarDrawerToggle setDrawerToogle() {
        return new ActionBarDrawerToggle(this, myDrawer, myToolbar, R.string.drawer_open, R.string.drawer_close);    }


    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        toogle.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        toogle.syncState();
    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (toogle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    

    
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        //para mostrar los fragmentos
       FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();



        switch (item.getItemId()) {
            case R.id.item_Registro:
                ft.replace(R.id.myFrame, new Fragment1()).commit();
                break;
            case R.id.item_Busqueda:
                    //setContentView(R.layout.activity_nuevo);
                ft.replace(R.id.myFrame,new Fragment2()).commit();

             break;

            case R.id.item_Revision:
                ft.replace(R.id.myFrame, new Fragment3()).commit();
                break;
            case R.id.item_Eliminacion:
                ft.replace(R.id.myFrame, new Fragment4()).commit();
                break;
        }
        setTitle(item.getTitle()); //para mostrar el título
        myDrawer.closeDrawers(); //para cerrar drawer
        return true;
    }





}
package com.example.telebook.Home.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.telebook.Contacts.view.Contacts;
import com.example.telebook.EventPage.View.ListOfEvents;
import com.example.telebook.Helper.SharedPrefs;
import com.example.telebook.RegisterRoom.Room_Description;
import com.example.telebook.R;
import com.example.telebook.Settings.View.SettingsPage;
import com.example.telebook.Tracking.View.Tracking_Vertical;

public class Sample extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
SharedPrefs sharedPrefs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);
        sharedPrefs = new SharedPrefs(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Home");
        TextView head_name=(TextView)findViewById(R.id.name_nav);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Intent nav;

        switch(id)
        {
            case(R.id.nav_roomrequest):
                nav=new Intent(Sample.this, Room_Description.class);
                startActivity(nav);
                break;
            case(R.id.nav_events):
                nav=new Intent(Sample.this, ListOfEvents.class);
                startActivity(nav);

                break;
            case(R.id.nav_history):


                break;
            case(R.id.nav_settings):
                nav=new Intent(Sample.this,SettingsPage.class);
                startActivity(nav);
                break;
            case(R.id.nav_tracking):
                nav=new Intent(Sample.this, Tracking_Vertical.class);
                startActivity(nav);
                break;
            case(R.id.nav_contacts):
                nav=new Intent(Sample.this, Contacts.class);
                startActivity(nav);
                break;
            case(R.id.nav_developers):
                nav=new Intent(Sample.this, Contacts.class);
                startActivity(nav);
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

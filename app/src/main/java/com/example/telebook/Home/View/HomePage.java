package com.example.telebook.Home.View;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import android.widget.ProgressBar;

import com.example.telebook.NavigationDrawer.NavigationDrawer;
import com.example.telebook.R;

/**
 * Created by iket on 22/9/16.
 */

public class HomePage extends Activity implements NavigationDrawer.FragmentDrawerListener {
    private NavigationDrawer navigationDrawer;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        toolbar=(Toolbar)findViewById(R.id.toolbar);

        navigationDrawer = (NavigationDrawer)getFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);

        navigationDrawer.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);
        navigationDrawer.setDrawerListener(this);

    }

    @Override
    public void onDrawerItemSelected(View view, int position) {

    }
}



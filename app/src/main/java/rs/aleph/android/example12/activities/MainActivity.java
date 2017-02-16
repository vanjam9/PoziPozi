package rs.aleph.android.example12.activities;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ShareActionProvider;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;


import rs.aleph.android.example12.R;

// Each activity extends Activity class
public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private ListView drawerList;
    private ActionBarDrawerToggle drawerToggle;
    private RelativeLayout drawerPane;
    private CharSequence drawerTitle;
    private ArrayList<NavigationItem> drawerItems = new ArrayList<NavigationItem>();

    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItemFromDrawer(position);
        }
    }

    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

    setSupportActionBar(toolbar);

    final android.support.v7.app.ActionBar actionBar = getSupportActionBar();

    if(actionBar!=null)

    {
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_drawer);
        actionBar.setHomeButtonEnabled(true);
        actionBar.show();
    }


    drawerItems.add(newNavigationItem(getString(R.string.drawer_home),getString(R.string.drawer_home_long),R.drawable.ic_action_product));
    drawerItems.add(newNavigationItem(getString(R.string.drawer_settings),getString(R.string.drawer_settings_long),R.drawable.ic_action_settings));

    drawerTitle=getTitle();

    drawerLayout=(DrawerLayout)findViewById(R.id.drawerLayout);

    drawerList=(ListView)findViewById(R.id.navList);

    // Populates NavigtionDrawer with options
    drawerPane=(RelativeLayout)findViewById(R.id.drawerPane);

    DrawerAdapter adapter = new DrawerAdapter(this, drawerItems);

    // Sets a custom shadow that overlays the main content when NavigationDrawer opens
    drawerLayout.setDrawerShadow(R.drawable.drawer_shadow,GravityCompat.START);
    drawerList.setOnItemClickListener(newDrawerItemClickListener());
    drawerList.setAdapter(adapter);

    drawerToggle=new

    ActionBarDrawerToggle(
            this,                           /* host Activity */
            drawerLayout,                   /* DrawerLayout object */
            toolbar,                        /* nav drawer image to replace 'Up' caret */
            R.string.drawer_open,           /* "open drawer" description for accessibility */
            R.string.drawer_close           /* "close drawer" description for accessibility */
    ) {
        public void onDrawerClosed (View view){
            getSupportActionBar().setTitle(drawerTitle);
            invalidateOptionsMenu();        // Creates call to onPrepareOptionsMenu()
        }

    public void onDrawerOpened(View drawerView) {
        getSupportActionBar().setTitle(drawerTitle);
        invalidateOptionsMenu();        // Creates call to onPrepareOptionsMenu()
    }
};


@Override
protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast toast=Toast.makeText(getBaseContext(),"MainActivity.onCreate()",Toast.LENGTH_SHORT);
        toast.show();


// onCreate method is a lifecycle method called when he activity is starting

// ATTENTION: This was auto-generated to implement the App Indexing API.
// See https://g.co/AppIndexing/AndroidStudio for more information.


final List<String>jelaNames=JeloProvajder.getJelaNames();

        // Creates an ArrayAdaptar from the array of String
        ArrayAdapter<String>dataAdapter=new ArrayAdapter<String>(this,R.layout.list_item,jelaNames);
        ListView listView=(ListView)findViewById(R.id.listaJela);

        // Assigns ArrayAdaptar to ListView
        listView.setAdapter(dataAdapter);

        // Starts the SecondActivity and sends it the selected URL as an extra data
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()

        {

public void onItemClick(AdapterView<?>parent,View view,int position,long id){
        Intent intent=new Intent(MainActivity.this,SecondActivity.class);
        intent.putExtra("position",position);
        startActivity(intent);
        }


        }

        );


@Override
public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
        }

// onOptionsItemSelected method is called whenever an item in the Toolbar is selected.
@Override
public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
        case R.id.action_create:
        Toast.makeText(this,"Action "+getString(R.string.fragment_master_action_create)+" executed.",Toast.LENGTH_SHORT).show();
        break;
        case R.id.action_update:
        Toast.makeText(this,"Action "+getString(R.string.fragment_detal_action_update)+" executed.",Toast.LENGTH_SHORT).show();
        break;
        case R.id.action_delete:
        Toast.makeText(this,"Action "+getString(R.string.fragment_detal_action_delete)+" executed.",Toast.LENGTH_SHORT).show();
        break;
        }

        return super.onOptionsItemSelected(item);
        }
@Override
public void setTitle(CharSequence title){
        getSupportActionBar().setTitle(title);
        }

@Override
protected void onPostCreate(Bundle savedInstanceState){
        super.onPostCreate(savedInstanceState);

//        Sync the toggle state after onRestoreInstanceState has occurred.
        drawerToggle.syncState();
        }

// onConfigurationChanged method is called when the device configuration changes to pass configuration change to the drawer toggle
@Override
public void onConfigurationChanged(Configuration configuration){
        super.onConfigurationChanged(configuration);

        // Pass any configuration change to the drawer toggle
        drawerToggle.onConfigurationChanged(configuration);
        }

private void selectItemFromDrawer(int position){

        if(position==0){
        // FirstActivity is already shown
        }else if(position==1){
        Intent settings=new Intent(FirstActivity.this,SettingsActivity.class);
        startActivity(settings);
        }

        drawerList.setItemChecked(position,true);
        setTitle(drawerItems.get(position).getTitle());
        drawerLayout.closeDrawer(drawerPane);
        }
        }
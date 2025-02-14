package com.rafi.accommodationmaster;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Home extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;

    ImageView imageMenu;

    @SuppressLint({"MissingInflatedId", "NonConstantResourceId"})
    @Override
    
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);
        FirebaseAuth auth = FirebaseAuth.getInstance();
        FirebaseUser user = auth.getCurrentUser();

        if (user == null) {
            Intent intent = new Intent(getApplicationContext(), Login.class);
            startActivity(intent);
            finish();
        }
        setContentView(R.layout.activity_home);

        // Navagation Drawar------------------------------
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_View);
        imageMenu = findViewById(R.id.imageMenu);

        toggle = new ActionBarDrawerToggle(Home.this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Drawar click event
        // Drawer item Click event ------
        navigationView.setNavigationItemSelectedListener(item -> {

            switch (item.getItemId()) {
                case R.id.Home:
                    Intent intent = new Intent(getApplicationContext(),Home.class);
                    startActivity(intent);
                    drawerLayout.closeDrawers();
                    break;

                case R.id.about:
                    Intent intent2 = new Intent(getApplicationContext(),AboutUs.class);
                    startActivity(intent2);
                    drawerLayout.closeDrawers();
                    break;

                case R.id.setting:

                case R.id.profile:
                    //FirebaseAuth.getInstance().signOut();
                    Intent intent3 = new Intent(getApplicationContext(),Home.class);
                    startActivity(intent3);
                    Toast.makeText(Home.this, "Clicked", Toast.LENGTH_SHORT).show();

                    drawerLayout.closeDrawers();
                    break;


                case R.id.logout:
                    FirebaseAuth.getInstance().signOut();
                    Intent intent4 = new Intent(getApplicationContext(),Login.class);
                    startActivity(intent4);
                    finish();

                    Toast.makeText(Home.this, "Logout", Toast.LENGTH_SHORT).show();

                    drawerLayout.closeDrawers();
                    break;

            }

            return false;
        });

        //------------------------------

        // ------------------------
        // App Bar Click Event
        imageMenu = findViewById(R.id.imageMenu);

        imageMenu.setOnClickListener(view -> {
            // Code Here
            drawerLayout.openDrawer(GravityCompat.START);
        });

        Button rent_Btn= findViewById(R.id.rent_Btn);

        rent_Btn.setOnClickListener(v -> {
            Toast.makeText(Home.this,"Clicked",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Home.this, rent_and_post.class);
            startActivity(intent);
        });



        Button find_mateBtn = findViewById(R.id.find_mateBtn);

        find_mateBtn.setOnClickListener(v -> {
            Toast.makeText(Home.this,"Clicked",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Home.this, finding_mate.class);
            startActivity(intent);
        });

        Button buy_houseBtn = findViewById(R.id.buy_Btn);

        buy_houseBtn.setOnClickListener(v -> {
            Toast.makeText(Home.this,"Clicked",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Home.this,buy_house.class);
            startActivity(intent);
        });


    }
}

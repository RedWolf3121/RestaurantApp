package com.example.dani.restaurantapp;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    /**
     * para gestionar cada uno de los fragmentos
     * */
    private SectionsPagerAdapter mSectionsPagerAdapter;
    /**
     * Para alojar el contenido de cada fragment
     * */
    private ViewPager mViewPager;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //inicializamos
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);


       findViewById(R.id.registro).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText correo = (EditText)findViewById(R.id.email_register);
                String email = correo.getText().toString();

                if (email.isEmpty()){
                    Context context = getApplicationContext();
                    CharSequence text = "Introduce un correo valido";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }else {
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference myRef = database.getReference(email);

                }
            }
        });
    }

    /**
     * Clase que devolvera un fragment segun la seccion donde se encuentre
     * */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {
        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch(position){
                case 0: return LoginFragment.newInstance();
                case 1: return RegistroFragment.newInstance();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 2;//tenemos dos fragment
        }

    }

}
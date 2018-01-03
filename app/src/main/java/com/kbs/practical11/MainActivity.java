package com.kbs.practical11;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    public static final String pref_name="PR11_PREF_NM";
    public static final String pref_key_name="name";
    public static final String pref_key_city="city";
    SharedPreferences spsettings;
    SharedPreferences.Editor editor;

    EditText etname,etcity;
    Button btnsave;
    TextView tvval1,tvval2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Control initialization
        etname=(EditText)findViewById(R.id.etname);
        etcity=(EditText)findViewById(R.id.etcity);
        btnsave=(Button)findViewById(R.id.btnsave);
        tvval1=(TextView)findViewById(R.id.tvvalue1);
        tvval2=(TextView)findViewById(R.id.tvvalue2);
    }

    public void saveSharedPrefData(View v)
    {
        //getting values from control
        String sname,city;
        sname=etname.getText().toString();
        city=etcity.getText().toString();

        //Save Data into Preferences
        spsettings=getApplication().getSharedPreferences(pref_name, Context.MODE_PRIVATE);
        editor=spsettings.edit();
        editor.putString(pref_key_name,sname);
        editor.putString(pref_key_city,city);
        editor.commit();
        Toast.makeText(MainActivity.this, "Preferences Saved", Toast.LENGTH_SHORT).show();
    }

    public void getSharedPrefData(View v)
    {
        spsettings=getApplicationContext().getSharedPreferences(pref_name,Context.MODE_PRIVATE);
        editor=spsettings.edit();
        String name=spsettings.getString(pref_key_name,"");
        String city=spsettings.getString(pref_key_city,"");
        editor.commit();
        tvval1.setText(name.toString());
        tvval2.setText(city.toString());
        Toast.makeText(MainActivity.this, "Preferences loaded", Toast.LENGTH_SHORT).show();

    }
    public void clearSharedPrefData(View v)
    {
        spsettings=getApplicationContext().getSharedPreferences(pref_name,Context.MODE_PRIVATE);
        editor=spsettings.edit();
        editor.clear();
        editor.commit();
        Toast.makeText(MainActivity.this, "Shared Preferences Cleared", Toast.LENGTH_SHORT).show();

    }
    public void removeSharedPrefData(View v)
    {
        spsettings=getApplicationContext().getSharedPreferences(pref_name,Context.MODE_PRIVATE);
        editor=spsettings.edit();
        editor.remove(pref_key_city);
        editor.commit();
        Toast.makeText(MainActivity.this, "City Shared Preferences Removed.", Toast.LENGTH_SHORT).show();
    }
}

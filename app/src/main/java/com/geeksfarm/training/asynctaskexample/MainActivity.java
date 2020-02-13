package com.geeksfarm.training.asynctaskexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

import com.geeksfarm.training.asynctaskexample.adapter.AddressesAdapter;
import com.geeksfarm.training.asynctaskexample.model.Contact;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TextView tvName, tvGender;
    private RecyclerView rvAddresses;

    private Contact contact;

    private AddressesAdapter addressesAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvName = findViewById(R.id.tv_person_name);
        tvGender = findViewById(R.id.tv_person_gender);
        rvAddresses = findViewById(R.id.rv_addresses);

        deserializeJSON();

        tvName.setText(contact.getName());
        tvGender.setText(contact.getGender());

        addressesAdapter = new AddressesAdapter(this, contact.getAddresses());

        rvAddresses.setAdapter(addressesAdapter);
        rvAddresses.setLayoutManager(new GridLayoutManager(this, 1));

        Toast.makeText(this, String.valueOf(addressesAdapter.getItemCount()), Toast.LENGTH_LONG).show();



    }


    private void deserializeJSON(){
        String json = loadJsonFromFile();
        try {
            JSONObject personJson = new JSONObject(json);
            String name = personJson.getString("nama");
            String gender = personJson.getString("jk");

            JSONArray addressesJson = personJson.getJSONArray("listAlamat");

            ArrayList<Contact.Address> addresses = new ArrayList<>();

            for(int i=0;i< addressesJson.length();i++){

                JSONObject addressJson = addressesJson.getJSONObject(i);

                String addressName = addressJson.getString("namaAlamat");
                String addressDetail = addressJson.getString("alamatLengkap");
                String city = addressJson.getString("namaKota");
                String postalCode = addressJson.getString("kodePos");

                Contact.Address address = new Contact.Address(addressName,addressDetail,city,postalCode);

                addresses.add(address);
            }

           this.contact = new Contact(name,gender,addresses);

        }
        catch (JSONException err){
            err.printStackTrace();
            Toast.makeText(this, "gagal",Toast.LENGTH_LONG).show();

        }

    }




    private String loadJsonFromFile(){
        String json = null;
        try {
            InputStream is = getResources().openRawResource(R.raw.data);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

}

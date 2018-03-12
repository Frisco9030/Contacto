package com.example.frisco.contacto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Contacto> contactos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contactos = new ArrayList<Contacto>();

        contactos.add(new Contacto("Francisco Ramírez", "987535717","frisco9030@gmail.com","300990","Alto y guapo :v"));
        contactos.add(new Contacto("Elmer Curio", "987654321","Elmercurio@gmail.com","251212","Quimico Mezclador"));
        contactos.add(new Contacto("Elba Lazo", "231564897", "Elbalazogmail.com","051185","Experto en Armas"));
        contactos.add(new Contacto("Soila Vaca", "335566889","VacaLechera@gmail.com","121212","Granjera de profesion"));
        contactos.add(new Contacto("Elco Dazo", "999666333","Codazo@gmail.com","151018","Ahorrador y puñete"));

        ArrayList<String> nombresContacto = new ArrayList<>();
        for (Contacto contacto: contactos) {
            nombresContacto.add(contacto.getNombre());
        }
        
        ListView lstContactos = (ListView) findViewById(R.id.lstContactos);
        lstContactos.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nombresContacto));

        lstContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent= new Intent(MainActivity.this, DetalleContacto.class);
                intent.putExtra(getResources().getString(R.string.pnombre),contactos.get(position).getNombre());
                intent.putExtra(getResources().getString(R.string.ptelefono),contactos.get(position).getTelefono());
                intent.putExtra(getResources().getString(R.string.pemail),contactos.get(position).getEmail());
                intent.putExtra(getResources().getString(R.string.pdescripcion),contactos.get(position).getDescripcion());
                startActivity(intent);
            }
        });
    }
}

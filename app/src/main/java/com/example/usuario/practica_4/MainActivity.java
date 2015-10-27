package com.example.usuario.practica_4;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ArrayAdapter<String> adaptador;
    ListView lstNombres;

    private Lista_Entrada[] datos =
            new Lista_Entrada[] {
                    new Lista_Entrada(R.drawable.hotel, "Hoteles", "Los Mejores Hoteles en Guatape"),
                    new Lista_Entrada(R.drawable.bar,"Bares","Los Mejores Bares de Guatape"),
                    new Lista_Entrada(R.drawable.sitios,"Sitios Turisticos","Los Lugares que no puedes dejar de Visitar"),
                    new Lista_Entrada(R.drawable.demog,"Demografia","Conoce algo mas de este Hermoso Pueblo")};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Adapter adaptador = new Adapter(this, datos);

        lstNombres=(ListView) findViewById(R.id.LST);

        lstNombres.setAdapter(adaptador);

        lstNombres.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String seleccion = ((Lista_Entrada) parent.getItemAtPosition(position)).getNombre();
                Toast.makeText(MainActivity.this, seleccion, Toast.LENGTH_SHORT).show();

                if(seleccion=="Hoteles")
                {
                    Intent i = new Intent(getApplicationContext(), Main2Activity.class);
                    startActivity(i);
                }
                if(seleccion=="Bares")
                {
                    Intent i = new Intent(getApplicationContext(), BaresActivity.class);
                    startActivity(i);
                }
                if(seleccion=="Sitios Turisticos")
                {
                    Intent i = new Intent(getApplicationContext(),SitiosActivity.class );
                    startActivity(i);
                }
                if(seleccion=="Demografia")
                {
                    Intent i = new Intent(getApplicationContext(),DemografiaActivity.class );
                    startActivity(i);
                }
            }
        });

    }



    public class Adapter extends ArrayAdapter<Lista_Entrada> {

        public Adapter(Context context, Lista_Entrada[] datos) {
            super(context, R.layout.layout_item, datos);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.layout_item, null);

            TextView nombre = (TextView) item.findViewById(R.id.tNombre);
            nombre.setText(datos[position].getNombre());

            TextView descripcion = (TextView) item.findViewById(R.id.tDescripcion);
            descripcion.setText(datos[position].getDescripcion());

            ImageView imagen = (ImageView) item.findViewById(R.id.imagen);
            imagen.setImageResource(datos[position].getiImagen());

            return item;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent i = new Intent(getApplicationContext(),AboutActivity.class );
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

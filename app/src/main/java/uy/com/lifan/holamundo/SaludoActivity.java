package uy.com.lifan.holamundo;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.sql.ResultSet;
import java.util.ArrayList;

import uy.com.lifan.holamundo.DB.DB;
import uy.com.lifan.holamundo.DB.Querys;

public class SaludoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saludo);

        ArrayList<String> lista = getLista();


        //Localizar los controles
        TextView TxtSaludo = (TextView)findViewById(R.id.TxtSaludo);

        //Recuperamos la información pasada en el intent
        Bundle bundle = this.getIntent().getExtras();

        //Construimos el mensaje a mostrar

         TxtSaludo.setText("Hola " + bundle.getString("NOMBRE") + lista.get(1));
        Button BtnMapa = (Button)findViewById(R.id.BtnMapa);

        //Implementamos el evento click del botón
        BtnMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creamos el Intent
                Intent intent =
                        new Intent(SaludoActivity.this, MapsActivity.class);

                //Iniciamos la nueva actividad
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_saludo, menu);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public ArrayList<String> getLista(){
        DB db = new DB();//base
        ArrayList<String> lista = new ArrayList<>();
        try {
            ResultSet resultSet = db.select(Querys.USUARIOS_ACTIVOS);
            if (resultSet != null){
                while (resultSet.next()){

                    lista.add(resultSet.getString("value"));


                }
            }
        }catch (Exception ex){
            //falta capturar la excepcion
            db=null;
        }
        return lista;
    }
}

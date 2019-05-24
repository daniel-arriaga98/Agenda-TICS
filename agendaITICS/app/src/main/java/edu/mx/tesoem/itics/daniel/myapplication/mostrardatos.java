package edu.mx.tesoem.itics.daniel.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.OutputStreamWriter;

public class mostrardatos extends AppCompatActivity {

    TextView lblnombre, lblusuario, lblcontra, lblcorreo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrardatos);

        Bundle parametros = this.getIntent().getExtras();
        setContentView(R.layout.activity_mostrardatos);
        lblnombre = (TextView) findViewById(R.id.editText9);
        lblusuario = (TextView) findViewById(R.id.editText10);
        lblcontra = (TextView) findViewById(R.id.editText11);
        lblcorreo = (TextView) findViewById(R.id.editText12);

        lblnombre.setText(parametros.getString("nombre").toString());
        lblusuario.setText(parametros.getString("usuario").toString());
        lblcontra.setText(parametros.getString("contra").toString());
        lblcorreo.setText(parametros.getString("correo").toString());
    }

    public void btnguardar(View v){
        guardar(lblnombre.getText().toString() + "," + lblusuario.getText().toString() + "," + lblcontra.getText().toString() + "," + lblcorreo.getText().toString());
        cargaactividad();
    }

    public void guardar(String dato){
        try{
            OutputStreamWriter archivo = new OutputStreamWriter(openFileOutput("Datos.txt", Context.MODE_APPEND));
            archivo.write(dato + "\n");
            archivo.close();
            Toast.makeText(this, "Se grabo la informacion correctamente", Toast.LENGTH_SHORT).show();
        }catch (Exception ex){
            Log.e("Error","Error al escribir archivo");
        }
    }




    public void regresar(View v){

        cargaactividad();
    }

    private void cargaactividad(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        this.finish();
    }

}

package edu.mx.tesoem.itics.daniel.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.OutputStreamWriter;

public class resgistrarse extends AppCompatActivity {
    EditText txtnombre, txtusuario, txtpass, txtcorreo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resgistrarse);
        txtnombre = (EditText) findViewById(R.id.editText);
        txtusuario = (EditText) findViewById(R.id.editText2);
        txtpass = (EditText) findViewById(R.id.editText3);
        txtcorreo = (EditText) findViewById(R.id.editText5);
    }

    public void btnguardar(View v){
        guardar(txtnombre.getText().toString() + "," + txtusuario.getText().toString() + "," + txtpass.getText().toString() + "," + txtcorreo.getText().toString());
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

    public void regresa(View v){

        cargaactividad();
    }

    private void cargaactividad(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        this.finish();
    }

}

package ab.caride.saferoute;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import ab.caride.saferoute.TelasJava.AdministrarRota;
import ab.caride.saferoute.TelasJava.Database;
import ab.caride.saferoute.TelasJava.NovaRota;

public class VisaoCasa extends AppCompatActivity {

    Database helper;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visao_casa);


        helper = new Database(this);
        db = helper.getWritableDatabase();
    }


    //ÁREA DO USUÁRIO
    public void OnClickbuttonAdminUsuario (View view){

        Intent ca_admin_users = new Intent(this, AdministracaoUsuario.class);
        startActivity(ca_admin_users);
    }



    //ÁREA DAS ROTAS
    public void OnClickbuttonAdminRotas (View view){

        Intent call_activity_admin_rotas = new Intent(this, AdministrarRota.class);
        startActivity(call_activity_admin_rotas);
    }


    public void OnClickbuttonEmDesenvolvimento (View view){
        Toast.makeText(this, "EM DESENVOLVIMENTO", Toast.LENGTH_SHORT).show();
    }




}

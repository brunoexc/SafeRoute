package ab.caride.saferoute.TelasJava;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import ab.caride.saferoute.R;
import ab.caride.saferoute.VisaoCarro;
import ab.caride.saferoute.VisaoCasa;
import ab.caride.saferoute.VisaoMonitoramento;

public class MenuPrincipal extends AppCompatActivity {

    Database helper;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        helper = new Database(this);
        db = helper.getWritableDatabase();

    }


    //ÁREA DO USUÁRIO
    public void OnClickbuttonInterfaceCasa (View view){

        Intent ca_new_user = new Intent(this, VisaoCasa.class);
        startActivity(ca_new_user);
    }

    public void OnClickbuttonInterfaceCarro (View view){

         Intent ca_new_user = new Intent(this, VisaoCarro.class);
         startActivity(ca_new_user);
    }

    public void OnClickbuttonInterfaceMonitoramento (View view){

        Intent ca_new_user = new Intent(this, VisaoMonitoramento.class);
        startActivity(ca_new_user);
    }

    public void OnClickbuttonEmDesenvolvimento (View view){
        Toast.makeText(this, "EM DESENVOLVIMENTO", Toast.LENGTH_SHORT).show();
    }
}

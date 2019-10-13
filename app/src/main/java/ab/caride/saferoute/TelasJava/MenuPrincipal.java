package ab.caride.saferoute.TelasJava;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import ab.caride.saferoute.R;

public class MenuPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

    }


    //ÁREA DO USUÁRIO
    public void OnClickbuttonNovoUsuario (View view){

        //Intent ca_new_user = new Intent(this, CreateUserActivity.class);
       // ca_new_user.putExtra("cad_edi", 0);
       // startActivity(ca_new_user);
    }
    public void OnClickbuttonAdminUsuario (View view){

        // Intent ca_admin_users = new Intent(this, UserAdministrationActivity.class);
        // startActivity(ca_admin_users);
    }


    //ÁREA DAS ROTAS
    public void OnClickbuttonNovaRota (View view){

        Intent ca_nova_rota = new Intent(this, NovaRota.class);
        //ca_nova_rota.putExtra("cad_edi", 0);
        startActivity(ca_nova_rota);
    }

    public void OnClickbuttonAdminRotas (View view){

        //Intent call_activity_admin_rotas = new Intent(this, ProductAdministrationActivity.class);
        //startActivity(call_activity_admin_rotas);
    }




    public void OnClickbuttonEmDesenvolvimento (View view){
        Toast.makeText(this, "EM DESENVOLVIMENTO", Toast.LENGTH_SHORT).show();
    }
}

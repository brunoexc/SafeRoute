package ab.caride.saferoute.TelasJava;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import ab.caride.saferoute.R;

public class NovaRota extends AppCompatActivity {

    Button botao_teste;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nova_rota);

        botao_teste = (Button) findViewById(R.id._teste_fora_da_rota);
    }



    public void OnClickbuttonTesteForaRota (View view){

        botao_teste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), PopupSenhaApp.class);
                startActivity(i);
            }
        });
    }


}

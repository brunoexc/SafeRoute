package ab.caride.saferoute;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import ab.caride.saferoute.TelasJava.NovaRota;

public class VisaoCarro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visao_carro);
    }

    public void OnClickbuttonNovaRota (View view){

        Intent ca_nova_rota = new Intent(this, VisaoCarro.class);
        startActivity(ca_nova_rota);
    }
}

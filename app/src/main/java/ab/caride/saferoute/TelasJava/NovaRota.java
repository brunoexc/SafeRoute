package ab.caride.saferoute.TelasJava;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.net.URL;

import ab.caride.saferoute.Controladores.StreetController;
import ab.caride.saferoute.Controladores.UserController;
import ab.caride.saferoute.Interface.ITarefa_Callback;
import ab.caride.saferoute.R;
import ab.caride.saferoute.Services.PostLocation;


public class NovaRota extends AppCompatActivity implements ITarefa_Callback{

    Button botao_teste;
    URL url_post;
    TextView retornoURL;
    public TarefaPost tarefaPost;
    public UserController controller;
    StreetController stController;
    Intent it;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nova_rota);

        //retornoURL = findViewById(R.id.retornoURL);

        botao_teste = findViewById(R.id._teste_fora_da_rota);

        it = new Intent(this, PostLocation.class);

        stController = new StreetController(this);
        stController.PreencheBase();

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


    public void OnClickbuttonEnviaPost (View view){
        /*
        controller = new UserController(this);
        //"https://www.googleapis.com/geolocation/v1/geolocate?key=AIzaSyBEu4I72p1g51gwCocF54cRbf2VBvbfD_o"
        //"https://maps.googleapis.com/maps/api/geocode/json?latlng=40.714224,-73.961452&key=AIzaSyBEu4I72p1g51gwCocF54cRbf2VBvbfD_o"
        tarefaPost =  new TarefaPost();
        tarefaPost.chamada = 0;
        tarefaPost.callback = this;
        tarefaPost.execute(controller.CriarJson());*/

        Toast.makeText(getApplicationContext(), "Iniciado upload de rota! Conferir no Device Explorer", Toast.LENGTH_LONG).show();
        startService(it);
    }


    public void OnClickbuttonPararServiço (View view){
        Toast.makeText(getApplicationContext(), "Iniciado upload de rota! Conferir no Device Explorer", Toast.LENGTH_LONG).show();
    }


    @Override
    public void retornoCallback(int code) {
        Toast.makeText(getApplicationContext(), "Retorno: " + code, Toast.LENGTH_SHORT).show();
        retornoURL.setText("Retorno: " + code);
    }
}

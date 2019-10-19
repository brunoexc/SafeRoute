package ab.caride.saferoute.TelasJava;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.sql.ClientInfoStatus;

import ab.caride.saferoute.Interface.ITarefa_Callback;
import ab.caride.saferoute.R;

public class NovaRota extends AppCompatActivity implements ITarefa_Callback{

    Button botao_teste;
    URL url_post;
    TextView retornoURL;
    public TarefaPost tarefaPost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nova_rota);

        retornoURL = findViewById(R.id.retornoURL);

        botao_teste = findViewById(R.id._teste_fora_da_rota);
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

        tarefaPost =  new TarefaPost();
        tarefaPost.chamada = 0;
        tarefaPost.callback = this;
        tarefaPost.execute("Teste Envio");

    }


    @Override
    public void retornoCallback(int code) {
        Toast.makeText(getApplicationContext(), "Retorno: " + code, Toast.LENGTH_SHORT).show();
        retornoURL.setText("Retorno: " + code);
    }
}

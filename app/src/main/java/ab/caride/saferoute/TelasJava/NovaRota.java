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

import ab.caride.saferoute.R;

public class NovaRota extends AppCompatActivity {

    Button botao_teste;
    URL url_post;
    TextView retornoURL;

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


        try {
            url_post = new URL("http://google.com.br/");

            HttpURLConnection client = (HttpURLConnection) url_post.openConnection();

            String urlParameters = "search?q=Bruno+Caride+Dutra&oq=Bruno+Caride+Dutra&aqs=chrome..69i57j69i60.2354j0j7&sourceid=chrome&ie=UTF-8";

            client.setRequestMethod("POST");
            client.setRequestProperty("USER-AGENT","Chrome/77.0");
            client.setRequestProperty("ACCEPT-LANGUAGE","pt-BR, pt, 0.5");

            client.setDoOutput(true);
            DataOutputStream dStream = new DataOutputStream(client.getOutputStream());

            dStream.writeBytes(urlParameters);
            dStream.flush();
            dStream.close();

            int responseCode = client.getResponseCode();
            String output = "Request URL" + url_post;
            output += System.getProperty("line.separator") + "Request Paramaeters " + urlParameters;
            output += System.getProperty("line.separator") + "Response Code " + responseCode;



            BufferedReader bReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            String line = "";
            StringBuilder responseOutput = new StringBuilder();

            while ((line = bReader.readLine()) != null){
                responseOutput.append(line);
            }
            bReader.close();

            output += System.getProperty("line.separator") + responseOutput.toString();

            retornoURL.setText(output);

            /*
            OutputStream opsPost = new BufferedOutputStream(client.getOutputStream());
            writeStream(opsPost);
            opsPost.flush();
            opsPost.close();*/

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}

package ab.caride.saferoute.TelasJava;

import android.os.AsyncTask;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class TarefaPost extends AsyncTask<String, Void, Integer> {

    public String ipServidor;
    public String portaServidor;
    public int chamada, retorno;
    public NovaRota callback;
    //public SincronizaDados callback;
    URL url;
    HttpURLConnection urlConnection;
    BufferedInputStream reader;
    PrintStream printStream;




    @Override
    protected Integer doInBackground(String... params) {
        retorno = 0;
        urlConnection = null;
        BufferedInputStream reader = null;
        try {

            ipServidor = "192.168.0.17";
            portaServidor = "8080";

            rotaPost(chamada, params[0]);

        } catch (Exception e) {
            e.printStackTrace();
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return retorno;
    }

    public void rotaPost(int chamada, String... params) throws IOException {

        PrintStream printStream;
        switch (chamada){

            case 0:
               // url = new URL("http://"+ ipServidor +":"+ portaServidor +"/usuarios");
               // url = new URL("http://httpbin.org/post");
                url = new URL("https://poc-iot-labs.azure-devices.net/devices/poc-iot-device-1/messages/events?api-version=2016-02-03");

                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestProperty("Authorization", "SharedAccessSignature sr=poc-iot-labs.azure-devices.net&sig=je3g1FYzl7JjdT1o869lwCsEG4kMv2QX59Z%2BxOU2DQA%3D&se=1603143321&skn=iothubowner");
                urlConnection.setRequestMethod("POST");//
                urlConnection.setReadTimeout(15000);
                urlConnection.setConnectTimeout(15000);

                printStream = new PrintStream(urlConnection.getOutputStream());
                printStream.println(params[0]);

                urlConnection.connect();
                retorno = urlConnection.getResponseCode();

                break;


            case 1:
                // url = new URL("http://"+ ipServidor +":"+ portaServidor +"/usuarios");
                // url = new URL("http://httpbin.org/post");
                url = new URL("https://poc-iot-labs.azure-devices.net/devices/poc-iot-device-2/messages/events?api-version=2016-02-03");

                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestProperty("Authorization", "SharedAccessSignature sr=poc-iot-labs.azure-devices.net&sig=je3g1FYzl7JjdT1o869lwCsEG4kMv2QX59Z%2BxOU2DQA%3D&se=1603143321&skn=iothubowner");
                urlConnection.setRequestMethod("POST");//
                urlConnection.setReadTimeout(15000);
                urlConnection.setConnectTimeout(15000);

                printStream = new PrintStream(urlConnection.getOutputStream());
                printStream.println(params[0]);

                urlConnection.connect();
                retorno = urlConnection.getResponseCode();

                break;
        }

    }

    @Override
    protected void onPostExecute(Integer code) {
        //id_texto.setText(String.valueOf(s));

        if(callback != null)
            callback.retornoCallback(code);
    }


}

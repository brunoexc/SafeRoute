package ab.caride.saferoute.TelasJava;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ab.caride.saferoute.R;

public class PopupSenhaApp extends Activity {

    Button but_senha1, but_senha2, but_senha3, but_senha4, but_senha5, but_senha6, but_senha7, but_senha8, but_senha9;
    EditText txt_input_senha;
    int senha_tamanho;
    String botao_clicado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_senha_app);

        DisplayMetrics dm = new DisplayMetrics();

        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.9), (int)(height*.8));

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.CENTER;
        params.x = 0;
        params.y = -20;

        getWindow().setAttributes(params);

        but_senha1 = findViewById(R.id.but_senha_1);
        but_senha2 = findViewById(R.id.but_senha_2);
        but_senha3 = findViewById(R.id.but_senha_3);
        but_senha4 = findViewById(R.id.but_senha_4);
        but_senha5 = findViewById(R.id.but_senha_5);
        but_senha6 = findViewById(R.id.but_senha_6);
        but_senha7 = findViewById(R.id.but_senha_7);
        but_senha8 = findViewById(R.id.but_senha_8);
        but_senha9 = findViewById(R.id.but_senha_9);
        txt_input_senha = findViewById(R.id.txt_input_senha);
        senha_tamanho = 6;
        botao_clicado = "";

    }

    public void BotaoSelecionado (){

        if(txt_input_senha.getText().equals("")){
            txt_input_senha.setText(botao_clicado);
        }else{
            if(txt_input_senha.length() <= senha_tamanho){
                txt_input_senha.setText(txt_input_senha.getText() + botao_clicado);
            }
            else{
            }
        }
    }

    public void OnclickbuttonButSenha1(View view){
        botao_clicado = "1";
        BotaoSelecionado();
    }

    public void OnclickbuttonButSenha2(View view){
        botao_clicado = "2";
        BotaoSelecionado();
    }

    public void OnclickbuttonButSenha3(View view){
        botao_clicado = "3";
        BotaoSelecionado();
    }

    public void OnclickbuttonButSenha4(View view){
        botao_clicado = "4";
        BotaoSelecionado();
    }

    public void OnclickbuttonButSenha5(View view){
        botao_clicado = "5";
        BotaoSelecionado();
    }

    public void OnclickbuttonButSenha6(View view){
        botao_clicado = "6";
        BotaoSelecionado();
    }

    public void OnclickbuttonButSenha7(View view){
        botao_clicado = "7";
        BotaoSelecionado();
    }

    public void OnclickbuttonButSenha8(View view){
        botao_clicado = "8";
        BotaoSelecionado();
    }


    public void OnclickbuttonButSenha9(View view){
        botao_clicado = "9";
        BotaoSelecionado();
    }

    public void OnclickbuttonApagar (View view){

        String senha_atual = txt_input_senha.getText().toString();

        if(!senha_atual.isEmpty()){
            txt_input_senha.setText(senha_atual.substring(0, senha_atual.length() - 1));
        }else{
            Toast.makeText(this, "Não existe senha digitada!", Toast.LENGTH_SHORT).show();
        }
    }






}

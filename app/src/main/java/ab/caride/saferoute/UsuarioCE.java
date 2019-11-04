package ab.caride.saferoute;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ab.caride.saferoute.Classes.Users;
import ab.caride.saferoute.Controladores.UserController;
import ab.caride.saferoute.Interface.ITarefa_Callback;
import ab.caride.saferoute.TelasJava.Database;
import ab.caride.saferoute.TelasJava.TarefaPost;

public class UsuarioCE extends AppCompatActivity implements View.OnClickListener, ITarefa_Callback {

    UserController controller;
    Users db_user;

    int input_id, cad_edi, id_user;
    public String input_name, input_user, input_pass_app, input_pass_rota, input_pass_emergencia;
    Boolean valida_user;

    public EditText get_name, get_user, get_pass_app, get_pass_rota, get_pass_emergencia;
    public Button troca_botao;

    Database helper;
    //TarefaPost tarefa_p;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_ce);

        intent = getIntent();

        controller = new UserController(this);

        //Tratar tela para receber cadastro ou edição de usuários
        cad_edi = intent.getIntExtra("cad_edi", 0);

        //Verifica se a chamada da Activity é para editar ou cadastrar
        if(cad_edi == 1){
            //Usuário que será lido do banco/lista para editar
            id_user = intent.getIntExtra("user_id", 0);
            db_user = new Users();
            db_user = controller.lista.get(id_user - 1);
        }

        helper = new Database(this);

        //Acha os campos do formulário para cadastrar ou editar
        get_name = findViewById(R.id.txt_input_NomeUsuario);
        get_user = findViewById(R.id.txt_input_LoginApp);
        get_pass_app = findViewById(R.id.txt_input_PassAppUsuario);
        get_pass_rota =  findViewById(R.id.txt_input_PassRotaUsuario);
        get_pass_emergencia =  findViewById(R.id.txt_input_PassEmergUsuario);

        //Identifica se a chamada da Activity é para cadastrar ou editar
        troca_botao = findViewById(R.id.but_Cadastrar);
        troca_botao.setOnClickListener(this);

        //Tratar campos obrigatórios
        valida_user = false;

        botaoCadastroEditar();
    }

    @Override
    public void onClick(View v) {

        switch (cad_edi){
            //cad_edi = 0 (Significa que estou querendo cadastrar)
            case 0:
                OnClickbuttonCadastrar(v);
                break;

            //cad_edi = 1 (Significa que estou querendo editar um cadastro)
            case 1:
                AtualizaUsuario();
                break;
        }
    }


    public void botaoCadastroEditar(){

        if(cad_edi == 0){
            troca_botao.setText("Cadastrar");
        }else{
            get_user.setText(db_user.user);
            get_name.setText(db_user.name);
            get_pass_app.setText(db_user.pass_app);
            get_pass_rota.setText(db_user.pass_rota);
            get_pass_emergencia.setText(db_user.pass_emergencia);

            troca_botao.setText("Salvar");
        }
    }


    public void OnClickbuttonCadastrar (View view){

        input_name = get_name.getText().toString();
        input_user = get_user.getText().toString();
        input_pass_app = get_pass_app.getText().toString();
        input_pass_rota = get_pass_rota.getText().toString();
        input_pass_emergencia = get_pass_emergencia.getText().toString();

        valida_user = verificaObrigatórios(input_name, input_user, input_pass_app, input_pass_rota, input_pass_emergencia, valida_user);

        if (valida_user){
            controller.SaveUser(input_name, input_user, input_pass_app, input_pass_rota, input_pass_emergencia);
            Toast.makeText(this, "Usuário: "+ input_name.toUpperCase() + " cadastrado!", Toast.LENGTH_SHORT).show();
            finish();
        }
        else{
            Toast.makeText(getApplicationContext(), "Favor Preencher Todos os Campos", Toast.LENGTH_SHORT).show();
        }
    }


    public void AtualizaUsuario(){

        input_id = db_user.id;
        input_name = get_name.getText().toString();
        input_user = get_user.getText().toString();
        input_pass_app = get_pass_app.getText().toString();
        input_pass_rota = get_pass_rota.getText().toString();
        input_pass_emergencia = get_pass_emergencia.getText().toString();

        valida_user = verificaObrigatórios(input_name, input_user, input_pass_app, input_pass_rota, input_pass_emergencia, valida_user);

        if (valida_user){
            controller.UpdateUser(input_id, input_name, input_user, input_pass_app, input_pass_rota, input_pass_emergencia);
            Toast.makeText(this, "Usuário Atualizado!", Toast.LENGTH_SHORT).show();
            finish();
        }
        else{
            Toast.makeText(getApplicationContext(), "Favor Preencher Campos Obrigatórios(*)", Toast.LENGTH_SHORT).show();
        }
    }



    public Boolean verificaObrigatórios(String name, String user, String pass_app, String pass_rota, String pass_emerg, Boolean valida){

        if (name.trim().equals("") || user.trim().equals("") || pass_app.trim().equals("") || pass_rota.trim().equals("") || pass_emerg.trim().equals(""))
        {
            valida = false;
        }
        else{
            valida = true;
        }
        return valida;
    }

    @Override
    public void retornoCallback(int code) {
        Toast.makeText(getApplicationContext(), "Retorno: " + code, Toast.LENGTH_SHORT).show();
    }





}

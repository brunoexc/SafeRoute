package ab.caride.saferoute;

import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import ab.caride.saferoute.Adaptadores.AdaptadorUsuario;
import ab.caride.saferoute.Classes.Users;
import ab.caride.saferoute.Controladores.UserController;
import ab.caride.saferoute.Interface.ITarefa_Callback;
import ab.caride.saferoute.TelasJava.Database;
import ab.caride.saferoute.TelasJava.TarefaPost;

public class AdministracaoUsuario extends AppCompatActivity implements ITarefa_Callback {

    public UserController controller;
    public Users user;
    public AdaptadorUsuario adapter;
    public ListView listView;
    String[] DeleteArray;
    ArrayAdapter<String> adapter_m_delete;

    public TextView selected_user;
    public int id_user;
    TarefaPost tarefaPost;
    Database helper;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administracao_usuario);

        controller = new UserController(this);

        listView = findViewById(R.id.list_Users);
        adapter = new AdaptadorUsuario(this, controller.lista);
        listView.setAdapter(adapter);

        selected_user = findViewById(R.id.txt_input_AU_UsuarioSelecionado);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                user = controller.lista.get(position);
                SelecionaLista(user);
                id_user = user.id;
            }
        });
        adapter.notifyDataSetChanged();
    }

    public void SelecionaLista (Users user){
        selected_user.setText(user.name);
    }


    public void AlertaDelete(View view){

        if (user != null) {
            DeleteArray = getResources().getStringArray(R.array.SystemMessageDelete);
            adapter_m_delete = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, DeleteArray);

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setMessage(adapter_m_delete.getItem(0) + user.name + " ?");

            alertDialogBuilder.setCancelable(false);

            alertDialogBuilder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    controller.DeleteUser(user);
                    controller.carregarLista();
                    selected_user.setText("");
                    adapter.notifyDataSetChanged();
                    Toast.makeText(AdministracaoUsuario.this, "Usuário " + user.name + " deletado", Toast.LENGTH_SHORT).show();

                }
            });
            alertDialogBuilder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(AdministracaoUsuario.this, "Operação Cancelada!", Toast.LENGTH_SHORT).show();
                    dialog.cancel();
                }
            });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }else{

            Toast.makeText(AdministracaoUsuario.this, "Nenhum Usuário Selecionado!", Toast.LENGTH_SHORT).show();
        }
    }

    public void OnClickbuttonEditarUsuario (View view){

        if(user != null){
            Intent ca_create_user = new Intent(this, UsuarioCE.class);
            ca_create_user.putExtra("cad_edi", 1);
            ca_create_user.putExtra("user_id", id_user);
            startActivity(ca_create_user);
            finish();
        }else{
            Toast.makeText(AdministracaoUsuario.this, "Nenhum usuário selecionado!", Toast.LENGTH_SHORT).show();
        }
    }

    public void OnClickbuttonCadastrarUsuario (View view){

        Intent ca_create_user = new Intent(this, UsuarioCE.class);
        ca_create_user.putExtra("cad_edi", 0);
        startActivity(ca_create_user);
        finish();
    }



    @Override
    public void retornoCallback(int code) {
        Toast.makeText(getApplicationContext(), "Retorno: " + code, Toast.LENGTH_SHORT).show();
    }








}

package ab.caride.saferoute.Controladores;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Button;
import android.widget.EditText;


import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;

import ab.caride.saferoute.Classes.Users;
import ab.caride.saferoute.TelasJava.Database;
import ab.caride.saferoute.TelasJava.TarefaPost;

public class UserController {


    private Context context;
    public ArrayList<Users> lista, lista_servidor;
    SQLiteDatabase db;
    Cursor cursor;
    Calendar calendario;
    SimpleDateFormat timeNow;
    Database helper;




    public UserController(Context context) {
        this.context = context;
        lista = new ArrayList<>();
        lista_servidor = new ArrayList<>();

        helper = new Database(this.context);
        db = helper.getWritableDatabase();

        calendario = Calendar.getInstance();
        timeNow = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        timeNow.setTimeZone(TimeZone.getTimeZone("Brazil/East"));

        carregarLista();
    }

    public void SaveUser (String name, String user, String passapp, String passrota, String passemerg){

        Users usuario = new Users();
        usuario.name = name;
        usuario.user  = user;
        usuario.pass_app = passapp;
        usuario.pass_rota = passrota;
        usuario.pass_emergencia = passemerg;

        lista_servidor.add(usuario);

        SQLiteDatabase db = helper.getWritableDatabase();
        try{
            ContentValues cv = new ContentValues();
            cv.put("name", usuario.name);
            cv.put("user", usuario.user);
            cv.put("passApp", usuario.pass_app);
            cv.put("passSafe", usuario.pass_rota);
            cv.put("passEmerg", usuario.pass_emergencia);

            long id = db.insert("Usuarios", null, cv);
            usuario.id = (int) id;
        }finally {
            db.close();
        }
    }

    public void DeleteUser(Users user){

        SQLiteDatabase db = helper.getWritableDatabase();
        try{
            db.delete("Usuarios","id = ?", new String[] {String.valueOf(user.id)});
        }finally {
            db.close();
        }
    }

    public void carregarLista() {

        SQLiteDatabase db = helper.getReadableDatabase();
        try{
            cursor = db.rawQuery("select * from usuarios", null);

            lista.clear();
            while (cursor.moveToNext()) {

                Users usuario = new Users();
                usuario.id = cursor.getInt(cursor.getColumnIndex("id"));
                usuario.name = cursor.getString(cursor.getColumnIndex("name"));
                usuario.user  = cursor.getString(cursor.getColumnIndex("user"));
                usuario.pass_app = cursor.getString(cursor.getColumnIndex("passApp"));
                usuario.pass_app = cursor.getString(cursor.getColumnIndex("passSafe"));
                usuario.pass_app = cursor.getString(cursor.getColumnIndex("passEmerg"));
                lista.add(usuario);
            }
            cursor.close();
        }finally {
            db.close();
        }
    }


    public void UpdateUser (Integer id_user, String name, String user, String passapp, String passrota, String passemerg){

        Users usuario = new Users();
        usuario.name = name;
        usuario.user  = user;
        usuario.pass_app = passapp;
        usuario.pass_rota = passrota;
        usuario.pass_emergencia = passemerg;


        SQLiteDatabase db = helper.getWritableDatabase();
        try{
            ContentValues cv = new ContentValues();
            cv.put("name", usuario.name);
            cv.put("user", usuario.user);
            cv.put("passApp", usuario.pass_app);
            cv.put("passApp", usuario.pass_rota);
            cv.put("passEmerg", usuario.pass_emergencia);

            db.update("usuarios", cv,"id = ?", new String[] {String.valueOf(id_user)});

        }finally {
            db.close();
        }
    }

    /*public String CriarJson(){

        String json;
        JSONObject obj = null;
        try {
            obj = new JSONObject();
            obj.put("id", user.id);
            obj.put("nome", user.name);
            obj.put("user", user.user);
            obj.put("senha", user.password);
            obj.put("ultimaAlteracao", user.ultimaAlteracao);

        } catch (JSONException e1) {
            e1.printStackTrace();
        }
        json = obj.toString();

        return json;
    }*/




    /*
    public boolean ReadUser (String user_p, String password_p, Boolean validate_user){

        //SQLiteDatabase db = helper.getReadableDatabase();
        try{
            cursor = db.rawQuery("select * from users", null);

            lista.clear();
            while (cursor.moveToNext()) {


                Users usuario = new Users();
                usuario.id = cursor.getInt(cursor.getColumnIndex("id"));
                usuario.name = cursor.getString(cursor.getColumnIndex("name"));
                usuario.user  = cursor.getString(cursor.getColumnIndex("user"));
                usuario.password = cursor.getString(cursor.getColumnIndex("password"));
                usuario.ultimaAlteracao = cursor.getString(cursor.getColumnIndex("ultimaAlteracao"));
                lista.add(usuario);

                if (usuario.user.equals(user_p) && usuario.password.equals(password_p) ){
                    validate_user = true;
                    return validate_user;
                }
                else{
                    validate_user = false;
                }
            }
            cursor.close();
        }finally {
            db.close();
        }
        return validate_user;
    }
*/

}

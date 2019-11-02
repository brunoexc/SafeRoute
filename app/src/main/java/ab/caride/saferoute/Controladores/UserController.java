package ab.caride.saferoute.Controladores;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;

import ab.caride.saferoute.Classes.Users;
import ab.caride.saferoute.TelasJava.Database;

public class UserController {


    private Context context;
    public ArrayList<Users> lista, lista_servidor;
    //Database helper;
    SQLiteDatabase db;
    Cursor cursor;
    Calendar calendario;
    SimpleDateFormat timeNow;
    Database helper;


    public UserController(Context context) {
        this.context = context;
        lista = new ArrayList<>();
        lista_servidor = new ArrayList<>();

        //helper = new Database(this.context);
        //db = helper.getWritableDatabase();

        calendario = Calendar.getInstance();
        timeNow = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        timeNow.setTimeZone(TimeZone.getTimeZone("Brazil/East"));

        //carregarLista();
    }

    /*public void carregarLista() {

        SQLiteDatabase db = helper.getReadableDatabase();
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
            }
            cursor.close();
        }finally {
            db.close();
        }
    }*/

    public String CriarJson(){

        String json;
        JSONObject obj = null;
        try {
            /*obj = new JSONObject();
            obj.put("id", user.id);
            obj.put("nome", user.name);
            obj.put("user", user.user);
            obj.put("senha", user.password);
            obj.put("ultimaAlteracao", user.ultimaAlteracao);*/


            obj = new JSONObject();
            obj.put("id", "1");
            obj.put("latitude", "111213231");
            obj.put("longitude", "12313213");


        } catch (JSONException e1) {
            e1.printStackTrace();
        }
        json = obj.toString();

        return json;
    }

    public void SaveUser (String name, String user, String password){

        Users usuario = new Users();
        usuario.name = name;
        usuario.user  = user;
        usuario.password = password;
//        usuario.ultimaAlteracao = timeNow.format(calendario.getTime());
        lista_servidor.add(usuario);

        SQLiteDatabase db = helper.getWritableDatabase();
        try{
            ContentValues cv = new ContentValues();
            cv.put("name", usuario.name);
            cv.put("user", usuario.user);
            cv.put("password", usuario.password);
//            cv.put("ultimaAlteracao", usuario.ultimaAlteracao);
            long id = db.insert("Users", null, cv);
            usuario.id = (int) id;
        }finally {
            db.close();
        }
    }



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

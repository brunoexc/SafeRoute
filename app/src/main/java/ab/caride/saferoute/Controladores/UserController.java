package ab.caride.saferoute.Controladores;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;

import ab.caride.saferoute.Classes.Users;

public class UserController {


    private Context context;
    public ArrayList<Users> lista, lista_servidor;
    //Database helper;
    SQLiteDatabase db;
    Cursor cursor;
    Calendar calendario;
    SimpleDateFormat timeNow;


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



}

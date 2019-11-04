package ab.caride.saferoute.Controladores;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;

import ab.caride.saferoute.Classes.Street;
import ab.caride.saferoute.Classes.Users;
import ab.caride.saferoute.TelasJava.Database;

public class StreetController {


    private Context context;
    public ArrayList<Street> lista;
    public ArrayList<Users> lista_servidor;
    //Database helper;
    SQLiteDatabase db;
    Cursor cursor;
    Calendar calendario;
    SimpleDateFormat timeNow;
    Database helper;


    public StreetController(Context context) {
        this.context = context;
        lista = new ArrayList<Street>();
        lista_servidor = new ArrayList<>();

        helper = new Database(this.context);

        calendario = Calendar.getInstance();
        timeNow = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        timeNow.setTimeZone(TimeZone.getTimeZone("Brazil/East"));

        carregarLista();
    }

    public void carregarLista() {

        SQLiteDatabase db = helper.getReadableDatabase();
        try{
            cursor = db.rawQuery("select * from Rua", null);

            lista.clear();
            while (cursor.moveToNext()) {

                Street rua = new Street();
                rua.id = cursor.getInt(cursor.getColumnIndex("id"));
                rua.name = cursor.getString(cursor.getColumnIndex("name"));
                rua.lat  = cursor.getDouble(cursor.getColumnIndex("lat"));
                rua.lng = cursor.getDouble(cursor.getColumnIndex("lng"));
                lista.add(rua);
            }
            cursor.close();
        }finally {
            db.close();
        }
    }



    public void PreencheBase (){

        SQLiteDatabase db = helper.getWritableDatabase();
        try{

            ContentValues cv;
            long id;
            cv = new ContentValues();
            cv.put("name", "R. Marataizes");
            cv.put("lat", "-20.1995185");
            cv.put("lng", "-40.2661083");
            id = db.insert("Rua", null, cv);


            cv.put("name", "R. Iriri");
            cv.put("lat", -20.197530);
            cv.put("lng", -40.264766);//
            id = db.insert("Rua", null, cv);

        }finally {
            db.close();
        }



    }


}

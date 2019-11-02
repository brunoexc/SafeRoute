package ab.caride.saferoute.Controladores;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;

import ab.caride.saferoute.Classes.Users;
import ab.caride.saferoute.TelasJava.Database;

public class RouteController {


    private Context context;
    public ArrayList<Users> lista, lista_servidor;
    //Database helper;
    SQLiteDatabase db;
    Cursor cursor;
    Calendar calendario;
    SimpleDateFormat timeNow;
    Database helper;


    public RouteController(Context context) {
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



}

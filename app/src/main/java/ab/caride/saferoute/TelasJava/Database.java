package ab.caride.saferoute.TelasJava;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class Database extends SQLiteOpenHelper {


    public Database(Context context){
        super(context,"database.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        Log.i("TAG","onCreate Helper");
        db.execSQL(
                "CREATE TABLE Usuarios ("+
                        "id    INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"+
                        "name    TEXT NOT NULL,"+
                        "user    TEXT,"+
                        "passApp    NUMERIC,"+
                        "passSafe    NUMERIC,"+
                        "passEmerg     NUMERIC"+
                        ");"
        );

        db.execSQL(
                "CREATE TABLE Rua ("+
                        "id    INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"+
                        "name    TEXT NOT NULL,"+
                        "lat    TEXT,"+
                        "lng    TEXT"+
                        ");"
        );

        db.execSQL(
                "CREATE TABLE Rota ("+
                        "id    INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"+
                        "name    TEXT NOT NULL,"+
                        "ruas    INTEGER"+
                        ");"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

//        Log.i("TAG","oldVersion:"+oldVersion+" newVersion:"+newVersion);
//        if (newVersion > 1){
//            db.execSQL( "ALTER TABLE Clients add address_num TEXT;");
//        }
    }
}


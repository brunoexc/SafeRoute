package ab.caride.saferoute.Services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import ab.caride.saferoute.Classes.Location;

public class PostLocation extends Service {
    public Location local;
    public PostLocation() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        local = new Location();
        String teste = local.getLocation();
        //local.getLocation();
        Log.i("TAG",teste);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("TAG","MyService exec onStartCommand ");
        Log.i("TAG","startId "+ startId);
        //stopSelf(startId);

        return super.onStartCommand(intent, flags, startId);

    }
    @Override
    public void onDestroy() {
        Log.i("TAG","MyService exec onDestroy");
        super.onDestroy();
    }
}

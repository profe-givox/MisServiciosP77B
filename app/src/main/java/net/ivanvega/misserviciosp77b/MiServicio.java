package net.ivanvega.misserviciosp77b;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class MiServicio extends Service {

    @Override
    public void onCreate() {
        Log.d("XXXS", "oncreate service");
        super.onCreate();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.d("XXXS", "Trabajando forever");



        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.d("XXXS", "Destruido Service");
        super.onDestroy();
    }
}

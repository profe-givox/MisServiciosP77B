package net.ivanvega.misserviciosp77b;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.Random;

public class MisServicioEnlazado extends Service {
    // Binder given to clients
    private final IBinder binder = new MiBinder();
    // Random number generator
        private final Random mGenerator = new Random();


    public MisServicioEnlazado() {
    }

    public class MiBinder extends Binder{

        public MisServicioEnlazado  getService(){
            return  MisServicioEnlazado.this;
        }

    }


    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        //throw new UnsupportedOperationException("Not yet implemented");
        return binder;

    }

    /** method for clients */
    public int getRandomNumber() {
        return mGenerator.nextInt(100);
    }


}

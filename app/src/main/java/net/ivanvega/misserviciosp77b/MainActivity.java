package net.ivanvega.misserviciosp77b;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MisServicioEnlazado misServicioEnlazado;

    boolean mBound = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnStartIS_click(View view) {

        Intent miIS =
                new
                        Intent(this,
                        MiIntentService.class);

        startService(miIS);
        Toast.makeText(this, "Iniciado",
                Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this,
                MisServicioEnlazado.class);
        bindService(intent, sconect, Context.BIND_AUTO_CREATE);
    }

    public void btnSerInici(View view) {

        Intent miIS =
                new
                        Intent(this,
                        MiServicio.class);

        startService(miIS);
        Toast.makeText(this, "Iniciado S",
                Toast.LENGTH_SHORT).show();

    }

    public void btnSS_click(View view) {

        Intent miIS =
                new
                        Intent(this,
                        MiServicio.class);

        stopService(miIS);

    }

    /** Called when a button is clicked (the button in the layout file attaches to
     * this method with the android:onClick attribute) */
    public void onButtonClick(View v) {
        if (mBound) {
            // Call a method from the LocalService.
            // However, if this call were something that might hang, then this request should
            // occur in a separate thread to avoid slowing down the activity performance.
            int num = misServicioEnlazado.getRandomNumber();
            Toast.makeText(this, "number: " + num, Toast.LENGTH_SHORT).show();
        }
    }

    ServiceConnection sconect = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName,
                                       IBinder iBinder) {

            MisServicioEnlazado.MiBinder   miB =
                    (MisServicioEnlazado.MiBinder)iBinder;

             misServicioEnlazado =  miB.getService();
             mBound = true;

        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            mBound = false;
        }
    };

}

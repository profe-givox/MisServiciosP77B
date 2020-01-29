package net.ivanvega.misserviciosp77b;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MiIntentService extends IntentService {



    public MiIntentService(String name) {
        super(name);
    }

    /**
     * A constructor is required, and must call the super <code><a href="/reference/android/app/IntentService.html#IntentService(java.lang.String)">IntentService(String)</a></code>
     * constructor with a name for the worker thread.
     */
    public MiIntentService() {
        super("MiIntentService");
    }




    /**
     * The IntentService calls this method from the default worker thread with
     * the intent that started the service. When this method returns, IntentService
     * stops the service, as appropriate.
     */
    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        // Normally we would do some work here, like download a file.
        // For our sample, we just sleep for 5 seconds.

        try {
            Log.d("MSGIS", "subprioceso");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // Restore interrupt status.
            Thread.currentThread().interrupt();
        }
    }


    @Override
    public void onDestroy() {
        Toast.makeText(this,
                "IS Destruido", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }
}

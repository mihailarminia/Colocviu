package ro.pub.cs.systems.eim.colocviu1;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class Colocviu1_Service extends Service
{
    private ProcessingThread processingThread = null;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId)
    {
        String message = intent.getStringExtra("KEY");

        processingThread = new ProcessingThread(this, message);
        processingThread.start();

        return Service.START_REDELIVER_INTENT;
    }

    @Override
    public IBinder onBind(Intent intent)
    {
        return null;
    }

//    @Override
//    public void onDestory()
//    {
//        super.onDestroy();
//    }
}

package ro.pub.cs.systems.eim.colocviu1;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.Date;

public class ProcessingThread extends Thread
{
    private Context context = null;
    private String message = null;

    public ProcessingThread(Context context, String message)
    {
        this.context = context;
        this.message = message;
    }

    @Override
    public void run()
    {
        Log.d("TAG", "SERVICE STARTED");
        sleep();
        sendMessage();

        Log.d("TAG", "SERVICE SENT MESSAGE");
    }

    private void sendMessage()
    {
        Intent intent = new Intent();
        intent.setAction(CONSTANTS.INTENT_ACTION);
        intent.putExtra(CONSTANTS.BROADCAST_TAG, new Date(System.currentTimeMillis()) + " " +  message);

        context.sendBroadcast(intent);
    }

    private void sleep()
    {
        try
        {
            Thread.sleep(5000);
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}

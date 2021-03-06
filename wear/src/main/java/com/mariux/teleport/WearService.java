package com.mariux.teleport;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.mariux.teleport.lib.TeleportClient;
import com.mariux.teleport.lib.TeleportService;

/**
 * Created by Mario on 10/07/2014.
 */
public class WearService extends TeleportService{



    @Override
    public void onCreate() {
        super.onCreate();

        setOnGetMessageTask(new StartActivityTask());

    }

    //Task that shows the path of a received message
    public class StartActivityTask extends TeleportService.OnGetMessageTask {

        @Override
        protected void onPostExecute(String  path) {

       if (path.equals("startActivity")){

            Intent startIntent = new Intent(getBaseContext(), WearActivity.class);
            startIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(startIntent);
         }

            //let's reset the task (otherwise it will be executed only once)
            setOnGetMessageTask(new StartActivityTask());
        }
    }


}

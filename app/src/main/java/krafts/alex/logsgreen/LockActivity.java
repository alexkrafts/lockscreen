package krafts.alex.logsgreen;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class LockActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lock);

        startActivity(NotificationService.getIntentNotificationListenerSettings());
        _textToShow = (TextView) findViewById(R.id.text);

    }
    private TextView _textToShow;

    private NotificationReceiver nReceiver;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(nReceiver);
    }



//    public void buttonClicked(View v){
//
//        if(v.getId() == R.id.btnCreateNotify){
//            NotificationManager nManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
//            NotificationCompat.Builder ncomp = new NotificationCompat.Builder(this);
//            ncomp.setContentTitle("My Notification");
//            ncomp.setContentText("Notification Listener Service Example");
//            ncomp.setTicker("Notification Listener Service Example");
//            ncomp.setSmallIcon(R.drawable.ic_launcher);
//            ncomp.setAutoCancel(true);
//            nManager.notify((int)System.currentTimeMillis(),ncomp.build());
//        }
//        else if(v.getId() == R.id.btnClearNotify){
//            Intent i = new Intent("com.kpbird.nlsexample.NOTIFICATION_LISTENER_SERVICE_EXAMPLE");
//            i.putExtra("command","clearall");
//            sendBroadcast(i);
//        }
//        else if(v.getId() == R.id.btnListNotify){
//            Intent i = new Intent("com.kpbird.nlsexample.NOTIFICATION_LISTENER_SERVICE_EXAMPLE");
//            i.putExtra("command","list");
//            sendBroadcast(i);
//        }
//
//
//    }

    private static final String TAG = "LockActivity";

    public void Button_Click(View view) {
        nReceiver = new NotificationReceiver();
        Log.d(TAG, "onCreate: hop hey" );
        IntentFilter filter = new IntentFilter();
        filter.addAction("krafts.alex.NOTIFICATION_LISTENER_EXAMPLE");
        registerReceiver(nReceiver,filter);

        Intent i = new Intent("krafts.alex.NOTIFICATION_LISTENER_SERVICE_EXAMPLE");
        i.putExtra("command","list");
        sendBroadcast(i);

    }

    class NotificationReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            String temp = intent.getStringExtra("notification_event");
            _textToShow.setText(_textToShow.getText() + "\n" + temp);
            Log.d(TAG, "onReceive: "+ temp);
        }
    }
    static class NotificationsData{
        private static ArrayList<Notification> list;

        public static ArrayList<Notification> getList() {
            return list;
        }
        public static void addItem(Notification item){
            if (list==null)
                list = new ArrayList<>();
            list.add(item);
        }
        public static void removeItem(Notification item){
            if (list!=null && list.contains(item)) {
                list.remove(item);
            }
        }
    }
}

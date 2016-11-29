package krafts.alex.logsgreen;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.service.notification.StatusBarNotification;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class LockActivity extends AppCompatActivity {

    RecyclerView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lock);
        listView = (RecyclerView) findViewById(R.id.listView);
        SetAdapter();

    }

    private void SetAdapter() {
        NotificationsAdapter adapter = new NotificationsAdapter(getApplicationContext());
        listView.setAdapter(adapter);
        listView.setLayoutManager(new LinearLayoutManager(this));
        NotificationsData.setAdapter(adapter);
        startActivity(NotificationService.getIntentNotificationListenerSettings());
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
    }




    private static final String TAG = "LockActivity";


}

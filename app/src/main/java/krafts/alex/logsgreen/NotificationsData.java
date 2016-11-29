package krafts.alex.logsgreen;

import android.app.Notification;
import android.service.notification.StatusBarNotification;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by username on 11/28/2016.
 */
class NotificationsData {
    private static ArrayList<Notification> list;
    private static NotificationService _service;
    private static NotificationsAdapter _adapter;
    public static ArrayList<Notification> getList() {
        return list;
    }

    public static void addItem(Notification item) {
        if (list == null)
            list = new ArrayList<>();
        list.add(item);
        if (_adapter!=null)
            _adapter.notifyItemInserted(list.size()-1);
    }

    static int itemPosition;
    public static void removeItem(Notification item) {
        if (list != null && list.contains(item)) {
            itemPosition = list.indexOf(item);
            list.remove(item);
            if (_adapter !=null)
                _adapter.notifyItemRemoved(itemPosition);
        }

    }

    public static void setService(NotificationService service) {
        _service = service;
        for (StatusBarNotification item : service.getActiveNotifications()) {
            addItem(item.getNotification());
        }
        if (_adapter !=null)
            _adapter.notifyDataSetChanged();
    }

    public static void setAdapter(NotificationsAdapter _adapter) {
        NotificationsData._adapter = _adapter;
    }
}


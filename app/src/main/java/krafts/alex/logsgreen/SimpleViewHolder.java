package krafts.alex.logsgreen;

import android.app.Notification;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class SimpleViewHolder extends RecyclerView.ViewHolder{

    TextView _headerView;
    TextView _messageView;


    public SimpleViewHolder(View contentView){
        super(contentView);
        _headerView = (TextView) contentView.findViewById(R.id.text_id);
        _messageView = (TextView) contentView.findViewById(R.id.text_message);
    }

    public void Bind(Notification data){
        _headerView.setText((CharSequence) data.extras.get(Notification.EXTRA_TITLE));
        _messageView.setText((CharSequence) data.extras.get(Notification.EXTRA_TEXT));

    }
}

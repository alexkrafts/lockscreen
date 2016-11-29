package krafts.alex.logsgreen;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class NotificationsAdapter  extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context _context;

    public NotificationsAdapter(Context context){
        _context = context;

    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View simpleView = LayoutInflater.from(_context).inflate(R.layout.notification_basic, null);
        return new SimpleViewHolder(simpleView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((SimpleViewHolder)holder).Bind(NotificationsData.getList().get(position));
    }

    @Override
    public int getItemCount() {
        return NotificationsData.getList().size();
    }
}

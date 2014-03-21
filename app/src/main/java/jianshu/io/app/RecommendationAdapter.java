package jianshu.io.app;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Administrator on 14-3-21.
 */
public class RecommendationAdapter extends ArrayAdapter<RecommendationItem> {

  static class ViewHolder {
    TextView title;
    ImageView avatar;
    TextView summary;
  }

  Activity context;
  int resource;

  public RecommendationAdapter(Activity context, int resource) {
    super(context, resource);
    this.context = context;
    this.resource = resource;
  }

  public RecommendationAdapter(Activity context, int resource, RecommendationItem[] items) {
    super(context, resource);
    this.context = context;
    this.resource = resource;
    this.addAll(items);
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    View rowView = convertView;
    ViewHolder holder;
    if(rowView == null) {
      LayoutInflater inflater = this.context.getLayoutInflater();
      rowView = inflater.inflate(this.resource, null);
      holder = new ViewHolder();
      holder.title = (TextView)rowView.findViewById(R.id.title);
      holder.avatar = (ImageView)rowView.findViewById(R.id.avatar);
      holder.summary = (TextView)rowView.findViewById(R.id.summary);
      rowView.setTag(holder);
    }
    else {
      holder = (ViewHolder)rowView.getTag();
    }
    RecommendationItem item = this.getItem(position);
    holder.title.setText(item.getTitle());
    holder.avatar.setImageDrawable(item.getAvatar());
    holder.summary.setText(item.getSummary());
    return rowView;
  }
}

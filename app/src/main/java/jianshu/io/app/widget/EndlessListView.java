package jianshu.io.app.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;

import uk.co.androidalliance.edgeeffectoverride.EdgeEffectListView;

/**
 * Created by Administrator on 14-3-21.
 */
public class EndlessListView extends EdgeEffectListView implements AbsListView.OnScrollListener{

  private boolean isLoading;
  private EndlessListener listener;
  private View footer;

  public EndlessListView(Context context) {
    super(context);
    init();
  }

  public EndlessListView(Context context, AttributeSet attrs) {
    super(context, attrs);
    init();
  }

  public EndlessListView(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
    init();
  }

  private void init() {
    this.setOnScrollListener(this);
  }

  @Override
  public void onScrollStateChanged(AbsListView absListView, int i) {

  }

  @Override
  public void onScroll(AbsListView absListView, int firstVisibleItem,
                       int visibleItemCount, int totalItemCount) {
    if(getAdapter() == null) {
      return;
    }

    if(getAdapter().getCount() == 0) {
      return;
    }

    int l = visibleItemCount + firstVisibleItem;
    if(l >= totalItemCount && !isLoading) {
      this.addFooterView(this.footer);
      this.isLoading = true;
      this.listener.onScrollEnd();
    }
  }

  public void setFooter(View view) {
    this.footer = view;
  }

  public void setListener(EndlessListener listener) {
    this.listener = listener;
  }

  public void notifyNewDataLoaded() {
    this.removeFooterView(this.footer);
    this.isLoading = false;
  }

  @Override
  public void setAdapter(ListAdapter adapter) {
    this.addFooterView(this.footer);
    super.setAdapter(adapter);
    this.removeFooterView(this.footer);
  }
}

package jianshu.io.app;

import android.app.Activity;
import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import jianshu.io.app.widget.EndlessListView;
import jianshu.io.app.widget.EndlessListener;
import uk.co.senab.actionbarpulltorefresh.library.ActionBarPullToRefresh;
import uk.co.senab.actionbarpulltorefresh.library.PullToRefreshLayout;
import uk.co.senab.actionbarpulltorefresh.library.listeners.OnRefreshListener;

/**
 * Created by Administrator on 14-3-8.
 */
public class RecommendationFragment extends Fragment implements OnRefreshListener, EndlessListener {

  public static RecommendationFragment newInstance() {
    return new RecommendationFragment();
  }

  EndlessListView mListView;
  PullToRefreshLayout mPtrLayout;
  RecommendationAdapter mAdapter;

  public RecommendationFragment() {

  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = getActivity().getLayoutInflater().inflate(R.layout.recommendation, null);
    return view;
  }

  @Override
  public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);

    Activity activity = getActivity();
    mListView = (EndlessListView) (activity.findViewById(R.id.list));
    mListView.setListener(this);
    View footer = activity.getLayoutInflater().inflate(R.layout.footer, null);
    mListView.setFooter(footer);
    mPtrLayout = (PullToRefreshLayout)(activity.findViewById(R.id.ptr_layout));

    ActionBarPullToRefresh.from(activity)
        .allChildrenArePullable()
        .listener(this)
        .setup(mPtrLayout);
  }

  @Override
  public void onStart() {
    super.onStart();

    mAdapter = new RecommendationAdapter(getActivity(),
        R.layout.article_list_item, getData());
    mListView.setAdapter(mAdapter);
  }

  private RecommendationItem[] getData() {
    int count = 10;
    RecommendationItem[] result = new RecommendationItem[count];
    for(int i = 0; i < count; i++) {
      result[i] = new RecommendationItem("管理者，别让下属害怕",
          getResources().getDrawable(R.drawable.monk),
          "我一直还算欣赏大张伟的幽默和精灵，笑的时候大笑，说的时候也不遮遮掩掩，就像一个不懂事的孩子 ，没什么礼貌，就是贪玩，大人越不让他说什么他就越晒脸，口无遮拦，让人哭笑不得。当然， 接下来说的不是大张伟，而是他在微博上嘴贱的说过的一句话、“韩国歌曲的MV就是给女人看的毛 片。” ...");
    }
    return result;
  }

  @Override
  public void onRefreshStarted(View view) {
    /**
     * Simulate Refresh with 4 seconds sleep
     */
    new AsyncTask<Void, Void, Void>() {

      @Override
      protected Void doInBackground(Void... params) {
        try {
          Thread.sleep(1000 * 2);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        return null;
      }

      @Override
      protected void onPostExecute(Void result) {
        super.onPostExecute(result);

        // Notify PullToRefreshLayout that the refresh has finished
        mPtrLayout.setRefreshComplete();
      }
    }.execute();
  }

  @Override
  public void onScrollEnd() {
    new AsyncTask<Void, Void, Void>() {
      @Override
      protected Void doInBackground(Void... voids) {
        try {
          Thread.sleep(1000 * 2);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        return null;
      }

      @Override
      protected void onPostExecute(Void aVoid) {
        RecommendationItem[] newData = getData();
        mAdapter.addAll(newData);
        mListView.notifyNewDataLoaded();
      }
    }.execute();
  }
}

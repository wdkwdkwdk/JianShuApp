package jianshu.io.app;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import java.io.IOException;

import jianshu.io.app.widget.EndlessListView;
import jianshu.io.app.widget.EndlessListener;
import jianshu.io.app.widget.LoadingTextView;
import model.HomePageDataPool;
import model.RecommendationItem;
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
  LoadingTextView mFooter;
  HomePageDataPool mPool;

  public RecommendationFragment() {
    mPool = new HomePageDataPool();
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = getActivity().getLayoutInflater().inflate(R.layout.recommendation, null);
    return view;
  }

  @Override
  public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);

    final Activity activity = getActivity();

    mListView = (EndlessListView) (activity.findViewById(R.id.list));
    mListView.setListener(this);
    mFooter = (LoadingTextView) activity.getLayoutInflater().inflate(R.layout.footer, null);
    mListView.setFooter(mFooter);
    mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(activity, ArticleActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
        activity.overridePendingTransition(R.anim.slide_in_left, 0);
      }
    });
    mAdapter = new RecommendationAdapter(getActivity(),
        R.layout.article_list_item);
    mListView.setAdapter(mAdapter);

    mPtrLayout = (PullToRefreshLayout) (activity.findViewById(R.id.ptr_layout));
    ActionBarPullToRefresh.from(activity)
        .allChildrenArePullable()
        .listener(this)
        .setup(mPtrLayout);

    mPtrLayout.setRefreshing(true);
    onRefreshStarted(null);
  }

  private RecommendationItem[] getData() throws IOException {
    return mPool.refresh();
  }

  class RecommendationAsyncTask extends AsyncTask<Void, Void, RecommendationItem[]> {

    private OnPostExecuteTask task;

    public RecommendationAsyncTask(OnPostExecuteTask task) {
      this.task = task;
    }

    @Override
    protected RecommendationItem[] doInBackground(Void... params) {
      try {
        return RecommendationFragment.this.getData();
      } catch (IOException e) {
        return null;
      }
    }

    @Override
    protected void onPostExecute(RecommendationItem[] data) {
      this.task.run(data);
    }
  }

  interface OnPostExecuteTask {
    void run(RecommendationItem[] data);
  }

  @Override
  public void onRefreshStarted(View view) {
    new RecommendationAsyncTask(new OnPostExecuteTask() {
      @Override
      public void run(RecommendationItem[] data) {
        mPtrLayout.setRefreshComplete();
        if(data != null) {
          mAdapter.clear();
          mAdapter.addAll(data);
        }
      }
    }).execute();
  }

  @Override
  public void onScrollEnd() {
//    mFooter.startAnimation();
//    new RecommendationAsyncTask(new OnPostExecuteTask() {
//      @Override
//      public void run(RecommendationItem[] data) {
//        mFooter.startAnimation();
//        if (data != null) {
//          mAdapter.addAll(data);
//        }
//      }
//    }).execute();
  }
}

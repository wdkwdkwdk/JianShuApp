package jianshu.io.app;

import android.app.Activity;
import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import uk.co.androidalliance.edgeeffectoverride.EdgeEffectListView;
import uk.co.senab.actionbarpulltorefresh.library.ActionBarPullToRefresh;
import uk.co.senab.actionbarpulltorefresh.library.PullToRefreshLayout;
import uk.co.senab.actionbarpulltorefresh.library.listeners.OnRefreshListener;

/**
 * Created by Administrator on 14-3-8.
 */
public class RecommendationFragment extends Fragment implements OnRefreshListener {

  public static RecommendationFragment newInstance() {
    return new RecommendationFragment();
  }

  EdgeEffectListView mListView;
  PullToRefreshLayout mPtrLayout;

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
    mListView = (EdgeEffectListView) (activity.findViewById(R.id.list));
    mPtrLayout = (PullToRefreshLayout)(activity.findViewById(R.id.ptr_layout));

    ActionBarPullToRefresh.from(activity)
        .allChildrenArePullable()
        .listener(this)
        .setup(mPtrLayout);
  }

  @Override
  public void onStart() {
    super.onStart();

    SimpleAdapter adapter = new SimpleAdapter(getActivity(), this.getData(),
        R.layout.article_list_item,
        new String[]{"title", "avatar", "summary"},
        new int[]{R.id.title, R.id.avatar, R.id.summary});
    mListView.setAdapter(adapter);
  }

  private List<Map<String, Object>> getData() {
    List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
    Map<String, Object> map;
    map = new HashMap<String, Object>();
    map.put("title", "管理者，别让下属害怕");
    map.put("avatar", R.drawable.monk);
    map.put("summary", "我一直还算欣赏大张伟的幽默和精灵，笑的时候大笑，说的时候也不遮遮掩掩，就像一个不懂事的孩子 ，没什么礼貌，就是贪玩，大人越不让他说什么他就越晒脸，口无遮拦，让人哭笑不得。当然， 接下来说的不是大张伟，而是他在微博上嘴贱的说过的一句话、“韩国歌曲的MV就是给女人看的毛 片。” ...");
    result.add(map);
    map = new HashMap<String, Object>();
    map.put("title", "管理者，别让下属害怕");
    map.put("avatar", R.drawable.monk);
    map.put("summary", "我一直还算欣赏大张伟的幽默和精灵，笑的时候大笑，说的时候也不遮遮掩掩，就像一个不懂事的孩子 ，没什么礼貌，就是贪玩，大人越不让他说什么他就越晒脸，口无遮拦，让人哭笑不得。当然， 接下来说的不是大张伟，而是他在微博上嘴贱的说过的一句话、“韩国歌曲的MV就是给女人看的毛 片。” ...");
    result.add(map);
    map = new HashMap<String, Object>();
    map.put("title", "管理者，别让下属害怕");
    map.put("avatar", R.drawable.monk);
    map.put("summary", "我一直还算欣赏大张伟的幽默和精灵，笑的时候大笑，说的时候也不遮遮掩掩，就像一个不懂事的孩子 ，没什么礼貌，就是贪玩，大人越不让他说什么他就越晒脸，口无遮拦，让人哭笑不得。当然， 接下来说的不是大张伟，而是他在微博上嘴贱的说过的一句话、“韩国歌曲的MV就是给女人看的毛 片。” ...");
    result.add(map);
    map = new HashMap<String, Object>();
    map.put("title", "管理者，别让下属害怕");
    map.put("avatar", R.drawable.monk);
    map.put("summary", "我一直还算欣赏大张伟的幽默和精灵，笑的时候大笑，说的时候也不遮遮掩掩，就像一个不懂事的孩子 ，没什么礼貌，就是贪玩，大人越不让他说什么他就越晒脸，口无遮拦，让人哭笑不得。当然， 接下来说的不是大张伟，而是他在微博上嘴贱的说过的一句话、“韩国歌曲的MV就是给女人看的毛 片。” ...");
    result.add(map);
    map = new HashMap<String, Object>();
    map.put("title", "管理者，别让下属害怕");
    map.put("avatar", R.drawable.monk);
    map.put("summary", "我一直还算欣赏大张伟的幽默和精灵，笑的时候大笑，说的时候也不遮遮掩掩，就像一个不懂事的孩子 ，没什么礼貌，就是贪玩，大人越不让他说什么他就越晒脸，口无遮拦，让人哭笑不得。当然， 接下来说的不是大张伟，而是他在微博上嘴贱的说过的一句话、“韩国歌曲的MV就是给女人看的毛 片。” ...");
    result.add(map);
    map = new HashMap<String, Object>();
    map.put("title", "管理者，别让下属害怕");
    map.put("avatar", R.drawable.monk);
    map.put("summary", "我一直还算欣赏大张伟的幽默和精灵，笑的时候大笑，说的时候也不遮遮掩掩，就像一个不懂事的孩子 ，没什么礼貌，就是贪玩，大人越不让他说什么他就越晒脸，口无遮拦，让人哭笑不得。当然， 接下来说的不是大张伟，而是他在微博上嘴贱的说过的一句话、“韩国歌曲的MV就是给女人看的毛 片。” ...");
    result.add(map);
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
}

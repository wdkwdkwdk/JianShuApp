package jianshu.io.app;

import android.app.ListFragment;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 14-3-8.
 */
public class RecommendationFragment extends ListFragment {

  public static RecommendationFragment newInstance() {
    return new RecommendationFragment();
  }

  ListView mListView;

  public RecommendationFragment() {

  }

  @Override
  public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    mListView = (ListView) (getActivity().findViewById(android.R.id.list));
  }

  @Override
  public void onStart() {
    super.onStart();

    SimpleAdapter adapter = new SimpleAdapter(getActivity(), this.getData(),
        R.layout.article_list_item,
        new String[]{"title", "avatar", "summary"},
        new int[]{R.id.title, R.id.avatar, R.id.summary});
    setListAdapter(adapter);
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
}

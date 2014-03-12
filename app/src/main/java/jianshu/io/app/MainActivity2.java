package jianshu.io.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity2 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
//        ListView listView = (ListView)findViewById(R.id.test);
//        SimpleAdapter adapter = new SimpleAdapter(this, this.getData(),
//            R.layout.article_list_item,
//            new String[]{"title", "avatar", "summary"},
//            new int[]{R.id.title, R.id.avatar, R.id.summary});
//        listView.setAdapter(adapter);
//        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_activity2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private List<Map<String, Object>> getData() {
        List<Map<String, Object>> result =  new ArrayList<Map<String, Object>>();
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
    }}

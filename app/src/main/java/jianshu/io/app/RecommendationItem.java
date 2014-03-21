package jianshu.io.app;

import android.graphics.drawable.Drawable;

/**
 * Created by Administrator on 14-3-21.
 */
public class RecommendationItem {
  public RecommendationItem(String title, Drawable avatar, String summary) {
    this.title = title;
    this.avatar = avatar;
    this.summary = summary;
  }

  public String getTitle() {
    return title;
  }

  public String getSummary() {
    return summary;
  }

  public Drawable getAvatar() {
    return avatar;
  }

  private String title;
  private Drawable avatar;
  private String summary;
}

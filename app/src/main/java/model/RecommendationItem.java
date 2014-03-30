package model;

/**
 * Created by Administrator on 14-3-21.
 */
public class RecommendationItem {
  public RecommendationItem(String title, String avatar, String summary, String url) {
    this.title = title;
    this.avatar = avatar;;
    this.summary = summary;
    this.url = url;
  }

  public String getTitle() {
    return title;
  }

  public String getSummary() {
    return summary;
  }

  public String getAvatar() {
    return avatar;
  }

  public String getUrl() {
    return url;
  }

  private String title;
  private String avatar;
  private String summary;
  private String url;
}

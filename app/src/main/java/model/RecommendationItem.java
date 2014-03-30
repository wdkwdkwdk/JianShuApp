package model;

/**
 * Created by Administrator on 14-3-21.
 */
public class RecommendationItem {
  public RecommendationItem(String title, String avatar, String summary) {
    this.title = title;
    this.avatar = avatar;;
    this.summary = summary;
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

  private String title;
  private String avatar;
  private String summary;
}

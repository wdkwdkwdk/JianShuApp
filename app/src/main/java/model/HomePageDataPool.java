package model;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by Administrator on 2014/3/29.
 */
public class HomePageDataPool {

  private boolean mIsAtTheEnd;
  protected final static String HOME_PAGE_URL = "http://jianshu.io";
  protected final static String ARTICLE_SELECTOR = "div.article";
  protected final static String TITLE_SELECTOR = "a.title";
  protected final static String AVATAR_SELECTOR = "a.avatar > img";
  protected final static String CONTENT_SELECTOR = "a.content";

  public RecommendationItem[] refresh() throws IOException{
    Document doc = Jsoup.connect(HOME_PAGE_URL).get();
    Elements articleElements = doc.select(ARTICLE_SELECTOR);
    if(articleElements != null) {
      int i = 0;
      RecommendationItem[] result = new RecommendationItem[articleElements.size()];
      for(Element el : articleElements) {
        result[i++] = parseElement(el);
      }
      return result;
    } else {
      return null;
    }
  }

  public RecommendationItem[] pull() {
    return null;
  }

  public boolean isAtTheEnd() {
    return mIsAtTheEnd;
  }

  public RecommendationItem parseElement(Element el) {
    Element titleEl = el.select(TITLE_SELECTOR).get(0);
    String title = titleEl.text();
    Element avatarEl = el.select(AVATAR_SELECTOR).get(0);
    String avatarUrl = avatarEl.attr("src");
    Element contentEl = el.select(CONTENT_SELECTOR).get(0);
    String content = contentEl.text();
    return new RecommendationItem(title, avatarUrl, content);
  }
}

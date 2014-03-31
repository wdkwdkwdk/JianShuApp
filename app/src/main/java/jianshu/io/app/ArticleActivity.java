package jianshu.io.app;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import jianshu.io.app.widget.LoadingTextView;
import me.imid.swipebacklayout.lib.SwipeBackLayout;
import me.imid.swipebacklayout.lib.app.SwipeBackActivity;


public class ArticleActivity extends SwipeBackActivity {

  private LoadingTextView mLoadingArticle;
  private WebView mWebView;
  private Button mRetryButton;
  private SwipeBackLayout mSwipeBackLayout;
  private boolean hasError;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_article);

    Intent intent = getIntent();
    final String url = intent.getStringExtra("url");
    mLoadingArticle = (LoadingTextView)findViewById(R.id.loading_article);
    mWebView = (WebView)findViewById(R.id.web);
    mRetryButton = (Button)findViewById(R.id.retry);

    mWebView.getSettings().setJavaScriptEnabled(true);
    mWebView.setWebViewClient(new WebViewClient() {
      @Override
      public void onPageStarted(WebView view, String url, Bitmap favicon) {
        if(hasError) {
          return;
        }
        hasError = false;
        mLoadingArticle.setVisibility(View.VISIBLE);
        mLoadingArticle.startAnimation();
        mWebView.setVisibility(View.INVISIBLE);
        mRetryButton.setVisibility(View.INVISIBLE);
      }

      @Override
      public void onPageFinished(WebView view, String url) {
        mLoadingArticle.endAnimation();
        mLoadingArticle.setVisibility(View.INVISIBLE);
        if(!hasError) {
          mWebView.setVisibility(View.VISIBLE);
          mWebView.loadUrl("javascript:$('div.navbar').remove()");
          mWebView.loadUrl("javascript:$('div.wrap-btn').remove()");
          mWebView.loadUrl("javascript:$('a.notebooks-menu-btn').remove()");
          mWebView.loadUrl("javascript:$('div.article').css('margin-top', '0px')");
          mWebView.loadUrl("javascript:$('div.preview').css('padding-top', '0px')");
        } else {
          mRetryButton.setVisibility(View.VISIBLE);
        }
      }

      @Override
      public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
        hasError = true;
      }
    });
    mWebView.loadUrl(url);

    mRetryButton.setOnClickListener(new Button.OnClickListener() {
      @Override
      public void onClick(View v) {
        hasError = false;
        mWebView.loadUrl(url);
      }
    });

    ActionBar actionBar = getActionBar();
    actionBar.setDisplayHomeAsUpEnabled(true);

    mSwipeBackLayout = getSwipeBackLayout();
    mSwipeBackLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_LEFT);
  }

  @Override
  protected void onPause() {
    super.onPause();
    if(mLoadingArticle.getVisibility() == View.VISIBLE) {
      mLoadingArticle.endAnimation();
    }
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {

    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.article, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.  }   int id = item.getItemId();
    switch (item.getItemId()) {
      // Respond to the action bar's Up/Home button
      case android.R.id.home:
        Intent intent = NavUtils.getParentActivityIntent(this);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        overridePendingTransition(0, R.anim.slide_out_right);
        return true;
    }
    return super.onOptionsItemSelected(item);
  }

  @Override
  public void onBackPressed() {
    finish();
    overridePendingTransition(0, R.anim.slide_out_right);
  }
}

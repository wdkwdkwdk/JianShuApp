package jianshu.io.app.widget;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Administrator on 2014/3/28.
 */
public class LoadingTextView extends TextView{

  private ValueAnimator mAnim;

  public LoadingTextView(Context context) {
    super(context);
    init();
  }

  public LoadingTextView(Context context, AttributeSet attrs) {
    super(context, attrs);
    init();
  }

  public LoadingTextView(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
    init();
  }

  public void startAnimation() {
    mAnim.start();
  }

  public void endAnimation() {
    mAnim.end();
  }

  @Override
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();
    mAnim.start();
  }

  @Override
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    mAnim.end();
  }

  @Override
  public void onStartTemporaryDetach() {
    super.onStartTemporaryDetach();
    mAnim.end();
  }

  @Override
  protected void onVisibilityChanged(View changedView, int visibility) {
    super.onVisibilityChanged(changedView, visibility);
    if(visibility == View.GONE || visibility == View.INVISIBLE) {
      mAnim.end();
    } else {
      mAnim.start();
    }
  }

  private void init() {
    final int max = 9, middle = 4;
    final String dot = "•";
    mAnim = ValueAnimator.ofInt(0, max);
    mAnim.setRepeatCount(ObjectAnimator.INFINITE);
    mAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
      @Override
      public void onAnimationUpdate(ValueAnimator valueAnimator) {
        String text;
        int value = (Integer) valueAnimator.getAnimatedValue();
        if (value <= middle) {
          text = new String(new char[value + 1]).replace("\0", dot) +
              new String(new char[middle - value]).replace("\0", " ");
        } else {
          text = new String(new char[value - middle]).replace("\0", " ") +
              new String(new char[max - value]).replace("\0", dot);
        }
        setText(text);
      }
    });
    mAnim.setDuration(max * 300);
  }
}

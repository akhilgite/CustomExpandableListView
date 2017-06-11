package in.akhilgite.customexpandablelistview.utils;

import android.animation.ValueAnimator;
import android.util.Log;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

/**
 * Created by akhil on 10/6/17.
 */

public class Animator {
    private static String TAG = "Animator";

    public static void expand(final View v, int duration, int targetHeight) {
        int prevHeight = v.getHeight();
        Log.d(TAG, "expand: "+prevHeight);
        v.setVisibility(View.VISIBLE);
        ValueAnimator valueAnimator = ValueAnimator.ofInt(prevHeight, targetHeight);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Log.d(TAG, "onAnimationUpdate: Animated Height :: "+(int) animation.getAnimatedValue());
                v.getLayoutParams().height = (int) animation.getAnimatedValue();
                v.requestLayout();
            }
        });
        valueAnimator.setInterpolator(new DecelerateInterpolator());
        valueAnimator.setDuration(duration);
        valueAnimator.start();
    }

    public static void collapse(final View v, int duration, int targetHeight) {
        int prevHeight = v.getHeight();
        ValueAnimator valueAnimator = ValueAnimator.ofInt(prevHeight, targetHeight);
        valueAnimator.setInterpolator(new DecelerateInterpolator());
        Log.e(TAG, "collapse: Prevalue :: "+prevHeight);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Log.d(TAG, "onAnimationUpdate: Animated Height :: "+(int) animation.getAnimatedValue());
                v.getLayoutParams().height = (int) animation.getAnimatedValue();
                v.requestLayout();
            }
        });
        valueAnimator.setInterpolator(new DecelerateInterpolator());
        valueAnimator.setDuration(duration);
        valueAnimator.start();
    }
}

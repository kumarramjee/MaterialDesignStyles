package materialdesignstyle.mobimedia.com.materialdesignstyles.ui.ui;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import materialdesignstyle.mobimedia.com.materialdesignstyles.R;
import materialdesignstyle.mobimedia.com.materialdesignstyles.ui.Adapter.HorizontalImageAdapter;
import materialdesignstyle.mobimedia.com.materialdesignstyles.ui.Animation.ViewHelper;
import materialdesignstyle.mobimedia.com.materialdesignstyles.ui.Animation.ViewPropertyAnimator;
import materialdesignstyle.mobimedia.com.materialdesignstyles.ui.Utility.HorizontalListView;
import materialdesignstyle.mobimedia.com.materialdesignstyles.ui.Utility.RoundedImageView;
import matterialdesignlibrary.mobimedia.com.mobimedialibrary.ObservableScrollView;
import matterialdesignlibrary.mobimedia.com.mobimedialibrary.ObservableScrollViewCallbacks;
import matterialdesignlibrary.mobimedia.com.mobimedialibrary.ScrollState;
import matterialdesignlibrary.mobimedia.com.mobimedialibrary.ScrollUtils;

public class WatttsAppActivtiy extends Activity implements ObservableScrollViewCallbacks, View.OnClickListener {
    private static final float MAX_TEXT_SCALE_DELTA = 0.3f;
    private View mImageView;
    private View mOverlayView;
    private ObservableScrollView mScrollView;
    private TextView mTitleView;
    private ImageView mFab;
    private int mActionBarSize;
    private int mFlexibleSpaceShowFabOffset;
    private int mFlexibleSpaceImageHeight;
    private int mFabMargin;
    private boolean mFabIsShown;
    private HorizontalListView mhorizontalimagelist;
    private HorizontalImageAdapter mHorizontalImageAdapter;
    private RoundedImageView mCirclularImageview;
    private RelativeLayout mviewadd;
    private int imagearray[] = {R.drawable.sky, R.drawable.moderate, R.drawable.moderaterain, R.drawable.lightrain, R.drawable.nonelse, R.drawable.scateredclouds

    };

    private Bitmap bm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wattts_app_activtiy);
        SetUPUI();

        mFlexibleSpaceImageHeight = getResources().getDimensionPixelSize(R.dimen.flexible_space_image_height);
        mFlexibleSpaceShowFabOffset = getResources().getDimensionPixelSize(R.dimen.flexible_space_show_fab_offset);
        mActionBarSize = 60;


        mFabMargin = getResources().getDimensionPixelSize(R.dimen.margin_standard);
       /* ViewHelper.setScaleX(mFab, 0);
        ViewHelper.setScaleY(mFab, 0);
       */
        ScrollUtils.addOnGlobalLayoutListener(mScrollView, new Runnable() {
            @Override
            public void run() {
                //mScrollView.scrollTo(0, mFlexibleSpaceImageHeight - mActionBarSize);

                // If you'd like to start from scrollY == 0, don't write like this:
                //mScrollView.scrollTo(0, 0);
                // The initial scrollY is 0, so it won't invoke onScrollChanged().
                // To do this, use the following:
                //onScrollChanged(0, false, false);

                // You can also achieve it with the following codes.
                // This causes scroll change from 1 to 0.
                mScrollView.scrollTo(0, 1);
                mScrollView.scrollTo(0, 0);
            }
        });

        mScrollView.setScrollViewCallbacks(this);



        View child = getLayoutInflater().inflate(R.layout.insertlayout, null);
        mviewadd.addView(child);


        mHorizontalImageAdapter = new HorizontalImageAdapter(WatttsAppActivtiy.this, imagearray);
        mhorizontalimagelist.setAdapter(mHorizontalImageAdapter);


        mFab.setOnClickListener(this);

    }


    private void SetUPUI() {

        mImageView = findViewById(R.id.image);
        mOverlayView = findViewById(R.id.overlay);
        mScrollView = (ObservableScrollView) findViewById(R.id.scroll);
        mTitleView = (TextView) findViewById(R.id.title);
        mTitleView.setText("MobiMedia Technology");
        mFab = (ImageView) findViewById(R.id.fab);
        mhorizontalimagelist = (HorizontalListView) findViewById(R.id.horizontalimagelist);
        mCirclularImageview = (RoundedImageView) findViewById(R.id.imageview);
        mviewadd=(RelativeLayout)findViewById(R.id.viewadd);
    }


    @Override
    public void onScrollChanged(int scrollY, boolean firstScroll, boolean dragging) {
        float flexibleRange = mFlexibleSpaceImageHeight - mActionBarSize;
        int minOverlayTransitionY = mActionBarSize - mOverlayView.getHeight();
        ViewHelper.setTranslationY(mOverlayView, ScrollUtils.getFloat(-scrollY, minOverlayTransitionY, 0));
        ViewHelper.setTranslationY(mImageView, ScrollUtils.getFloat(-scrollY / 2, minOverlayTransitionY, 0));

        // Change alpha of overlay
        ViewHelper.setAlpha(mOverlayView, ScrollUtils.getFloat((float) scrollY / flexibleRange, 0, 1));

        // Scale title text
        float scale = 1 + ScrollUtils.getFloat((flexibleRange - scrollY) / flexibleRange, 0, MAX_TEXT_SCALE_DELTA);
        ViewHelper.setPivotX(mTitleView, 0);
        ViewHelper.setPivotY(mTitleView, 0);
        ViewHelper.setScaleX(mTitleView, scale);
        ViewHelper.setScaleY(mTitleView, scale);

        // Translate title text
        int maxTitleTranslationY = (int) (mFlexibleSpaceImageHeight - mTitleView.getHeight() * scale);

        Log.i("",""+maxTitleTranslationY);

        int titleTranslationY = maxTitleTranslationY - scrollY;
        Log.i("",""+titleTranslationY);

        ViewHelper.setTranslationY(mTitleView, titleTranslationY);
        //translate Circular Image
        ViewHelper.setTranslationY(mCirclularImageview, titleTranslationY);

        // Translate FAB
        int maxFabTranslationY = mFlexibleSpaceImageHeight - mFab.getHeight() / 2;
        float fabTranslationY = ScrollUtils.getFloat(
                -scrollY + mFlexibleSpaceImageHeight - mFab.getHeight() / 2,
                mActionBarSize - mFab.getHeight() / 2,
                maxFabTranslationY);
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB) {
            // On pre-honeycomb, ViewHelper.setTranslationX/Y does not set margin,
            // which causes FAB's OnClickListener not working.
            FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) mFab.getLayoutParams();
            lp.leftMargin = mOverlayView.getWidth() - mFabMargin - mFab.getWidth();
            lp.topMargin = (int) fabTranslationY;
            mFab.requestLayout();
        } else {
            ViewHelper.setTranslationX(mFab, mOverlayView.getWidth() - mFabMargin - mFab.getWidth());
            ViewHelper.setTranslationY(mFab, fabTranslationY);
        }


        if (fabTranslationY < mFlexibleSpaceShowFabOffset) {
          //  hideFab();
        } else {
           // showFab();
        }
    }


    @Override
    public void onDownMotionEvent() {

    }

    @Override
    public void onUpOrCancelMotionEvent(ScrollState scrollState) {

    }

    private void showFab() {
        if (!mFabIsShown) {
            ViewPropertyAnimator.animate(mFab).cancel();
            ViewPropertyAnimator.animate(mFab).scaleX(1).scaleY(1).setDuration(200).start();
            mFabIsShown = true;
        }


    }

    private void hideFab() {
        if (mFabIsShown) {
            ViewPropertyAnimator.animate(mFab).cancel();
            ViewPropertyAnimator.animate(mFab).scaleX(0).scaleY(0).setDuration(200).start();
            mFabIsShown = false;
        }
        // mFab.setVisibility(View.INVISIBLE);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.image:
                Toast.makeText(WatttsAppActivtiy.this, "FAB is clicked", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}

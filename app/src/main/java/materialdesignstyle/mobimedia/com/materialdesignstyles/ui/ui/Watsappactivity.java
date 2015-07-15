package materialdesignstyle.mobimedia.com.materialdesignstyles.ui.ui;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toolbar;

import materialdesignstyle.mobimedia.com.materialdesignstyles.R;
import materialdesignstyle.mobimedia.com.materialdesignstyles.ui.Utility.HorizontalListView;
import matterialdesignlibrary.mobimedia.com.mobimedialibrary.ObservableScrollViewCallbacks;
import matterialdesignlibrary.mobimedia.com.mobimedialibrary.ScrollState;

public class Watsappactivity extends Activity implements ObservableScrollViewCallbacks, View.OnClickListener {


    private Toolbar mToolbar;
    private ImageView image_back;
    private int mFlexibleSpaceShowFabOffset;
    private int mFlexibleSpaceImageHeight;
    private int mFabMargin;
    private boolean mFabIsShown;
    private ImageView image;
    private HorizontalListView mHorizontallistview;

    private View mFab;
    private int mActionBarSize;
private int imageheight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watsappactivity);
        SetUpUI();


        mFlexibleSpaceImageHeight = getResources().getDimensionPixelSize(R.dimen.flexible_space_image_height);
        mFlexibleSpaceShowFabOffset = getResources().getDimensionPixelSize(R.dimen.flexible_space_show_fab_offset);




        imageheight=image.getMaxHeight();
        Log.i("Height of image is:","=="+imageheight);




    }

    private void SetUpUI() {
        image_back = (ImageView) findViewById(R.id.imageback);
        image = (ImageView) findViewById(R.id.image);
        mHorizontallistview = (HorizontalListView) findViewById(R.id.horizontalimagelist);
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageback:
                break;
            default:
                break;
        }
    }

    @Override
    public void onScrollChanged(int scrollY, boolean firstScroll, boolean dragging) {

    }

    @Override
    public void onDownMotionEvent() {

    }

    @Override
    public void onUpOrCancelMotionEvent(ScrollState scrollState) {

    }
}
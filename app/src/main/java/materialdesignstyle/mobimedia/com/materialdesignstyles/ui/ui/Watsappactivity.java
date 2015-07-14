package materialdesignstyle.mobimedia.com.materialdesignstyles.ui.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toolbar;

import materialdesignstyle.mobimedia.com.materialdesignstyles.R;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watsappactivity);
        SetUpUI();






    }

    private void SetUpUI() {
        image_back = (ImageView) findViewById(R.id.imageback);
        image = (ImageView) findViewById(R.id.image);

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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageback:
                break;
            default:
                break;
        }
    }
}
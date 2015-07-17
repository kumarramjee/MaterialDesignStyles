package materialdesignstyle.mobimedia.com.materialdesignstyles.ui.Adapter;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by ram on 17/7/15.
 */
public class ImageAdapter extends BaseAdapter {

    private Context context;
    private Cursor cursor;
    public ImageAdapter(Context localContext,Cursor cursor) {
        this.context = localContext;
        this.cursor=cursor;
    }

    public int getCount() {
        return cursor.getCount();
    }
    public Object getItem(int position) {
        return position;
    }
    public long getItemId(int position) {
        return position;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView picturesView;
        if (convertView == null) {
            picturesView = new ImageView(context);
            // Move cursor to current position
            cursor.moveToPosition(position);
            // Get the current value for the requested column
            int imageID = cursor.getInt(cursor.getColumnIndexOrThrow(MediaStore.Images.Thumbnails._ID));
            // Set the content of the image based on the provided URI
            picturesView.setImageURI(Uri.withAppendedPath(
                    MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, "" + imageID));
            picturesView.setScaleType(ImageView.ScaleType.FIT_XY);
            picturesView.setPadding(10, 10, 10, 10);
            picturesView.setLayoutParams(new GridView.LayoutParams(100, 100));
        }
        else {
            picturesView = (ImageView)convertView;
        }
        return picturesView;
    }
}

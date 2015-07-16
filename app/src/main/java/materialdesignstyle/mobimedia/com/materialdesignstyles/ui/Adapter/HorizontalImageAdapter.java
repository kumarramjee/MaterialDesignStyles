package materialdesignstyle.mobimedia.com.materialdesignstyles.ui.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import materialdesignstyle.mobimedia.com.materialdesignstyles.R;

/**
 * Created by ram on 15/7/15.
 */
public class HorizontalImageAdapter extends BaseAdapter {
    private Context mContext;
    private int[] imagearray;
    ImageView image;

    public HorizontalImageAdapter(Context mContext, int[] imagearray) {
        this.mContext = mContext;
        this.imagearray = imagearray;
    }


    @Override
    public int getCount() {
        return imagearray.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        convertView = inflater.inflate(R.layout.imagefill, null);

              image = (ImageView) convertView.findViewById(R.id.imageview);

            int m = imagearray[position];
            if (m == 1) {
                image.setImageResource(R.drawable.sky);
            } else if (m == 2) {
                image.setImageResource(R.drawable.moderate);
            } else if (m == 3) {
                image.setImageResource(R.drawable.lightrain);
            } else if (m == 4) {
                image.setImageResource(R.drawable.sky);
            } else if (m == 5) {
                image.setImageResource(R.drawable.lihjtrain);
            } else {
                image.setImageResource(R.drawable.moderate);
            }

        return convertView;
        }


    }

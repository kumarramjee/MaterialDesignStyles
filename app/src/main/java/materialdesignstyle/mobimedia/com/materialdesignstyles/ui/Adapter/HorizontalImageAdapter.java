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
    private int  marraylirst;
    ImageView image;

    public HorizontalImageAdapter(Context mContext, int marraylirst) {
        this.mContext = mContext;
        this.marraylirst = marraylirst;
    }


    @Override
    public int getCount() {
        return marraylirst;
    }

    @Override
    public Object getItem(int position) {
        return null;
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

     for(int i=0;i<marraylirst;i++)
     {
         image.setImageResource(R.drawable.moderate);
     }



        return convertView;
    }


}

package demo.example.com.jasonassign;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by admin on 4/7/2017.
 */

public class ListAdapter extends BaseAdapter {

    Context context;
    ArrayList<String> list = new ArrayList<>();

    public ListAdapter(Context context, ArrayList<String> list){
        this.context = context;
        this.list = list;

    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        String test = list.get(i);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View lay =inflater.inflate(R.layout.custom,null);

       ImageView imageView = (ImageView) lay.findViewById(R.id.image);

        Picasso.with(context).load(test).into(imageView);
        return lay;
    }
}

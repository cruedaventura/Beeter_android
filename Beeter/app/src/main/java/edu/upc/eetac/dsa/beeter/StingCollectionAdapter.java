package edu.upc.eetac.dsa.beeter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import edu.upc.eetac.dsa.beeter.client.entity.Sting;
import edu.upc.eetac.dsa.beeter.client.entity.StingCollection;

/**
 * Created by carol on 17/01/16.
 */
public class StingCollectionAdapter extends BaseAdapter {
    private StingCollection stingCollection;
    private LayoutInflater layoutInflater;
    private ArrayList<Sting> data;
    private LayoutInflater inflater;

    public StingCollectionAdapter(Context context, StingCollection stingCollection){
        layoutInflater = LayoutInflater.from(context);
        this.stingCollection = stingCollection;
    }

    @Override
    public int getCount() {
        return stingCollection.getStings().size();
    }

    @Override
    public Object getItem(int position) {
        return stingCollection.getStings().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_row_sting, null);
            viewHolder = new ViewHolder();
            viewHolder.textViewSubject = (TextView) convertView
                    .findViewById(R.id.textsubject);
            viewHolder.textViewUsername = (TextView) convertView
                    .findViewById(R.id.textUsername);
            viewHolder.textViewDate = (TextView) convertView
                    .findViewById(R.id.textDate);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        String subject = data.get(position).getSubject();
        String username = data.get(position).getUserid();
        String date = SimpleDateFormat.getInstance().format(
                data.get(position).getLastModified());
        viewHolder.textViewSubject.setText(subject);
        viewHolder.textViewUsername.setText(username);
        viewHolder.textViewDate.setText(date);
        return convertView;
    }

    private static class ViewHolder {
        TextView textViewSubject;
        TextView textViewUsername;
        TextView textViewDate;
}

    public StingCollectionAdapter(Context context, ArrayList<Sting> data) {
        super();
        inflater = LayoutInflater.from(context);
        this.data = data;
    }
}

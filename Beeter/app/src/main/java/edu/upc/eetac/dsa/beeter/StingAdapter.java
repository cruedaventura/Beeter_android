package edu.upc.eetac.dsa.beeter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import edu.upc.eetac.dsa.beeter.client.entity.Sting;

/**
 * Created by carol on 17/01/16.
 */
public class StingAdapter extends BaseAdapter{

    private ArrayList<Sting> data;
    private LayoutInflater inflater;

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


    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {

        return Long.parseLong(((Sting) getItem(position)).getId());
    }


    public StingAdapter(Context context, ArrayList<Sting> data) {
        super();
        inflater = LayoutInflater.from(context);
        this.data = data;
    }


}

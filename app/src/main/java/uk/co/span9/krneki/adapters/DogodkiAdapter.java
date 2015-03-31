package uk.co.span9.krneki.adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import uk.co.span9.krneki.R;
import uk.co.span9.krneki.models.Dogodek;

public class DogodkiAdapter extends BaseAdapter {

    public Context mContext;
    public ArrayList<Dogodek> list = new ArrayList<>();

    public DogodkiAdapter(Context context, ArrayList<Dogodek> dogodki) {
        list = dogodki;
        mContext = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.list_item, null);
            holder = new ViewHolder();
            holder.naslov = (TextView) convertView.findViewById(R.id.naslov);
            holder.tekst = (TextView) convertView.findViewById(R.id.tekst);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Dogodek current = list.get(position);
        if (current!=null) {
            holder.naslov.setText(list.get(position).getNaslov());
            holder.tekst.setText(list.get(position).getTekst());
        } else {
            holder.naslov.setText("");
            holder.tekst.setText("");
        }


        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return convertView;
    }

    public static class ViewHolder {
        public TextView naslov;
        public TextView tekst;
    }
}

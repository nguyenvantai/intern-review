package intership.dev.contact;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by nguyenvantai on 7/21/15.
 * create class PersonAdapter extends BaseAdapter
 * then,create constructor have 2 params: context and arraylist
 */

public class PersonAdapter extends BaseAdapter {
    ListView lvPerson;
    private ArrayList<Person> mPersons=null;
    private Activity mContext;

    public PersonAdapter(Activity context, ArrayList<Person> person) {
        mContext = context;
        mPersons = person;
    }

    /**
     * override some method in the system
     * For example:
     * @override getCount-->return size
     * getItem --> return get(possition)
     *
     * @return
     */

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return mPersons.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return mPersons.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    /**
     * create class ViewHolder included: 2 imageviews and a textview
     */

    private static class ViewHolder {
        ImageView imgAvatar;
        TextView tvStatus;
        ImageView imgCheck;
    }

    /**
     *
     Create getView have 3 params: possition,convertView and parent
     purpose: set layout and get infor into listview
     * @return convertView
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(
                    R.layout.custom_listview_person, parent, false);
            holder = new ViewHolder();

            //holder.imgAvatar = (TextView) convertView.findViewById(R.id.im);


            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Person sg = (Person) getItem(position);
        holder.imgAvatar.setImageBitmap(sg.getmAvatar());
        holder.tvStatus.setText(sg.getmStatus());
        holder.imgCheck.setImageBitmap(sg.getmAvatar());

        return convertView;
    }
}

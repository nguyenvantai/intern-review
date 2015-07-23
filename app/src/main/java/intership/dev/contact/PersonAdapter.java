package intership.dev.contact;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static intership.dev.contact.R.drawable.drawable_delete;

/**
 * Created by nguyenvantai on 7/21/15.
 * create class PersonAdapter extends BaseAdapter
 * then,create constructor have 2 params: context and arraylist
 */

public class PersonAdapter extends BaseAdapter {
    LoadMoreListView lvPerson;
    private ArrayList<Person> mPersons = null;
    private Activity mContext;

    public PersonAdapter(Activity context, ArrayList<Person> person) {
        mContext = context;
        mPersons = person;
    }

    /**
     * override some method in the system
     * For example:
     *
     * @return
     * @override getCount-->return size
     * getItem --> return get(possition)
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
        ImageView imgEdit;
        ImageView imgDelete;
    }

    /**
     * Create getView have 3 params: possition,convertView and parent
     * purpose: set layout and get infor into listview
     *
     * @return convertView
     */
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(
                    R.layout.custom_listview_person, parent, false);
            holder = new ViewHolder();

            holder.imgAvatar = (ImageView) convertView.findViewById(R.id.imgAvatar);
            holder.tvStatus = (TextView) convertView.findViewById(R.id.tvStatus);
            holder.imgEdit = (ImageView) convertView.findViewById(R.id.imgEdit);
            holder.imgDelete = (ImageView) convertView.findViewById(R.id.imgDelete);
            holder.imgEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext,ContactActivity.class);
                    Person person = new Person();

                    person.setmAvatar(mPersons.get(position).getmAvatar());
                    person.setmStatus(mPersons.get(position).getmStatus());

                    intent.putExtra("object",(Parcelable)person);

                    mContext.startActivity(intent);




                }
            });



            // event for imageDelete when click
            holder.imgDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //holder.imgDelete.setBackground(android.R.drawable.drawable_delete);
                    String tvName = holder.tvStatus.getText().toString();
                    final Dialog dialog = new Dialog(mContext);
                    // hide to default title for Dialog
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

                    // inflate the layout dialog_layout.xml and set it as contentView
                    LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    View view = inflater.inflate(R.layout.dialog_activity, null, false);
                    dialog.setCanceledOnTouchOutside(false);
                    dialog.setContentView(view);
                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));

                    // Retrieve views from the inflated dialog layout and update their values


                    final TextView tvConfirm = (TextView) dialog.findViewById(R.id.tvConfirm);
                    tvConfirm.setText("Are you sure you want to delete"+" "+tvName+"?");

                    TextView tvOk = (TextView) dialog.findViewById(R.id.tvOk);
                    tvOk.setOnClickListener(new View.OnClickListener() {

                        public void onClick(View v) {

                            //TODO: delete a row have that name
                            //remove the item choosen
                            mPersons.remove(position);
                            // update Adapter
                            notifyDataSetChanged();
                            dialog.dismiss();


                        }
                    });

                    TextView tvCancel = (TextView) dialog.findViewById(R.id.tvCancel);
                    tvCancel.setOnClickListener(new View.OnClickListener() {

                        public void onClick(View v) {
                           dialog.dismiss();
                        }
                    });

                    // Display the dialog
                    dialog.show();


                }
            });

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Person sg = (Person) getItem(position);
        holder.imgAvatar.setImageResource(sg.getmAvatar());
        holder.tvStatus.setText(sg.getmStatus());


        return convertView;
    }





}




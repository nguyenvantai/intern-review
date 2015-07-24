package intership.dev.contact;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by nguyenvantai on 7/21/15.
 */
public class MainActivity extends Activity {
    private ArrayList<Person> mPersons = null;
    PersonAdapter mAdapter = null;
    ImageView imgEdit, imgDelete;
    TextView id;
    //Create data use to add listview and use in LoadMoreListView
    private String mNames[] = {"Luke Skywalker Bell", "Minions Stuart", "Allision Vaney",
            "Luke Skywalker Bell", "Minions Stuart", "Allision Vaney",
            "Luke Skywalker Bell", "Minions Stuart", "Allision Vaney",};
    private int mAvatars[] = {R.drawable.ic_person1, R.drawable.ic_person2, R.drawable.ic_person3,
            R.drawable.ic_person1,
            R.drawable.ic_person2,
            R.drawable.ic_person3,
            R.drawable.ic_person1,
            R.drawable.ic_person2,
            R.drawable.ic_person3};
    // private int mEdit_Delete[]={R.drawable.ic_edit,R.drawable.ic_delete};
    LoadMoreListView lvPerson;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        //int position = data.getIntExtra("position", -1);
        if (requestCode == 110 && resultCode == 123) {
            Bundle bundle = data.getBundleExtra("name");
            Person person = bundle.getParcelable("object");
            String name = person.getmStatus();
            int position = data.getIntExtra("position", 0);

            mPersons.get(position).setmStatus(name);


            mAdapter.notifyDataSetChanged();
        }


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        imgEdit = (ImageView) findViewById(R.id.imgEdit);
        imgDelete = (ImageView) findViewById(R.id.imgDelete);

        lvPerson = (LoadMoreListView) findViewById(R.id.lvPerson);
        mPersons = new ArrayList<Person>();
        lvPerson.setOnLoadMoreListener(new LoadMoreListView.OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                new LoadDataTask().execute();
            }
        });

        for (int i = 0; i < mNames.length; i++) {
            mPersons.add(new Person(mAvatars[i], mNames[i]));
        }
        mAdapter = new PersonAdapter(this, mPersons);

        lvPerson.setAdapter(mAdapter);


    }


    // create thread to use LoadMoreListView
    private class LoadDataTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {

            if (isCancelled()) {
                return null;
            }

            // Simulates a background task,
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }

            for (int i = 0; i < mNames.length; i++) {
                Person person = new Person();
                person.setmAvatar(mAvatars[i]);
                person.setmStatus(mNames[i]);

                mPersons.add(person);


            }
            // mListItems.add(mNames[i]);

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            // mContact.add("Added after load more");

            // We need notify the adapter that the data have been changed
            mAdapter.notifyDataSetChanged();

            // Call onLoadMoreComplete when the LoadMore task, has finished
            lvPerson.onLoadMoreComplete();

            super.onPostExecute(result);
        }

        @Override
        protected void onCancelled() {
            // Notify the loading more operation has finished
            ((LoadMoreListView) lvPerson).onLoadMoreComplete();
        }
    }


}





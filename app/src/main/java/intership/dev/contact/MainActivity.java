package intership.dev.contact;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by nguyenvantai on 7/21/15.
 */
public class MainActivity extends Activity {
    ListView lvPerson;
    private ArrayList<Person> mPersons= null;
    PersonAdapter mAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        lvPerson = (ListView)findViewById(R.id.lvPerson);
        mPersons =  new ArrayList<Person>();
        Bitmap ic_avatar= BitmapFactory.decodeResource(this.getResources(),
                R.drawable.ic_avatar);
        Bitmap ic_edit= BitmapFactory.decodeResource(this.getResources(),
                R.drawable.ic_edit);
        Bitmap ic_delete= BitmapFactory.decodeResource(this.getResources(),
                R.drawable.ic_delete);
        mPersons.add(new Person(ic_avatar,"Luke",ic_edit,ic_delete));
        mPersons.add(new Person(ic_avatar,"Luke",ic_edit,ic_delete));
        mPersons.add(new Person(ic_avatar,"Luke",ic_edit,ic_delete));

        mAdapter = new PersonAdapter(this,mPersons);

        lvPerson.setAdapter(mAdapter);


    }
}

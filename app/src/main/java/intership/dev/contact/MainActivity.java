package intership.dev.contact;

import android.app.Activity;
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

    }
}

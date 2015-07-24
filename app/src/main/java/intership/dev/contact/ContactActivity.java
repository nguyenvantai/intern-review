package intership.dev.contact;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by nguyenvantai on 7/21/15.
 */
    public class ContactActivity extends Activity {
    private TextView mName;
    private ImageView mContact;
    private EditText mEditName,mEditInfor;
    private int mposition;
    public static final int CODE_RESULT=123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        mName = (TextView) findViewById(R.id.tvName);
        mContact = (ImageView) findViewById(R.id.imgContact);
        mEditName = (EditText) findViewById(R.id.edtName);
        mEditInfor = (EditText) findViewById(R.id.edtInfor);
        /** Call fragment
         transfer fragment to frameLayout
         then display on activity
         **/
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        Person person = bundle.getParcelable("object");

        int mContacts = person.getmAvatar();
        String tvName = person.getmStatus();
        mposition = intent.getIntExtra("position", 0);
        mEditName.setHint("" + mName);
        mEditInfor.setHint("Information about" + " " + mName);

        mName.setText(tvName);
        mContact.setImageResource(mContacts);


    }

    // event when click button back
    // return pre-page
    public void onClickBack(View v) {
        finish();
    }
    // event when click button cancel
    // the same as function click button back
    public void onClickCancel( View v){
        finish();
    }
    // when click button save
    // get infor of edit text
    // give to MainActivity

    public void onClickSave(View v) {
        Person person = new Person();
        String name = mEditName.getText().toString();
        person.setmStatus(name);

        Bundle bundle = new Bundle();
        bundle.putParcelable("object", person);


        Intent intent = getIntent();
        intent.putExtra("name", bundle);
        intent.putExtra("position", mposition);

        setResult(CODE_RESULT, intent);
        mEditInfor.setText("" + name);
        finish();

    }
}

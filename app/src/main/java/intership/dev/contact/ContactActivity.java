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
    TextView tvName;
    ImageView imgContact;
    EditText edtName, edtInfor;
    int position;
    public static final int CODE_RESULT=123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        tvName = (TextView) findViewById(R.id.tvName);
        imgContact = (ImageView) findViewById(R.id.imgContact);
        edtName = (EditText) findViewById(R.id.edtName);
        edtInfor = (EditText) findViewById(R.id.edtInfor);


        /** Call fragment
         transfer fragment to frameLayout
         then display on activity
         **/


        Intent intent = getIntent();
        //int value = 10;

        Bundle bundle = intent.getExtras();
        Person person = bundle.getParcelable("object");

        int mContact = person.getmAvatar();
        String mName = person.getmStatus();
        position = intent.getIntExtra("position", 0);
        edtName.setHint("" + mName);
        edtInfor.setHint("Information about" + " " + mName);

        tvName.setText(mName);
        imgContact.setImageResource(mContact);


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
        String name = edtName.getText().toString();


        person.setmStatus(name);

        Bundle bundle = new Bundle();
        bundle.putParcelable("object", person);


        Intent intent = getIntent();
        intent.putExtra("name", bundle);
        intent.putExtra("position", position);

        setResult(CODE_RESULT, intent);
        edtInfor.setText("" + name);
        finish();

    }
}

package intership.dev.contact;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by nguyenvantai on 7/21/15.
 */
public class ContactActivity extends Activity {
    TextView tvName;
    ImageView imgContact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
//        FragmentContact mFragment = new FragmentContact();
//        FragmentTransaction transaction = getFragmentManager().beginTransaction();
//        transaction.add(R.id.frContact, mFragment);
//        transaction.commit();

        tvName = (TextView)findViewById(R.id.tvName);
        imgContact = (ImageView)findViewById(R.id.imgContact);


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

        tvName.setText(mName);
        imgContact.setImageResource(mContact);





    }
    // event when click button back
    // return pre-page
    public void onClickBack(View v){
        finish();
    }
}

package intership.dev.contact;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;

/**
 * Created by nguyenvantai on 7/21/15.
 */
public class ContactActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

       /** Call fragment
        transfer fragment to frameLayout
        then display on activity
        **/
        FragmentContact mFragment = new FragmentContact();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.add(R.id.frContact, mFragment);
        transaction.commit();
    }
    // event when click button back
    // return pre-page
    public void onClickBack(View v){
        finish();
    }
}

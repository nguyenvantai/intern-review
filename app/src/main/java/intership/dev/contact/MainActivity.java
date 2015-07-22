package intership.dev.contact;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by nguyenvantai on 7/21/15.
 */
public class MainActivity extends Activity {
    ListView lvPerson;
    private ArrayList<Person> mPersons= null;
    PersonAdapter mAdapter = null;
    ImageView imgEdit,imgDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        imgEdit = (ImageView)findViewById(R.id.imgEdit);
        imgDelete = (ImageView)findViewById(R.id.imgDelete);

        lvPerson = (ListView)findViewById(R.id.lvPerson);
        mPersons =  new ArrayList<Person>();
        // create bitmap to contain image
        Bitmap ic_person1= BitmapFactory.decodeResource(this.getResources(),
                R.drawable.ic_person1);
        Bitmap ic_person2= BitmapFactory.decodeResource(this.getResources(),
                R.drawable.ic_person2);
        Bitmap ic_person3= BitmapFactory.decodeResource(this.getResources(),
                R.drawable.ic_person3);
        Bitmap ic_edit= BitmapFactory.decodeResource(this.getResources(),
                R.drawable.ic_edit);
        Bitmap ic_delete= BitmapFactory.decodeResource(this.getResources(),
                R.drawable.ic_delete);
        mPersons.add(new Person(ic_person1,"Luke Skywalker Bell",ic_edit,ic_delete));
        mPersons.add(new Person(ic_person2,"Minions Stuart",ic_edit,ic_delete));
        mPersons.add(new Person(ic_person3,"Allision Vaney",ic_edit,ic_delete));

        mPersons.add(new Person(ic_person1,"Luke Skywalker Bell",ic_edit,ic_delete));
        mPersons.add(new Person(ic_person2,"Minions Stuart",ic_edit,ic_delete));
        mPersons.add(new Person(ic_person3,"Allision Vaney",ic_edit,ic_delete));

        mPersons.add(new Person(ic_person1,"Luke Skywalker Bell",ic_edit,ic_delete));
        mPersons.add(new Person(ic_person2,"Minions Stuart",ic_edit,ic_delete));
        mPersons.add(new Person(ic_person3,"Allision Vaney",ic_edit,ic_delete));

        mPersons.add(new Person(ic_person1,"Luke Skywalker Bell",ic_edit,ic_delete));
        mPersons.add(new Person(ic_person2,"Minions Stuart",ic_edit,ic_delete));
        mPersons.add(new Person(ic_person3,"Allision Vaney",ic_edit,ic_delete));


        mAdapter = new PersonAdapter(this,mPersons);

        lvPerson.setAdapter(mAdapter);




    }
    // create method onClickEdit from file .xml
    // control event when you click on image Edit
    public void onClickEdit( View v){
//        final Drawable mDrawable = this.getResources().getDrawable(R.drawable.ic_edit_select);
//        imgEdit.setImageDrawable(mDrawable);




    }
    // create method onClickDelete from file .xml
    // control event when you click on image Delete

    public void onClickDelete( View v){
    createDialog();

    }
    public void createDialog(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                this);


        // set dialog message
        alertDialogBuilder
                .setMessage("Are you sure you want to delete???")
                .setCancelable(false)
                .setPositiveButton("Ok",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        // if this button is clicked, close
                        // current activity
                        //MainActivity.this.finish();
                        //Delete here
                    }
                })
                .setNegativeButton("Cancel",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        // if this button is clicked, just close
                        // the dialog box and do nothing
                        dialog.cancel();
                    }
                });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();
    }
    }





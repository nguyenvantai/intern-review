package intership.dev.contact;

import android.graphics.Bitmap;

/**
 * Created by nguyenvantai on 7/21/15.
 */
public class Person {
    private Bitmap mAvatar;
    private String mStatus;
    private Bitmap mEdit;
    private Bitmap mDelete;

    public Person(Bitmap mAvatar, String mStatus, Bitmap mEdit, Bitmap mDelete) {
        this.mAvatar = mAvatar;
        this.mStatus = mStatus;
        this.mEdit = mEdit;
        this.mDelete = mDelete;
    }
    /**
     *Create class Person include 4 params: mAvatar,mStatus,mEdit,mDelete
     * Then,create constructor Person
     */


    public Bitmap getmDelete() {
        return mDelete;
    }

    public void setmDelete(Bitmap mDelete) {
        this.mDelete = mDelete;
    }

    public Bitmap getmEdit() {
        return mEdit;
    }

    public void setmEdit(Bitmap mEdit) {
        this.mEdit = mEdit;
    }

    /**
     *

     create getter and setter
     */

    public Bitmap getmAvatar() {
        return mAvatar;
    }

    public void setmAvatar(Bitmap mAvatar) {
        this.mAvatar = mAvatar;
    }

    public String getmStatus() {
        return mStatus;
    }

    public void setmStatus(String mStatus) {
        this.mStatus = mStatus;
    }

}

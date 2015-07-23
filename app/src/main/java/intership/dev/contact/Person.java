package intership.dev.contact;

import android.graphics.Bitmap;

/**
 * Created by nguyenvantai on 7/21/15.
 */
public class Person {
    private int mAvatar;
    private String mStatus;
    private int mEdit;
    private int mDelete;

    public Person(int mAvatar, String mStatus, int mEdit,int mDelete) {
        this.mAvatar = mAvatar;
        this.mStatus = mStatus;
        this.mEdit = mEdit;
        this.mDelete = mDelete;
    }
    public Person(){

    }

    public int getmAvatar() {
        return mAvatar;
    }

    public void setmAvatar(int mAvatar) {
        this.mAvatar = mAvatar;
    }

    public String getmStatus() {
        return mStatus;
    }

    public void setmStatus(String mStatus) {
        this.mStatus = mStatus;
    }

    public int getmEdit() {
        return mEdit;
    }

    public void setmEdit(int mEdit) {
        this.mEdit = mEdit;
    }

    public int getmDelete() {
        return mDelete;
    }

    public void setmDelete(int mAvatar) {
        this.mDelete= mDelete;
    }
}

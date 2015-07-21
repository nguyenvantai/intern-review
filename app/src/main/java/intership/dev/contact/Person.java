package intership.dev.contact;

import android.graphics.Bitmap;

/**
 * Created by nguyenvantai on 7/21/15.
 */
public class Person {
    private Bitmap mAvatar;
    private String mStatus;
    private Bitmap mCheck;

    /**
     *Create class Person include 3 params: mAvatar,mStatus,mCheck
     * Then,create constructor Person
     */
    public Person(Bitmap mAvatar, String mStatus, Bitmap mCheck) {
        this.mAvatar = mAvatar;
        this.mStatus = mStatus;
        this.mCheck = mCheck;
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

    public Bitmap getmCheck() {
        return mCheck;
    }

    public void setmCheck(Bitmap mCheck) {
        this.mCheck = mCheck;
    }
}

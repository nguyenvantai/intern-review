package intership.dev.contact;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by nguyenvantai on 7/21/15.
 */
public class Person implements Parcelable {
    private int mAvatar;
    private String mStatus;

// create constructor included 2 parameters
    public Person(int mAvatar, String mStatus) {
        this.mAvatar = mAvatar;
        this.mStatus = mStatus;
    }
    // create constructor dont have parameter
    public Person(){

    }
    // implement from MainActivity
    public Person(Parcel str) {
        readFromParcel(str);
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




    @Override
    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mStatus);
        parcel.writeInt(mAvatar);


    }

    private void readFromParcel(Parcel Str) {
        mStatus = Str.readString();
        mAvatar= Str.readInt();

    }
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Person createFromParcel(Parcel Str) {
            return new Person(Str);
        }

        public Person[] newArray(int size) {
            return new Person[size];
        }
    };
}


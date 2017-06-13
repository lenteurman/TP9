package com.example.admin.tp9;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by admin on 13/06/2017.
 */

public class Point implements Parcelable {
    private int compteur;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        out.writeInt(compteur);
    }

    public static final Parcelable.Creator<Point> CREATOR = new Parcelable.Creator<Point>() {
        public Point createFromParcel(Parcel in) {
            return new Point(in);
        }

        public Point[] newArray(int size) {
            return new Point[size];
        }
    };

    private Point(Parcel in) {
        compteur = in.readInt();
    }
    public Point(int valeur) {
        compteur = valeur;
    }
}

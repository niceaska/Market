package ru.niceaska.market;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class TestModel implements Parcelable {

    private String firstRandom;
    private String secondRandom;
    private List<String> randList;
    private List<String> randListTwo;


    TestModel(String firstRandom, String secondRandom, List<String> randList, List<String> randListTwo) {
        this.firstRandom = firstRandom;
        this.secondRandom = secondRandom;
        this.randList = randList;
        this.randListTwo = randListTwo;
    }
    @Override
    public int describeContents() {
        return 0;
    }

    public String getFirstRandom() {
        return firstRandom;
    }

    public void setFirstRandom(String firstRandom) {
        this.firstRandom = firstRandom;
    }

    public String getSecondRandom() {
        return secondRandom;
    }

    public void setSecondRandom(String secondRandom) {
        this.secondRandom = secondRandom;
    }

    public List<String> getRandList() {
        return randList;
    }

    public void setRandList() {

        this.randList = new ArrayList<>();
    }

    public List<String> getRandListTwo() {
        return randListTwo;
    }

    public void setRandListTwo() {
        this.randListTwo = new ArrayList<>();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(firstRandom);
        dest.writeString(secondRandom);
        dest.writeStringList(randList);
        dest.writeStringList(randListTwo);
        Log.d("FFTTTTTTTTTTTTTTT", "is write packed");


    }

     TestModel(Parcel in) {
        this.firstRandom = in.readString();
        this.secondRandom = in.readString();
        this.randList = in.createStringArrayList();
        this.randListTwo = in.createStringArrayList();
        Log.d("FFTTTTTTTTTTTTTTT", "is unpacked");

    }


    public static final Parcelable.Creator<TestModel> CREATOR = new Parcelable.Creator<TestModel>() {
        public TestModel createFromParcel(Parcel source) {
            return new TestModel(source);
        }

        public TestModel[] newArray(int size) {
            return new TestModel[size];
        }
    };
}

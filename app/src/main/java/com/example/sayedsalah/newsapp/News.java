package com.example.sayedsalah.newsapp;

/**
 * Created by akueisara on 10/9/2016.
 */

public class News {
    private String mTitle;
    private String mType;
    private String mDate;
    private String mSection;
    private String mUrl;
    private String[] firstname;

    public News(String title, String type, String date, String section, String url, String[] author) {
        this.mTitle = title;
        this.mType = type;
        this.mDate = date;
        this.mSection = section;
        this.mUrl = url;
        this.firstname = author;

    }

    public String getTitle() {
        return mTitle;
    }

    public String getType() {
        return mType;
    }

    public String getDate() {
        return mDate;
    }

    public String getSection() {
        return mSection;
    }

    public String getUrl() {
        return mUrl;
    }

    public String getFirstname() {
        String s = "";
        for (int i = 0; i < firstname.length; i++) {
            if (i == firstname.length - 1)
                s += firstname[i];
            else
                s += firstname[i] + ", ";
        }
        return s;
    }
}

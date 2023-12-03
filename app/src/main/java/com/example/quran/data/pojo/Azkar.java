package com.example.quran.data.pojo;

public class Azkar {
    private String zekr;
    private String category;
    private String description;
    private String reference;
    private String count;

    public Azkar(String zekr, String category, String description, String reference, String count) {
        this.zekr = zekr;
        this.category = category;
        this.description = description;
        this.reference = reference;
        this.count = count;
    }

    public String getZekr() {
        return zekr;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public String getReference() {
        return reference;
    }

    public String getCount() {
        return count;
    }
}

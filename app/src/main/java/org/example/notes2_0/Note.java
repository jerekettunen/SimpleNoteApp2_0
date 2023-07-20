package org.example.notes2_0;

import java.util.ArrayList;

public class Note {
    private String title;
    private String details;
    private long time;
    private boolean important;


    public Note(String title, String details, long time, boolean important) {
        this.title = title;
        this.details = details;
        this.time = time;
        this.important = important;
    }

    public long getTime() {
        return time;
    }

    public String getDetails() {
        return details;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public boolean getImportance() { return important; }
}

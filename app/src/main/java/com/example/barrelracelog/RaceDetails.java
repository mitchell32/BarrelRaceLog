package com.example.barrelracelog;

/**
 * Created by mitch on 4/20/2017.
 */

public class RaceDetails {
    private int time;
    private String position;
    private String date;
    private String additionalNotes;

    public RaceDetails(int time, String position, String date, String additionalNotes){
        this.time = time;
        this.position = position;
        this.date = date;
        this.additionalNotes = additionalNotes;
    }


}

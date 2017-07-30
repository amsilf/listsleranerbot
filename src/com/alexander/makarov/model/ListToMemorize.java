package com.alexander.makarov.model;

public class ListToMemorize {

    private static final long DEFAULT_REPETITION_FREQUENCY = 3600;

    private String listName;
    private long repetitionFrequency = DEFAULT_REPETITION_FREQUENCY;

    public ListToMemorize(String listName) {
        this.listName = listName;
    }

    public ListToMemorize(String listName, long repetitionFrequency) {
        this.listName = listName;
        this.repetitionFrequency = repetitionFrequency;
    }

    public String getListName() {
        return listName;
    }

    public long getRepetitionFrequency() {
        return repetitionFrequency;
    }
}

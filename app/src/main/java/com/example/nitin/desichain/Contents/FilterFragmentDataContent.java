package com.example.nitin.desichain.Contents;

/**
 * Created by ashis on 7/13/2017.
 */

public class FilterFragmentDataContent {

    private String name;
    private boolean isSelected;


    public FilterFragmentDataContent(String name, boolean isSelected) {
        this.name = name;
        this.isSelected = isSelected;
    }

    public FilterFragmentDataContent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}

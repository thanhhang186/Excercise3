package com.khtn.hang.homeworkweek3;

/**
 * Created by nhyml on 3/17/2018.
 */

public class Date {
    private String maximum;
    private String minimum;

    public Date() {
    }

    public Date(String maximum, String minimum) {
        this.maximum = maximum;
        this.minimum = minimum;
    }

    public String getMaximum() {
        return maximum;
    }

    public void setMaximum(String maximum) {
        this.maximum = maximum;
    }

    public String getMinimum() {
        return minimum;
    }

    public void setMinimum(String minimum) {
        this.minimum = minimum;
    }
}

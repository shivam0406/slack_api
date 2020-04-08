package com.slack.channel;

import lombok.Getter;
import lombok.Setter;

public class Purpose {


    private String value;

    private String creator;

    private Number last_set;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Number getLast_set() {
        return last_set;
    }

    public void setLast_set(Number last_set) {
        this.last_set = last_set;
    }
}

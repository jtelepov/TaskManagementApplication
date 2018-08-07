package com.jantelepovsky.taskmanagement.data;

import java.time.LocalDate;

public class TodoItem {
    private String item;
    private String description;
    private LocalDate deadLine;

    public TodoItem(String item, String description, LocalDate deadLine) {
        this.item = item;
        this.description = description;
        this.deadLine = deadLine;
    }

    public String getItem() {
        return item;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDeadLine() {
        return deadLine;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDeadLine(LocalDate deadLine) {
        this.deadLine = deadLine;
    }


}

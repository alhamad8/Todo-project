package com.qacart.todo.objects;

public class Task {


    public Task(boolean isCompleted, String item) {
        this.isCompleted = isCompleted;
        this.item = item;
    }

    public boolean getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(boolean completed) {
        isCompleted = completed;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    private boolean isCompleted;
    private String  item;
}

package org.example;

public class Memory {
    private String content;
    private int impact;
    private int recurrence;

    public Memory(String content, int impact, int recurrence) {
        this.content = content;
        this.impact = impact;
        this.recurrence = recurrence;
    }

    public void remember() {
        System.out.println("Remembering memory " + content + " with impact " + impact + " and recurrence " + recurrence + " times.");
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getImpact() {
        return impact;
    }

    public void setImpact(int impact) {
        this.impact = impact;
    }

    public int getRecurrence() {
        return recurrence;
    }

    public void setRecurrence(int recurrence) {
        this.recurrence = recurrence;
    }
}
package data;

import java.util.Date;

public class Task {
    private String title;
    private Date startDate;
    private Boolean completed;

    public Task(String title, Date startDate, Boolean completed) {
        this.title = title;
        this.startDate = startDate;
        this.completed = completed;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}

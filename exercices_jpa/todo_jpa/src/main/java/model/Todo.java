package model;

import javax.persistence.*;

@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50)
    private String title;
    private Boolean isDone;

    public Todo() {
        this.isDone = false;
    }
    public Todo(String title) {
        this();
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getIsDone() {
        return isDone;
    }

    public void setIsDone(Boolean status) {
        this.isDone = status;
    }

    @Override
    public String toString() {
        return "Todo : " +
                "id=" + id +
                ", title='" + title + '\'' +
                ", isDone=" + isDone ;
    }
}

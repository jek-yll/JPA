package model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "infos")
public class InfosTodo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_infos")
    private Long id;
    @Column(length = 500)
    private String description;
    private LocalDate date;
    private Integer priority;
    @OneToOne(mappedBy = "infos")
    private Todo todo;

    public InfosTodo(){
        date = LocalDate.now();
    }

    public InfosTodo(String description, Integer priority) {
        this();
        this.description = description;
        this.priority = priority;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Todo getTodo() {
        return todo;
    }

    public void setTodo(Todo todo) {
        this.todo = todo;
    }

    @Override
    public String toString() {
        return "InfosTodo{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", priority=" + priority +
                '}';
    }
}

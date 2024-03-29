package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50)
    private String title;
    private Boolean isDone;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "infos_id", referencedColumnName = "id_infos")
    private InfosTodo infos;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id_user")
    private User user;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "cat_todo",
            joinColumns = @JoinColumn(name = "cat_id"),
            inverseJoinColumns = @JoinColumn(name = "todo_id"))
    private List<Category> categories = new ArrayList<>();
    public Todo() {
        this.isDone = false;
    }
    public Todo(String title, InfosTodo infos, User user) {
        this();
        this.title = title;
        this.infos = infos;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public InfosTodo getInfos() {
        return infos;
    }

    public void setInfos(InfosTodo infos) {
        this.infos = infos;
    }

    public Boolean getIsDone() {
        return isDone;
    }

    public void setIsDone(Boolean status) {
        this.isDone = status;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", isDone=" + isDone +
                ", infos=" + infos +
                '}';
    }
}

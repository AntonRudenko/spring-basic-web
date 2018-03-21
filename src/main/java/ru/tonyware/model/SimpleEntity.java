package ru.tonyware.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SimpleEntity {

    @Id
    private Long id;
    private String text;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

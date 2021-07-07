package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Issue {
    private int id;
    private String title;
    private String write;
    private boolean open;
    private String author;
    private String assignee;
    private HashSet<Labels> labels = new HashSet<>();
    private int countComment;

    public Issue(int id, String title, String write, boolean open, String author, String assignee, Labels label, int countComment) {
        this.id = id;
        this.title = title;
        this.write = write;
        this.open = open;
        this.author = author;
        this.assignee = assignee;
        this.labels.add(label);
        this.countComment = countComment;

    }

}

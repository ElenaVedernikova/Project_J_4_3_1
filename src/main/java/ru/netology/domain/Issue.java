package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Issue extends HashSet<Issue> {
    private int id;
    private String title;
    private String write;
    private boolean open;
    private HashSet<Authors> authors = new HashSet<>();
    private HashSet<Assignee> assignees = new HashSet<>();
    private HashSet<Labels> labels = new HashSet<>();
    private int countComment;

    public Issue(int id, String title, String write, boolean open, Authors author, Assignee assignee, Labels label, int countComment) {
        this.id = id;
        this.title = title;
        this.write = write;
        this.open = open;
        this.authors.add(author);
        this.assignees.add(assignee);
        this.labels.add(label);
        this.countComment = countComment;

    }

}

package ru.netology.manager;

import ru.netology.domain.*;
import ru.netology.repository.IssueRepository;

import java.util.ArrayList;
import java.util.List;

public class IssueManager {
    private IssueRepository repository;

    public IssueManager(IssueRepository repository) {
        this.repository = repository;
    }

    public void add(Issue issue) {
        repository.save(issue);
    }

    public List<Issue> filterByLabel(Labels label) {
        List<Issue> result = new ArrayList<>();
        for (Issue issue : repository.getAll()) {
            if (issue.getLabels().contains(label)) {
                result.add(issue);
            }
        }
        return result;
    }

    public List<Issue> filterByAuthor(String author) {
        List<Issue> result = new ArrayList<>();
        for (Issue issue : repository.getAll()) {
            if (issue.getAuthor().contains(author)) {
                result.add(issue);
            }
        }
        return result;
    }

    public List<Issue> filterByAssignee(String assignee) {
        List<Issue> result = new ArrayList<>();
        for (Issue issue : repository.getAll()) {
            if (issue.getAssignee().contains(assignee)) {
                result.add(issue);
            }
        }
        return result;
    }


    public List<Issue> sortByCountComment() {
        List<Issue> result = new ArrayList<>();
        for (Issue issue : repository.getAll()) {
            result.add(issue);
            result.sort(new CountCommentComparator());
        }
        return result;
    }

    public List<Issue> sortByCountCommentRevers() {
        List<Issue> result = new ArrayList<>();
        for (Issue issue : repository.getAll()) {
            result.add(issue);
            result.sort(new CountCommentComparator().reversed());
        }
        return result;
    }


    public List<Issue> findAllOpen() {
        List<Issue> result = new ArrayList<>();
        for (Issue issue : repository.getAll()) {
            if (issue.isOpen()) {
                result.add(issue);
            }
        }
        return result;
    }

    public List<Issue> findAllClosed() {
        List<Issue> temp = new ArrayList<>();
        for (Issue issue : repository.getAll()) {
            if (!issue.isOpen()) {
                temp.add(issue);
            }
        }
        return temp;
    }

    public void openById(int id) {
        repository.openById(id);
    }

    public void closeById(int id) {
        repository.closeById(id);
    }
}

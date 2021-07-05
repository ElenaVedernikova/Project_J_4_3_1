package ru.netology.manager;

import ru.netology.domain.Authors;
import ru.netology.domain.Issue;
import ru.netology.domain.Labels;
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
        List<Issue> temp = new ArrayList<>();
        for (Issue issue : repository.getAll()) {
            if (issue.getLabels().contains(label)) {
                temp.add(issue);
            }
        }
        return temp;
    }

    public List<Issue> filterByAuthor(Authors author) {
        List<Issue> temp = new ArrayList<>();
        for (Issue issue : repository.getAll()) {
            if (issue.getAuthors().contains(author)) {
                temp.add(issue);
            }
        }
        return temp;
    }


    public List<Issue> findAllOpen() {
        List<Issue> temp = new ArrayList<>();
        for (Issue issue : repository.getAll()) {
            if (issue.isOpen()) {
                temp.add(issue);
            }
        }
        return temp;
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

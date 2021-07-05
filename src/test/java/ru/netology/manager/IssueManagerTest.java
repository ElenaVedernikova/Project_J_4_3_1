package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.*;
import ru.netology.repository.IssueRepository;
import java.util.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class IssueManagerTest {
    private IssueRepository repository = new IssueRepository();
    private IssueManager manager = new IssueManager(repository);

    private Issue issue1 = new Issue(1, "Issue1", "Write1", true, new Authors("Ivanov"), new Assignee("Petrov"), new Labels("progress"), 15);
    private Issue issue2 = new Issue(2, "Issue2", "Write2", true, new Authors("Petrov"), new Assignee("Ivanov"), new Labels("bug"), 11);
    private Issue issue3 = new Issue(3, "Issue3", "Write3", true, new Authors("Ivanov"), new Assignee("Petrov"), new Labels("progress"), 1);
    private Issue issue4 = new Issue(4, "Issue4", "Write4", true, new Authors("Petrov"), new Assignee("Ivanov"), new Labels("bug"), 20);

    @Test
    public void shouldfindByAuthor() {
        manager.add(issue1);
        manager.add(issue2);
        manager.add(issue3);
        manager.add(issue4);

        Collection<Issue> actual = manager.filterByAuthor(new Authors("Ivanov"));
        List<Issue> expected = Arrays.asList(issue1, issue3);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldfindByEmptyAuthor() {

        Collection<Issue> actual = manager.filterByAuthor(new Authors());
        List<Issue> expected = Arrays.asList();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldfindByLabels() {
        manager.add(issue1);
        manager.add(issue2);
        manager.add(issue3);
        manager.add(issue4);

        Collection<Issue> actual = manager.filterByLabel(new Labels("bug"));
        List<Issue> expected = Arrays.asList(issue2, issue4);

        assertEquals(expected, actual);
    }

}
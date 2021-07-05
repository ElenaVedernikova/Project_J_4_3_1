package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.*;
import ru.netology.repository.IssueRepository;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IssueManagerTest {
    private IssueRepository repository = new IssueRepository();
    private IssueManager manager = new IssueManager(repository);

    private Issue issue1 = new Issue(1, "Issue1", "Write1", true, new Authors("Ivanov"), new Assignee("Petrov"), new Labels("progress"), 15);
    private Issue issue2 = new Issue(2, "Issue2", "Write2", false, new Authors("Petrov"), new Assignee("Ivanov"), new Labels("bug"), 11);
    private Issue issue3 = new Issue(3, "Issue3", "Write3", false, new Authors("Ivanov"), new Assignee("Petrov"), new Labels("bug"), 1);
    private Issue issue4 = new Issue(4, "Issue4", "Write4", true, new Authors("Petrov"), new Assignee("Ivanov"), new Labels("progress"), 20);

    @Test
    public void shouldFindByAuthor() {
        manager.add(issue1);
        manager.add(issue2);
        manager.add(issue3);
        manager.add(issue4);

        Collection<Issue> actual = manager.filterByAuthor(new Authors("Ivanov"));
        List<Issue> expected = Arrays.asList(issue1, issue3);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindByOneAuthor() {
        manager.add(issue4);

        Collection<Issue> actual = manager.filterByAuthor(new Authors("Petrov"));
        List<Issue> expected = Arrays.asList(issue4);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindByEmptyAuthor() {

        Collection<Issue> actual = manager.filterByAuthor(new Authors());
        List<Issue> expected = Arrays.asList();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindByAssignee() {
        manager.add(issue1);
        manager.add(issue2);
        manager.add(issue3);
        manager.add(issue4);

        Collection<Issue> actual = manager.filterByAssignee(new Assignee("Petrov"));
        List<Issue> expected = Arrays.asList(issue1, issue3);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindByOneAssignee() {
        manager.add(issue4);

        Collection<Issue> actual = manager.filterByAssignee(new Assignee("Ivanov"));
        List<Issue> expected = Arrays.asList(issue4);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindByEmptyAssignee() {

        Collection<Issue> actual = manager.filterByAssignee(new Assignee());
        List<Issue> expected = Arrays.asList();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindByLabels() {
        manager.add(issue1);
        manager.add(issue2);
        manager.add(issue3);
        manager.add(issue4);

        Collection<Issue> actual = manager.filterByLabel(new Labels("bug"));
        List<Issue> expected = Arrays.asList(issue2, issue3);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindByOneLabels() {
        manager.add(issue4);

        Collection<Issue> actual = manager.filterByLabel(new Labels("progress"));
        List<Issue> expected = Arrays.asList(issue4);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindByEmptyLabels() {

        Collection<Issue> actual = manager.filterByLabel(new Labels());
        List<Issue> expected = Arrays.asList();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldSortByCountComments() {
        manager.add(issue1);
        manager.add(issue2);
        manager.add(issue3);
        manager.add(issue4);

        List<Issue> expected = Arrays.asList(issue3, issue2, issue1, issue4);
        Collection<Issue> actual = manager.sortByCountComment();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldSortByCountCommentsRevers() {
        manager.add(issue1);
        manager.add(issue2);
        manager.add(issue3);
        manager.add(issue4);

        List<Issue> expected = Arrays.asList(issue4, issue1, issue2, issue3);
        Collection<Issue> actual = manager.sortByCountCommentRevers();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindAllOpen() {
        manager.add(issue1);
        manager.add(issue2);
        manager.add(issue3);
        manager.add(issue4);

        List<Issue> expected = Arrays.asList(issue1, issue4);
        Collection<Issue> actual = manager.findAllOpen();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindAllClosed() {
        manager.add(issue1);
        manager.add(issue2);
        manager.add(issue3);
        manager.add(issue4);

        List<Issue> expected = Arrays.asList(issue2, issue3);
        Collection<Issue> actual = manager.findAllClosed();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldOpenById() {
        manager.openById(1);
        assertTrue(issue1.isOpen());
    }

    @Test
    public void shouldCloseById() {
        manager.closeById(4);
        assertTrue(issue4.isOpen());
    }


}
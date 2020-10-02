package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.FilmItem;
import ru.netology.repository.AfishaRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AfishaManagerTestRemoveToID {
    @Mock
    private AfishaRepository repository;

    @InjectMocks
    private AfishaManager manager;
    private FilmItem one = new FilmItem(1, "https://", "One Flew Over the Cuckoo's Nest (1975)", 1);
    private FilmItem two = new FilmItem(2, "https://", "Two Women (1960)", 1);
    private FilmItem three = new FilmItem(3, "https://", "Three Men and a Baby (1987)", 1);
    private FilmItem four = new FilmItem(4, "https://", "Four Rooms (1995)", 1);
    private FilmItem five = new FilmItem(5, "https://", "The Fifth Element (1997)", 1);
    private FilmItem six = new FilmItem(6, "https://", "6 Souls (2010)", 1);

    @BeforeEach
    public void setUp() {
        manager.add(four);
        manager.add(five);
        manager.add(six);
    }

    @Test
    public void shouldRemoveIfExists() {
        int removeToId = 16;
        FilmItem[] returned = new FilmItem[]{four, five};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).removeById(removeToId);

        manager.removeById(removeToId);
        FilmItem[] expected = new FilmItem[]{five, four};
        FilmItem[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
        verify(repository).removeById(removeToId);
    }

    @Test
    public void shouldRemoveIfEx() {
        int removeToId = 17;
        FilmItem[] returned = new FilmItem[]{four, five};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).removeById(removeToId);

        manager.removeById(removeToId);
        FilmItem[] expected = new FilmItem[]{five, four};
        FilmItem[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
        verify(repository).removeById(removeToId);
    }
}
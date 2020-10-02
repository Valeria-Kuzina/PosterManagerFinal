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
public class AfishaManagerTestFindByID {
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


    //findById
    @Test
    public void shouldFindIfNonExistent() {
        int findToId = 3;
        FilmItem[] returned = new FilmItem[]{three, four, five, six};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).findById(findToId);

        manager.findById(findToId);
        FilmItem[] expected = new FilmItem[]{six, five, four, three};
        FilmItem[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
        verify(repository).findById(findToId);
    }
}
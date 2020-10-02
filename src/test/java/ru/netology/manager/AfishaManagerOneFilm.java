package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.FilmItem;

import static org.junit.jupiter.api.Assertions.*;

class AfishaManagerOneFilm {
    private AfishaManager manager = new AfishaManager();
    private FilmItem one = new FilmItem(1, "https://", "One Flew Over the Cuckoo's Nest (1975)", 1);

    @BeforeEach
    public void setUp() {
        manager.add(one);
    }

    @Test
    public void shouldBeOneMovie() {

        FilmItem[] actual = manager.getAll();
        FilmItem[] expected = new FilmItem[]{one};

        assertArrayEquals(expected, actual);
    }
}
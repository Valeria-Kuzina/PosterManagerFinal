package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.FilmItem;

import static org.junit.jupiter.api.Assertions.*;

class AfishaManagerIsEmpty {
    private AfishaManager manager = new AfishaManager();

    @Test
    public void shouldBeNoOneMovie() {

        FilmItem[] actual = manager.getAll();
        FilmItem[] expected = new FilmItem[]{};

        assertArrayEquals(expected, actual);
    }
}
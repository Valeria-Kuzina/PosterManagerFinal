package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.FilmItem;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class AfishaManagerMoreThen10Films {
    private AfishaManager manager = new AfishaManager();
    private FilmItem one = new FilmItem(1, "https://", "One Flew Over the Cuckoo's Nest (1975)", 1);
    private FilmItem two = new FilmItem(2, "https://", "Two Women (1960)", 1);
    private FilmItem three = new FilmItem(3, "https://", "Three Men and a Baby (1987)", 1);
    private FilmItem four = new FilmItem(4, "https://", "Four Rooms (1995)", 1);
    private FilmItem five = new FilmItem(5, "https://", "The Fifth Element (1997)", 1);
    private FilmItem six = new FilmItem(6, "https://", "6 Souls (2010)", 1);
    private FilmItem seven = new FilmItem(7, "https://", "Seven Years in Tibet (1997)", 1);
    private FilmItem eight = new FilmItem(8, "https://", "8 Mile (2002)", 1);
    private FilmItem nine = new FilmItem(9, "https://", "Nine Months (1995)", 1);
    private FilmItem ten = new FilmItem(10, "https://", "10 Items or Less (2006)", 1);
    private FilmItem eleven = new FilmItem(11, "https://", "The 11th Hour (2007)", 1);
    private FilmItem twelve = new FilmItem(12, "https://", "12 Years a Slave (2013)", 1);

    @BeforeEach
    public void setUp() {
        manager.add(one);
        manager.add(two);
        manager.add(three);
        manager.add(four);
        manager.add(five);
        manager.add(six);
        manager.add(seven);
        manager.add(eight);
        manager.add(nine);
        manager.add(ten);
        manager.add(eleven);
        manager.add(twelve);
    }

/*    @Test
    void add() {
        FilmItem thirteen = new FilmItem(13, 13, "13", 1);
        manager.add(thirteen);
        FilmItem[] actual = manager.getNumberOfFilms(1);
        FilmItem[] expected = new FilmItem[]{thirteen};
        assertArrayEquals(expected, actual);
    }*/

    @Test
    public void shouldBeTenMovie() {

        FilmItem[] actual = manager.getAll();
        FilmItem[] expected = new FilmItem[]{twelve, eleven, ten, nine, eight,
                seven, six, five, four, three};

        assertArrayEquals(expected, actual);
    }
}

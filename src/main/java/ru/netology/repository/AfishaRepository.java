package ru.netology.repository;

import ru.netology.domain.FilmItem;

public class AfishaRepository {
    private FilmItem[] items = new FilmItem[0];

    public void save(FilmItem movie) {
        int length = items.length + 1;
        FilmItem[] tmp = new FilmItem[length];

        System.arraycopy(items, 0, tmp, 0, items.length);

        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = movie;
        items = tmp;
    }

    public FilmItem[] findAll() {
        return items;
    }

    public void removeById(int id) {
        int length = items.length - 1;
        FilmItem[] tmp = new FilmItem[length];
        int index = 0;
        for (FilmItem item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }

    public FilmItem findById(int id) {
        FilmItem tmp = null;
        for (FilmItem items : items) {
            if (items.getId() == id) {
                tmp = items;
            }
        }
        return tmp;
    }

    public void removeAll() {
        items = new FilmItem[0];
    }
}

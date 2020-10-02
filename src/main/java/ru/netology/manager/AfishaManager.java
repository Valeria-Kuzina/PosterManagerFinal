package ru.netology.manager;

import ru.netology.domain.FilmItem;

public class AfishaManager {
    private FilmItem[] items = new FilmItem[0];

    // добавление фильма
    public void add(FilmItem item) {
        int length = items.length + 1;
        FilmItem[] tmp = new FilmItem[length];

        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public FilmItem[] getAll() {
        int defaultFilm = 10;
//////////////////////////////////////////////
        int customFilm = items.length;
        FilmItem[] result = new FilmItem[defaultFilm];

        if (customFilm < defaultFilm) {
            result = new FilmItem[items.length];
        }
///////////////////////////////////////////

        // перебираем массив в прямом порядке
        // но кладём в результаты в обратном
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }
}

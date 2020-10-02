package ru.netology.manager;

import ru.netology.domain.FilmItem;
import ru.netology.repository.AfishaRepository;

public class AfishaManager {
    private AfishaRepository repository;

    public AfishaManager(AfishaRepository repository) {
        this.repository = repository;
    }

    public void add(FilmItem movie) {
        repository.save(movie);
    }

    public FilmItem[] getAll() {
        FilmItem[] tmp = repository.findAll();
        int defaultFilm = 10;
        int filmCount = tmp.length;
        FilmItem[] result = new FilmItem[filmCount];

        if (filmCount<defaultFilm){
            result = new FilmItem[tmp.length];
        }
        for (int i = 0; i < result.length; i++) {
            int index = tmp.length - i - 1;
            result[i] = tmp[index];
        }
        return result;
    }

    public void removeById(int id) {
        repository.removeById(id);
    }

    public FilmItem findById(int id) {
        return repository.findById(id);
    }

    public void removeAll() {
        repository.removeAll();
    }

}

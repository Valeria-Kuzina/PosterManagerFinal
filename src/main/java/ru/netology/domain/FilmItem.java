package ru.netology.domain;

import lombok.* ;

@NoArgsConstructor
//@AllArgsConstructor
@Data
public class FilmItem {

    private int id;
    private String imageUrl;
    private String filmName;
    private int count;

    public FilmItem(int i, String s, String s1, int i1) {
    }
}

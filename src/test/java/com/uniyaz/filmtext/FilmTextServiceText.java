package com.uniyaz.filmtext;

import com.uniyaz.film_text.service.FilmTextService;
import com.uniyaz.film_text.domain.FilmText;
import org.junit.Test;

import java.util.List;

public class FilmTextServiceText {
    @Test
    public void findAllTest() {

        FilmTextService filmTextService = new FilmTextService();
        List<FilmText> filmTexts = filmTextService.findAll();
        for (FilmText filmText : filmTexts) {
            System.out.println(filmText);
        }

    }
}

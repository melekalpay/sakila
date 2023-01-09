package com.uniyaz.language;

import com.uniyaz.category.domain.Category;
import com.uniyaz.category.service.CategoryService;
import com.uniyaz.language.domain.Language;
import com.uniyaz.language.service.LanguageService;
import org.junit.Test;

import java.util.List;

public class LanguageServiceTest {
    @Test
    public void findAllTest() {

        LanguageService languageService = new LanguageService();
        List<Language> languages = languageService.findAll();
        for (Language language : languages) {
            System.out.println(language);
        }

    }
}

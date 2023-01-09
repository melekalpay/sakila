package com.uniyaz.language.service;

import com.uniyaz.actor.dao.ActorDao;
import com.uniyaz.actor.domain.Actor;
import com.uniyaz.language.dao.LanguageDao;
import com.uniyaz.language.domain.Language;

import java.util.List;

public class LanguageService {
    public List<Language> findAll() {
        LanguageDao languageDao = new LanguageDao();
        return languageDao.findAll();
    }
}

package com.uniyaz.language.queryfilterdto;

public class LanguageQueryFilterDto {
    private  Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    private String languageName;
}

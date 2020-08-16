package com.nnk.springboot.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "rulename")
public class RuleName {
    @Id
    @GeneratedValue
    private int id;
    @NotBlank(message = "Name ne doit pas etre vide et doit contenir une chaine de caractères")
    private String name;
    @NotBlank(message = "Description ne doit pas etre vide et doit contenir une chaine de caractères")
    private String description;
    @NotBlank(message = "Json ne doit pas etre vide et doit contenir une chaine de caractères")
    private String json;
    @NotBlank(message = "Template ne doit pas etre vide et doit contenir une chaine de caractères")
    private String template;
    @NotBlank(message = "SqlStr ne doit pas etre vide et doit contenir une chaine de caractères")
    private String sqlStr;
    @NotBlank(message = "SqlPart ne doit pas etre vide et doit contenir une chaine de caractères")
    private String sqlPart;

    public RuleName() {
    }

    public RuleName(String name, String description, String json, String template, String sqlStr, String sqlPart) {
        this.name = name;
        this.description = description;
        this.json = json;
        this.template = template;
        this.sqlStr = sqlStr;
        this.sqlPart = sqlPart;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getSqlStr() {
        return sqlStr;
    }

    public void setSqlStr(String sqlStr) {
        this.sqlStr = sqlStr;
    }

    public String getSqlPart() {
        return sqlPart;
    }

    public void setSqlPart(String sqlPart) {
        this.sqlPart = sqlPart;
    }
}

package com.nnk.springboot.domain;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "rating")
public class Rating {
    @Id
    @GeneratedValue
    private int id;
    @NotBlank(message = "MoodysRating ne doit pas etre vide et doit contenir une chaine de caractères")
    private String moodysRating;
    @NotBlank(message = "SandPRating ne doit pas etre vide et doit contenir une chaine de caractères")
    private String sandPRating;
    @NotBlank(message = "FitchRating ne doit pas etre vide et doit contenir une chaine de caractères")
    private String fitchRating;
    @Min(message = "OrderNumber ne doit pas etre vide et doit contenir un nombre", value = 1 )
    private int orderNumber;

    public Rating() {
    }

    public Rating(String moodysRating, String sandPRating, String fitchRating, int orderNumber) {
        this.moodysRating = moodysRating;
        this.sandPRating = sandPRating;
        this.fitchRating = fitchRating;
        this.orderNumber = orderNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMoodysRating() {
        return moodysRating;
    }

    public void setMoodysRating(String moodysRating) {
        this.moodysRating = moodysRating;
    }

    public String getSandPRating() {
        return sandPRating;
    }

    public void setSandPRating(String sandPRating) {
        this.sandPRating = sandPRating;
    }

    public String getFitchRating() {
        return fitchRating;
    }

    public void setFitchRating(String fitchRating) {
        this.fitchRating = fitchRating;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

}

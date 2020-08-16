package com.nnk.springboot.manager.rating;

import com.nnk.springboot.domain.Rating;

import java.util.List;

public interface RatingManager {
    Rating save(Rating rating);
    Rating find(int id);
    List<Rating> list();
    void delete(int id);
}

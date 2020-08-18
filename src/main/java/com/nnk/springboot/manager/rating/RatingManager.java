package com.nnk.springboot.manager.rating;

import com.nnk.springboot.domain.Rating;

import java.util.List;

/**
 * RatingManager actions manager
 */
public interface RatingManager {
    /**
     * save the rating and return instance save
     * @param rating
     * @return
     */
    Rating save(Rating rating);
    /**
     * return rating from id
     * @param id
     * @return
     */
    Rating find(int id);
    /**
     * return list rating
     * @return
     */
    List<Rating> list();
    /**
     * delete rating from id
     * @param id
     * @return
     */
    void delete(int id);
}

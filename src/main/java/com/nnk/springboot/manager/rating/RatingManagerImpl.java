package com.nnk.springboot.manager.rating;

import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RatingManagerImpl implements RatingManager {
    @Autowired
    RatingRepository ratingRepository;
    @Override
    public Rating save(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public Rating find(int id) {
        return ratingRepository.findById(id);
    }

    @Override
    public List<Rating> list() {
        return ratingRepository.findAll();
    }

    @Override
    public void delete(int id) {
        ratingRepository.delete(find(id));
    }
}

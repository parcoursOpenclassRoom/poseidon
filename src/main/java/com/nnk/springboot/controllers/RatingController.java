package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.manager.rating.RatingManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class RatingController {
    @Autowired
    RatingManager ratingManager;

    @RequestMapping("/rating/list")
    public String home(Model model)
    {
        model.addAttribute("list", ratingManager.list());
        return "rating/list";
    }

    @GetMapping("/rating/add")
    public String addRatingForm(Rating rating) {
        return "rating/add";
    }

    @PostMapping("/rating/validate")
    public String validate(@Valid Rating rating, BindingResult result, Model model) {
        //check model validation
        if(!result.hasErrors()){
            ratingManager.save(rating);
            return "redirect:/rating/list";
        }
        return "rating/add";
    }

    @GetMapping("/rating/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        //check that an id exists
        Rating rating = ratingManager.find(id);
        if(rating == null)
            new IllegalArgumentException("Invalid rating Id:" + id);
        model.addAttribute("rating", rating);
        return "rating/update";
    }

    @PostMapping("/rating/update/{id}")
    public String updateRating(@PathVariable("id") Integer id, @Valid Rating rating,
                             BindingResult result, Model model) {
        if(!result.hasErrors()){
            rating.setId(id);
            ratingManager.save(rating);
            return "redirect:/rating/list";
        }
        return "rating/update";
    }

    @GetMapping("/rating/delete/{id}")
    public String deleteRating(@PathVariable("id") Integer id, Model model) {
        Rating rating = ratingManager.find(id);
        if(rating == null)
            new IllegalArgumentException("Invalid bid Id:" + id);
        ratingManager.delete(id);
        return "redirect:/rating/list";
    }
}

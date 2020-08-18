package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.manager.bid.BidManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
public class BidListController {
    @Autowired
    BidManager bidManager;

    @RequestMapping("/bidList/list")
    public String home(Model model)
    {
        model.addAttribute("list", bidManager.list());
        return "bidList/list";
    }

    @GetMapping("/bidList/add")
    public String addBidForm(@ModelAttribute BidList bid) {
        return "bidList/add";
    }

    @PostMapping("/bidList/validate")
    public String validate(@Valid BidList bid, BindingResult result, Model model) {
        //check model validation
        if(!result.hasErrors()){
            bidManager.save(bid);
            return "redirect:/bidList/list";
        }
        return "bidList/add";
    }

    @GetMapping("/bidList/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        //check that an id exists
        BidList bid = bidManager.find(id);
        if(bid == null)
            new IllegalArgumentException("Invalid bid Id:" + id);
        model.addAttribute("bidList", bid);
        return "bidList/update";
    }

    @PostMapping("/bidList/update/{id}")
    public String updateBid(@PathVariable("id") Integer id, @Valid BidList bidList,
                             BindingResult result, Model model) {
        if(!result.hasErrors()){
            bidList.setId(id);
            bidManager.save(bidList);
            return "redirect:/bidList/list";
        }
        return "bidList/update";
    }

    @GetMapping("/bidList/delete/{id}")
    public String deleteBid(@PathVariable("id") Integer id, Model model) {
        BidList bid = bidManager.find(id);
        if(bid == null)
            new IllegalArgumentException("Invalid bid Id:" + id);
        bidManager.delete(id);
        return "redirect:/bidList/list";
    }
}

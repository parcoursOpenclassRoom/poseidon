package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.manager.trade.TradeManager;
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
public class TradeController {
    @Autowired
    TradeManager tradeManager;

    @RequestMapping("/trade/list")
    public String home(Model model)
    {
        model.addAttribute("list", tradeManager.list());
        return "trade/list";
    }

    @GetMapping("/trade/add")
    public String addTrade(Trade bid) {
        return "trade/add";
    }

    @PostMapping("/trade/validate")
    public String validate(@Valid Trade trade, BindingResult result, Model model) {
        //check model validation
        if(!result.hasErrors()){
            tradeManager.save(trade);
            return "redirect:/trade/list";
        }
        return "trade/add";
    }

    @GetMapping("/trade/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        //check that an id exists
        Trade trade = tradeManager.find(id);
        if(trade == null)
            new IllegalArgumentException("Invalid trade Id:" + id);
        model.addAttribute("trade", trade);
        return "trade/update";
    }

    @PostMapping("/trade/update/{id}")
    public String updateTrade(@PathVariable("id") Integer id, @Valid Trade trade,
                             BindingResult result, Model model) {
        if(!result.hasErrors()){
            trade.setId(id);
            tradeManager.save(trade);
            return "redirect:/trade/list";
        }
        return "redirect:/trade/list";
    }

    @GetMapping("/trade/delete/{id}")
    public String deleteTrade(@PathVariable("id") Integer id, Model model) {
        Trade trade = tradeManager.find(id);
        if(trade == null)
            new IllegalArgumentException("Invalid trade Id:" + id);
        tradeManager.delete(id);
        return "redirect:/trade/list";
    }
}

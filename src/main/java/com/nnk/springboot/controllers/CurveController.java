package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.manager.curve.CurveManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class CurveController {
    @Autowired
    CurveManager curveManager;

    @RequestMapping("/curvePoint/list")
    public String home(Model model)
    {
        model.addAttribute("list", curveManager.list());
        return "curvePoint/list";
    }

    @GetMapping("/curvePoint/add")
    public String addBidForm(CurvePoint bid) {
        return "curvePoint/add";
    }

    @PostMapping("/curvePoint/validate")
    public String validate(@Valid CurvePoint curvePoint, BindingResult result, Model model) {
        //check model validation
        if(!result.hasErrors()){
            curveManager.save(curvePoint);
            return "redirect:/curvePoint/list";
        }
        return "curvePoint/add";
    }

    @GetMapping("/curvePoint/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        //check that an id exists
        CurvePoint curvePoint = curveManager.find(id);
        if(curvePoint == null)
            new IllegalArgumentException("Invalid curvePoint Id:" + id);
        model.addAttribute("curvePoint", curvePoint);

        return "curvePoint/update";
    }

    @PostMapping("/curvePoint/update/{id}")
    public String updateBid(@PathVariable("id") Integer id, @Valid CurvePoint curvePoint,
                            BindingResult result, Model model) {
        if(!result.hasErrors()){
            curvePoint.setId(id);
            curveManager.save(curvePoint);
            return "redirect:/curvePoint/list";
        }
        return "curvePoint/update";
    }

    @GetMapping("/curvePoint/delete/{id}")
    public String deleteBid(@PathVariable("id") Integer id, Model model) {
        CurvePoint curvePoint = curveManager.find(id);
        if(curvePoint == null)
            new IllegalArgumentException("Invalid bid Id:" + id);
        curveManager.delete(id);
        return "redirect:/curvePoint/list";
    }
}

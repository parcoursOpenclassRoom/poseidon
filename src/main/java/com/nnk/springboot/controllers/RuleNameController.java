package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.manager.ruleName.RuleNameManager;
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
public class RuleNameController {
    @Autowired
    RuleNameManager ruleNameManager;

    @RequestMapping("/ruleName/list")
    public String home(Model model)
    {
        model.addAttribute("list", ruleNameManager.list());
        return "ruleName/list";
    }

    @GetMapping("/ruleName/add")
    public String addRuleForm(RuleName bid) {
        return "ruleName/add";
    }

    @PostMapping("/ruleName/validate")
    public String validate(@Valid RuleName ruleName, BindingResult result, Model model) {
        //check model validation
        if(!result.hasErrors()){
            ruleNameManager.save(ruleName);
            return "redirect:/ruleName/list";
        }
        return "ruleName/add";
    }

    @GetMapping("/ruleName/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        //check that an id exists
        RuleName ruleName = ruleNameManager.find(id);
        if(ruleName == null)
            new IllegalArgumentException("Invalid rating Id:" + id);
        model.addAttribute("ruleName", ruleName);
        return "ruleName/update";
    }

    @PostMapping("/ruleName/update/{id}")
    public String updateRuleName(@PathVariable("id") Integer id, @Valid RuleName ruleName,
                             BindingResult result, Model model) {
        if(!result.hasErrors()){
            ruleName.setId(id);
            ruleNameManager.save(ruleName);
            return "redirect:/ruleName/list";
        }
        return "ruleName/update";
    }

    @GetMapping("/ruleName/delete/{id}")
    public String deleteRuleName(@PathVariable("id") Integer id, Model model) {
        RuleName ruleName = ruleNameManager.find(id);
        if(ruleName == null)
            new IllegalArgumentException("Invalid bid Id:" + id);
        ruleNameManager.delete(id);
        return "redirect:/ruleName/list";
    }
}

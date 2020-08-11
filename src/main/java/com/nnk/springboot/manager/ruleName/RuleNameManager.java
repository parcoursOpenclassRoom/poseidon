package com.nnk.springboot.manager.ruleName;

import com.nnk.springboot.domain.RuleName;

import java.util.List;

public interface RuleNameManager {
    RuleName save(RuleName ruleName);
    RuleName find(int id);
    List<RuleName> list();
    void delete(int id);
}

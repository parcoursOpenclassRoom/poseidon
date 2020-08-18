package com.nnk.springboot.manager.ruleName;

import com.nnk.springboot.domain.RuleName;

import java.util.List;
/**
 * RuleNameManager actions manager
 */
public interface RuleNameManager {
    /**
     * save the ruleName and return instance save
     * @param ruleName
     * @return
     */
    RuleName save(RuleName ruleName);
    /**
     * return ruleName from id
     * @param id
     * @return
     */
    RuleName find(int id);
    /**
     * return list ruleName
     * @return
     */
    List<RuleName> list();
    /**
     * delete ruleName from id
     * @param id
     * @return
     */
    void delete(int id);
}

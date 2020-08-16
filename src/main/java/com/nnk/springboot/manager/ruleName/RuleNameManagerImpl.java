package com.nnk.springboot.manager.ruleName;

import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.repositories.RuleNameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RuleNameManagerImpl implements RuleNameManager {
    @Autowired
    RuleNameRepository ruleNameRepository;
    @Override
    public RuleName save(RuleName ruleName) {
        return ruleNameRepository.save(ruleName);
    }

    @Override
    public RuleName find(int id) {
        return ruleNameRepository.findById(id);
    }

    @Override
    public List<RuleName> list() {
        return ruleNameRepository.findAll();
    }

    @Override
    public void delete(int id) {
        ruleNameRepository.delete(find(id));
    }
}

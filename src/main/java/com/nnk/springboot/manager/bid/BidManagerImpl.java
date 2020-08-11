package com.nnk.springboot.manager.bid;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.repositories.BidListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BidManagerImpl implements BidManager {
    @Autowired
    BidListRepository bidListRepository;

    @Override
    public BidList save(BidList bidList) {
        return bidListRepository.save(bidList);
    }

    @Override
    public BidList find(int id) {
        return bidListRepository.findById(id);
    }

    @Override
    public List<BidList> list() {
        return bidListRepository.findAll();
    }

    @Override
    public void delete(int id) {
        bidListRepository.delete(find(id));
    }
}

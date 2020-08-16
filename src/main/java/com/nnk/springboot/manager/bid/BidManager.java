package com.nnk.springboot.manager.bid;

import com.nnk.springboot.domain.BidList;

import java.util.List;

public interface BidManager {
    BidList save(BidList bidList);
    BidList find(int id);
    List<BidList> list();
    void delete(int id);
}

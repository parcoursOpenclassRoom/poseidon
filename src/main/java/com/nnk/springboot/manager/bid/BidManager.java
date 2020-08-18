package com.nnk.springboot.manager.bid;

import com.nnk.springboot.domain.BidList;

import java.util.List;

/**
 * BidManager actions manager
 */
public interface BidManager {

    /**
     * save the BidList and return instance save
     * @param bidList
     * @return
     */
    BidList save(BidList bidList);

    /**
     * return BidList from id
     * @param id
     * @return
     */
    BidList find(int id);

    /**
     * return list BidList
     * @return
     */
    List<BidList> list();

    /**
     * delete BidList from id
     * @param id
     * @return
     */
    void delete(int id);
}

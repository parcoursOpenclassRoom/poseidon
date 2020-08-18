package com.nnk.springboot.manager.trade;


import com.nnk.springboot.domain.Trade;

import java.util.List;
/**
 * TradeManager actions manager
 */
public interface TradeManager {
    /**
     * save the trade and return instance save
     * @param trade
     * @return
     */
    Trade save(Trade trade);
    /**
     * return trade from id
     * @param id
     * @return
     */
    Trade find(int id);
    /**
     * return list trade
     * @return
     */
    List<Trade> list();
    /**
     * delete trade from id
     * @param id
     * @return
     */
    void delete(int id);
}

package com.nnk.springboot.manager.trade;


import com.nnk.springboot.domain.Trade;

import java.util.List;

public interface TradeManager {
    Trade save(Trade trade);
    Trade find(int id);
    List<Trade> list();
    void delete(int id);
}

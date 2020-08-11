package com.nnk.springboot.manager.trade;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.repositories.TradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TradeManagerImpl implements TradeManager {
    @Autowired
    TradeRepository tradeRepository;
    @Override
    public Trade save(Trade trade) {
        return tradeRepository.save(trade);
    }

    @Override
    public Trade find(int id) {
        return tradeRepository.findById(id);
    }

    @Override
    public List<Trade> list() {
        return tradeRepository.findAll();
    }

    @Override
    public void delete(int id) {
        tradeRepository.delete(find(id));
    }
}

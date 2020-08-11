package com.nnk.springboot.manager.curve;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.repositories.CurvePointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CurveManagerImpl implements CurveManager {
    @Autowired
    CurvePointRepository curvePointRepository;
    @Override
    public CurvePoint save(CurvePoint curvePoint) {
        return curvePointRepository.save(curvePoint);
    }

    @Override
    public CurvePoint find(int id) {
        return curvePointRepository.findById(id);
    }

    @Override
    public List<CurvePoint> list() {
        return curvePointRepository.findAll();
    }

    @Override
    public void delete(int id) {
        curvePointRepository.delete(find(id));
    }
}

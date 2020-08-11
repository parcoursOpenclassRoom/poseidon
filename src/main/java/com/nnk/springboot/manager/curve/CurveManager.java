package com.nnk.springboot.manager.curve;

import com.nnk.springboot.domain.CurvePoint;

import java.util.List;

public interface CurveManager {
    CurvePoint save(CurvePoint curvePoint);
    CurvePoint find(int id);
    List<CurvePoint> list();
    void delete(int id);
}

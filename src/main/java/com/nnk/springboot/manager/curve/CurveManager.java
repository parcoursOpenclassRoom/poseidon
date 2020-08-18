package com.nnk.springboot.manager.curve;

import com.nnk.springboot.domain.CurvePoint;

import java.util.List;
/**
 * CurveManager actions manager
 */
public interface CurveManager {
    /**
     * save the curvePoint and return instance save
     * @param curvePoint
     * @return
     */
    CurvePoint save(CurvePoint curvePoint);
    /**
     * return curvePoint from id
     * @param id
     * @return
     */
    CurvePoint find(int id);
    /**
     * return list CurvePoint
     * @return
     */
    List<CurvePoint> list();
    /**
     * delete curvePoint from id
     * @param id
     * @return
     */
    void delete(int id);
}

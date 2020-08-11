package com.nnk.springboot;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.manager.curve.CurveManager;
import com.nnk.springboot.repositories.CurvePointRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CurvePointTests {

	@Autowired
	private CurveManager curveManager;

	@Test
	public void curvePointTest() {
		CurvePoint curvePoint = new CurvePoint(10, 10d, 30d);

		// Save
		curvePoint = curveManager.save(curvePoint);
		Assert.assertNotNull(curvePoint.getId());
		Assert.assertTrue(curvePoint.getCurveId() == 10);

		// Update
		curvePoint.setCurveId(20);
		curvePoint = curveManager.save(curvePoint);
		Assert.assertTrue(curvePoint.getCurveId() == 20);

		// Find
		List<CurvePoint> listResult = curveManager.list();
		Assert.assertTrue(listResult.size() > 0);

		// Delete
		Integer id = curvePoint.getId();
		curveManager.delete(id);
		CurvePoint curvePointList = curveManager.find(id);
		Assert.assertNotNull(curvePointList);
	}

}

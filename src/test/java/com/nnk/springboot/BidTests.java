package com.nnk.springboot;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.manager.bid.BidManager;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BidTests {

	@Autowired
	private BidManager bidManager;

	@Test
	public void bidListTest() {
		BidList bid = new BidList("Account Test", "Type Test", 10d);

		// Save
		bid = bidManager.save(bid);
		Assert.assertNotNull(bid.getId());
		Assert.assertEquals(bid.getBidQuantity(), 10d, 10d);

		// Update
		bid.setBidQuantity(20d);
		bid = bidManager.save(bid);
		Assert.assertEquals(bid.getBidQuantity(), 20d, 20d);

		// Find
		List<BidList> listResult = bidManager.list();
		Assert.assertTrue(listResult.size() > 0);

		// Delete
		Integer id = bid.getId();
		bidManager.delete(id);
		BidList bidList = bidManager.find(id);
		Assert.assertNotNull(bidList);
	}
}

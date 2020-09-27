package com.atguigu.book.service.impl;

import com.atguigu.book.service.BookService;
import com.atguigu.book.service.Cashier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CashierServiceImpl implements Cashier {

	@Autowired
	private BookService service;
	
	@Override
	public void checkOut(String uid, List<String> bids) {
		for (String bid : bids) {
			service.buyBook(bid, uid);
		}
	}

}

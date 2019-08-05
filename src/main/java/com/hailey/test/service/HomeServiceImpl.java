package com.hailey.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hailey.test.dao.HomeDao;
import com.hailey.test.hibvo.HomeHibVo;
import com.hailey.test.mybat.HomemyBatvo;
import com.hailey.test.vo.HomeVo;

@Service("homeService")

public class HomeServiceImpl implements HomeService {

	@Autowired
	HomeDao homeDao;
	
	@Override
	@Transactional("jdbc")
	public HomeVo login(String userId, String pwd) {
		return homeDao.login(userId,pwd);
	}

	@Override
	@Transactional("hib")
	public HomeHibVo loginWithHib(String userId, String pwd) {
		return homeDao.loginWithHib(userId, pwd);
	}

	@Override
	public HomemyBatvo loginWithmyB(String userId, String pwd) {
		return homeDao.loginWithmyB(userId, pwd);
	}

}

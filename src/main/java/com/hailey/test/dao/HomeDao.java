package com.hailey.test.dao;

import com.hailey.test.hibvo.HomeHibVo;
import com.hailey.test.mybat.HomemyBatvo;
import com.hailey.test.vo.HomeVo;

public interface HomeDao {

	HomeVo login(String userId, String pwd);

	HomeHibVo loginWithHib(String userId, String pwd);

	HomemyBatvo loginWithmyB(String userId, String pwd);

}

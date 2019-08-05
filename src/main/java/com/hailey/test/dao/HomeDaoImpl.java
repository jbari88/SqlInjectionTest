package com.hailey.test.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hailey.test.hibvo.HomeHibVo;
import com.hailey.test.mybat.HomemyBatvo;
import com.hailey.test.mybat.MybatMapper;
import com.hailey.test.vo.HomeVo;

@Repository("homeDao")

public class HomeDaoImpl implements HomeDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	SqlSessionTemplate sqlSession;

	@Override
	@Transactional("jdbc")
	public HomeVo login(String userId, String pwd) {

		/* Unsafe Code */

		HomeVo result = jdbcTemplate.queryForObject(
				"select * from member where id='" + userId + "' and passwd='" + pwd + "'", new RowMapper<HomeVo>() {
					public HomeVo mapRow(ResultSet rs, int rowNum) throws SQLException {
						if (rs != null) {
							HomeVo actor = new HomeVo();
							actor.setId(rs.getString("id"));
							actor.setName(rs.getString("name"));
							return actor;
						} else
							return null;
					}

				});

		/* Safe Code - PlaceHolder */

		/*
		 * HomeVo result =
		 * jdbcTemplate.queryForObject("select * from member where id=? and passwd = ?",
		 * new Object[] { userId, pwd }, new RowMapper<HomeVo>() { public HomeVo
		 * mapRow(ResultSet rs, int rowNum) throws SQLException { if (rs != null) {
		 * HomeVo actor = new HomeVo(); actor.setId(rs.getString("id"));
		 * actor.setName(rs.getString("name")); return actor; } else return null;
		 * 
		 * } });
		 * 
		 * Safe Code - namedParameter SqlParameterSource namedParameters = new
		 * MapSqlParameterSource("id", userId).addValue("passwd", pwd);
		 * 
		 * HomeVo result = namedParameterJdbcTemplate.queryForObject(
		 * "select * from member where id=:id and passwd=:passwd", namedParameters, new
		 * RowMapper<HomeVo>() { public HomeVo mapRow(ResultSet rs, int rowNum) throws
		 * SQLException {
		 * 
		 * if (rs != null) { HomeVo actor = new HomeVo();
		 * actor.setId(rs.getString("id")); actor.setName(rs.getString("name")); return
		 * actor; } else return null;
		 * 
		 * } });
		 */

		return result;
	}

	@Override
	@Transactional("hib")
	public HomeHibVo loginWithHib(String userId, String pwd) {
		Session session = sessionFactory.openSession();

		/* Unsafe Code */

		String hql = "from HomeHibVo where id='" + userId + "' and passwd='" + pwd + "'";
		Query query = session.createQuery(hql);

		/* Safe Code - namedParameter */

		/*
		 * String hql = "from HomeHibVo where id= :userId" + " and passwd=:passwd";
		 * Query query = session.createQuery(hql); query.setParameter("userId", userId);
		 * query.setParameter("passwd", pwd);
		 * 
		 * Safe Code - PlaceHolder String hql = "from HomeHibVo where id=?0" +
		 * " and passwd=?1"; // JDBC-style '?' is deprecated in Hibernate Query query =
		 * session.createQuery(hql); query.setParameter(0, userId);
		 * query.setParameter(1, pwd); // query.setString() is deprecated since
		 * Hibernate 5.2
		 */
		HomeHibVo result = new HomeHibVo();
		if (query.getResultList().size() > 0) {
			result = (HomeHibVo) query.getResultList().get(0);
		} else {
			result = null;
		}

		return result;
	}

	@Override
	public HomemyBatvo loginWithmyB(String userId, String pwd) {
		MybatMapper my = sqlSession.getMapper(MybatMapper.class);
		HomemyBatvo batvo = new HomemyBatvo();
		batvo.setId(userId);
		batvo.setPasswd(pwd);
		HomemyBatvo result = my.selectHome(batvo);
		return result;

	}

}

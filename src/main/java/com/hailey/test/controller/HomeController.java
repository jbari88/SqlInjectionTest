package com.hailey.test.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hailey.test.hibvo.HomeHibVo;
import com.hailey.test.mybat.HomemyBatvo;
import com.hailey.test.service.HomeService;
import com.hailey.test.vo.HomeVo;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@Autowired
	HomeService homeService;
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(HttpServletRequest req, HttpServletResponse res, Model model) {
	
		//logger.info();
		return new ModelAndView("home");
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	
	public @ResponseBody HashMap<String, Object> login(Model model, HttpServletRequest req){
		
		String userId = req.getParameter("userid");
		String pwd = req.getParameter("passwd");
		
		
		
		HomeVo vo = homeService.login(userId, pwd);
		
		HashMap<String, Object> result = new HashMap<String, Object>();
		if(vo !=null) {
			result.put("name", vo.getName());
			result.put("success",1);
		}else {
			result.put("success",0);
		}
		return result;
	}
	
	
	@RequestMapping(value="/loginWithHib", method=RequestMethod.GET)
	public @ResponseBody HashMap<String, Object> loginWithHib(Model model, HttpServletRequest req){
		
		String userId = req.getParameter("userid");
		String pwd = req.getParameter("passwd");
		
		HomeHibVo vo = homeService.loginWithHib(userId, pwd);
		
		HashMap<String, Object> result = new HashMap<String, Object>();
		if(vo !=null) {
			result.put("name", vo.getName());
			result.put("success",1);
		}else {
			result.put("success",0);
		}
		return result;
	}
	
	@RequestMapping(value="/loginWithmyB", method=RequestMethod.GET, headers="Accept=application/json")
	public @ResponseBody HashMap<String, Object> loginWithmyB(Model model, HttpServletRequest req){
		
		String userId = req.getParameter("userid");
		String pwd = req.getParameter("passwd");
		
		HomemyBatvo vo = homeService.loginWithmyB(userId, pwd);
		
		HashMap<String, Object> result = new HashMap<String, Object>();
		if(vo !=null) {
			result.put("name", vo.getName());
			result.put("success",1);
		}else {
			result.put("success",0);
		}
		return result;
	}
	
	
}

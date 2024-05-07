package net.daum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

import net.daum.service.ShopService;

@Controller
public class ShopController {
	
	@Autowired
	private ShopService shopService;
	
	/* 메인 */
	@GetMapping("/main_shop")
	public ModelAndView main_shop(HttpServletRequest request) {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/index");
		
		return mv;
	}// main()
	
	/* 상의 */
	@GetMapping("/top")
	public ModelAndView top(HttpServletRequest request) {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/cart/top");
		
		return mv;
	}// top()
	
}

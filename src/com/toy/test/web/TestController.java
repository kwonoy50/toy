package com.toy.test.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.toy.test.service.TestService;


@Controller
public class TestController {
	
	@Autowired
	private TestService testService;
	

    @RequestMapping(value = {"/", "/index"})
    public String index() {
        return "index";
    }


    @RequestMapping("/test")
    public ModelAndView test(@RequestParam Map<String, String> param) {
    	ModelAndView mav = new ModelAndView("test/test");
    	
    	mav.addObject("userList", testService.getMessageList());
    	
        return mav;
    }

}

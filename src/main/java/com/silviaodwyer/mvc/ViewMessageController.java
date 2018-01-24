package com.silviaodwyer.mvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.silviaodwyer.mvc.GenericViewMessageService;
import com.silviaodwyer.mvc.viewMessageService;


@Controller 
public class ViewMessageController {
	@Autowired
	private GenericViewMessageService genericViewMessageService;
	
	@RequestMapping("/")
	// http://localhost:8680/spring-mvc-demo-1
	// Any requests to the above URL will be processed via this method
	public String doWelcome(Model model) {
		
		// 1. Retrieving the processed data
	//	com.silviaodwyer.service.demo.welcomeService welcomeService = new welcomeService();
		List<String> myMessage = genericViewMessageService.getMessage("Silvia O'Dwyer");
		
		// 2. Add data to the model
		model.addAttribute("myMessage", myMessage);
		
		// 3. Return logical view name
		return "yourMessage"; // /WEB-INF/views/welcomeNew.jsp
	}
}
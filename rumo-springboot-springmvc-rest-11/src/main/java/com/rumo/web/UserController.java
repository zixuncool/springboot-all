package com.rumo.web;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@RequestMapping(value="/saveUser",method=RequestMethod.POST)
	//@PostMapping(value="/saveUser")
	//@PostMapping("/saveUser")
	//@PostMapping(path="/saveUser")
	public String saveuser(Model model) {
		model.addAttribute("title","Hello Freemaker!!!!");
		return "index";
	}
	
	@RequestMapping(value="/updateuser",method=RequestMethod.POST)
	public String updateuser(Model model) {
		model.addAttribute("title","Hello Freemaker!!!!");
		return "index";
	}
	
	@RequestMapping(value="/deleteUser",method=RequestMethod.POST)
	public String deleteUser(Model model) {
		model.addAttribute("title","Hello Freemaker!!!!");
		return "index";
	}
	
	//@RequestMapping(value="/deleteUser",method=RequestMethod.GET)
	@GetMapping("/findUser")
	public String findUser(Model model) {
		model.addAttribute("title","Hello Freemaker!!!!");
		return "index";
	}
	
}

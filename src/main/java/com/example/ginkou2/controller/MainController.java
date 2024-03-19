package com.example.ginkou2.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.ginkou2.model.GakuseiHyou;
import com.example.ginkou2.service.GakuseiService;

import io.micrometer.common.lang.NonNull;
 
@Controller
public class MainController {
	@Autowired
	private GakuseiService gakuseiService;
@GetMapping("/")
public String index(Model model) {
	model.addAttribute("message", "こんにちは");
	return "top";
	}

 
@GetMapping("/touroku/")
public ModelAndView add(GakuseiHyou gakuseihyou, ModelAndView model)  {
	model.addObject("gakuseihyou", gakuseihyou);
	model.setViewName("touroku");
	return model;
	}
 
@PostMapping("/gakuseihyou/")
public String gakuseihyou(@Validated @ModelAttribute @NonNull GakuseiHyou gakuseihyou, RedirectAttributes result, ModelAndView model,
		RedirectAttributes redirectAttributes) {
	try {
		this.gakuseiService.save(gakuseihyou);
		redirectAttributes.addFlashAttribute("exception", "");
		
	} catch (Exception e) {
		
		redirectAttributes.addFlashAttribute("exception", e.getMessage());
	}
	return "redirect:/";
	}
}
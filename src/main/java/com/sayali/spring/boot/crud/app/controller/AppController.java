package com.sayali.spring.boot.crud.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sayali.spring.boot.crud.app.entity.Product;
import com.sayali.spring.boot.crud.app.service.ProductService;

@Controller
public class AppController {

	@Autowired
	ProductService service;

	@RequestMapping("/")
	public String viewHomePage(ModelMap model) {
		List<Product> listProducts = service.findAllList();
		model.addAttribute("listProducts", listProducts);

		return "index";

	}

	@RequestMapping("/new")
	public String addNewProduct(ModelMap model) {
		Product p = new Product();
		model.addAttribute("product", p);
		return "new_product";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveNewProduct(@ModelAttribute("product") Product product) {
		service.save(product);
		return "redirect:/";
	}

	@RequestMapping("/edit/{id}")
	public ModelAndView editProduct(@PathVariable("id") long id) {
		ModelAndView model = new ModelAndView("edit_product");
		Optional<Product> p = service.getProduct(id);
		model.addObject("product", p);
		return model;
	}

	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable("id") long id) {
		service.delete(id);
		return "redirect:/";
	}

}

package com.sip.ams.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sip.ams.entities.Etudiant;

import java.util.*;
@RequestMapping("/etudiant")
@Controller
public class EtudiantController {
	
	List<Etudiant> etudiants = new ArrayList<>();
	
	{
		
		etudiants.add(new Etudiant(1, "amine", "amine@gmail.com"));
		etudiants.add(new Etudiant(2, "rami", "rami@gmail.com"));
		etudiants.add(new Etudiant(3, "patrick", "patrick@gmail.com"));
	}
	
	@RequestMapping("/home")
	public String message(Model model) {
		System.out.println("bienvue bootcomp");
		String formation ="fullstack 100% Spring boot";
		String lieu = "sessame";
		model.addAttribute("trannig",formation);
		model.addAttribute("location",lieu);
		return "info";
	}
	
	@RequestMapping("/product")
	//public String listProduct(Model model) {
	public ModelAndView listProduct(/*Model model*/) {
		ModelAndView mv = new ModelAndView();
		List<String> products = new ArrayList<>();
		products.add("Voiture");
		products.add("Camion");
		products.add("Moto");
		products.add("Bus");
		products.add("bykeS");
		//model.addAttribute("products",products);
		mv.addObject("products",products);
		mv.setViewName("product");
	//	return "product";
		return mv;
	}

	@RequestMapping("/students")
	//public String listProduct(Model model) {
	public ModelAndView listStudents(/*Model model*/) {
		ModelAndView mv = new ModelAndView();
		/*List<Etudiant> etudiants = new ArrayList<>();
		etudiants.add(new Etudiant(1,"ali","ali@gmail.com"));
		etudiants.add(new Etudiant(2,"salah","salah@gmail.com"));
		etudiants.add(new Etudiant(3,"mohamed","mohamed@gmail.com"));*/
		//model.addAttribute("products",products);
		mv.addObject("students",etudiants);
		mv.setViewName("listStudents");
	//	return "product";
		return mv;
	}
	
	// @GetMapping("/add")
		@RequestMapping(value = "/add", method = RequestMethod.GET)
		public ModelAndView addStudentForm() {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("addStudent");
			return mv;

		}

		@RequestMapping(value = "/add", method = RequestMethod.POST)
		public String addStudent(@RequestParam("id") int id, @RequestParam("nomEtudiant") String nom,
				@RequestParam("email") String email) {
			// ModelAndView mv = new ModelAndView();
			// mv.setViewName("listStudents");
			// return mv;
			Etudiant e = new Etudiant(id, nom, email);
			etudiants.add(e);
			return "redirect:students";

		}
		
		@GetMapping("/delete/{ide}")
		public String suppression(@PathVariable("ide")int id) {
			Etudiant e = new Etudiant();
			System.out.println("id = "+id);
			e =recherche(etudiants,id);
			etudiants.remove(e);
			return "redirect:../students";
		}
		
		private Etudiant recherche (List<Etudiant>le,int index) {
			Etudiant temp = null;
			for(Etudiant e : le) {
				if (e.getId() == index)
					temp = e;
				return e;

			}		
			return temp;
			
		}


}

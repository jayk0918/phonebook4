package com.javaex.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.PhoneService;
import com.javaex.vo.PersonVo;

@Controller
public class PhoneController {

	@Autowired
	private PhoneService phoneService;
	
	@RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST })
	public String List(Model model) {
		System.out.println("PhoneController > list()");
		List<PersonVo> pList = phoneService.getPersonList();
		model.addAttribute("pList", pList);
		return "list";
	}
	
	@RequestMapping(value = "/writeForm", method = {RequestMethod.GET, RequestMethod.POST })
	public String writeForm() {
		return "writeForm";
	}
	
	@RequestMapping(value = "/write", method = {RequestMethod.GET, RequestMethod.POST })
	public String write(@ModelAttribute PersonVo personVo) {
		System.out.println("PhoneBookController > write");
		phoneService.personInsert(personVo);
		return "redirect:/list";
	}
	
	@RequestMapping(value = "/write2", method = {RequestMethod.GET, RequestMethod.POST })
	public String write2(@ModelAttribute PersonVo personVo) {
		System.out.println("PhoneBookController > write");
		phoneService.personInsert2();
		return "redirect:/list";
	}
	
	@RequestMapping(value = "/delete/{personId},{name}", method = {RequestMethod.GET, RequestMethod.POST })
	public String delete(@PathVariable("personId") int personId, @PathVariable("name") String name) {
		phoneService.personDelete(personId);
		return "redirect:/list";
	}
	
	@RequestMapping(value = "/updateForm/{personId}", method = { RequestMethod.GET, RequestMethod.POST })
	public String updateForm(@PathVariable("personId") int personId, Model model) {

		PersonVo personVo = phoneService.getPerson(personId);
		model.addAttribute("personVo", personVo);
		return "updateForm";
	}
	
	@RequestMapping(value = "/updateForm2/{personId}", method = { RequestMethod.GET, RequestMethod.POST })
	public String updateForm2(@PathVariable("personId") int personId, Model model) {
		System.out.println("PhoneController > updateForm2");
		Map<String,Object> pMap = phoneService.getPerson2(personId);
		model.addAttribute("pMap", pMap);
		
		return "updateForm2";
	}
	
	@RequestMapping(value = "/update", method = { RequestMethod.GET, RequestMethod.POST })
	public String modify(@ModelAttribute PersonVo personVo) {
		
		System.out.println(personVo);

		int count = phoneService.personUpdate(personVo);
		System.out.println(count);

		return "redirect:/list";
	}
}

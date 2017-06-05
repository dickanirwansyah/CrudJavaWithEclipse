package com.dickanirwansyah.main.CrudJavaWithEclipse.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dickanirwansyah.main.CrudJavaWithEclipse.entities.Nasabah;
import com.dickanirwansyah.main.CrudJavaWithEclipse.services.NasabahServices;


@Controller
@RequestMapping(value="/data")
public class ControllerNasabah extends HttpServlet{

	@Autowired
	private NasabahServices nasabahServices;
	
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insert(Nasabah nasabah, HttpServletRequest request)
			throws ServletException, IOException{
		
		nasabah.setNama(request.getParameter("nama"));
		nasabah.setAlamat(request.getParameter("alamat"));
		nasabah.setNotelp(request.getParameter("notelp"));
		nasabahServices.save(nasabah);
		return "redirect:/data/index";
	}
	
	@RequestMapping(value="/cari", method=RequestMethod.GET)
	public String cariById(@RequestParam(value="idnasabah")int idnasabah, Model model){
		
		model.addAttribute("title", "Form Update");
		Nasabah nasabah=nasabahServices.findOne(idnasabah);
		model.addAttribute("getdata", nasabah);
		return "folder_html/form_update";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String delete(@RequestParam(value="idnasabah")int idnasabah, Nasabah nasabah)
	throws ServletException, IOException{
		
		nasabah=nasabahServices.findOne(idnasabah);
		nasabahServices.delete(nasabah);
		return "redirect:/data/index";
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public String formInsert(Model model)throws ServletException, IOException{
		
		model.addAttribute("title", "Form Insert");
		return "folder_html/form_insert";
	}
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String index(Model model){
		
		model.addAttribute("title", "Crud Nasabah");
	    model.addAttribute("listnasabah", nasabahServices.findAll());
		return "folder_html/nasabah";
	}
}

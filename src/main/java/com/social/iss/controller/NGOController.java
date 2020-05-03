package com.social.iss.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.social.iss.dataModel.Student;
import com.social.iss.viewModel.NGOViewModel;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/ngo")
@Api(value="Employee Management System", description="Operations pertaining to employee in Employee Management System")
public class NGOController {

	NGOViewModel ngoViewModel;

	public NGOController() {
		// TODO Auto-generated constructor stub
		this.ngoViewModel=new NGOViewModel();
	}
	@ApiOperation(value = "Returns List of all Ngo's")
	@GetMapping(value = "/getNGOS")
	public List<String> getNGOS() {

		return ngoViewModel.getListOfAllNGO();
	}


}
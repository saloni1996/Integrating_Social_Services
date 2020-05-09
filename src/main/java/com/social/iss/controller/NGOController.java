package com.social.iss.controller;


import com.social.iss.dataModel.NGO;
import com.social.iss.viewModel.NGOViewModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ngo")
@Api(value="Employee Management System", description="Operations pertaining to employee in Employee Management System")
public class NGOController {

	@Autowired
	NGOViewModel ngoViewModel;

	@ApiOperation(value = "Adds list of Ngo's")
	@PostMapping(value = "/addNGOS")
	public @ResponseBody String addNGOS(@RequestParam String name
			, @RequestParam String email) {
		return ngoViewModel.addListOfNGO(name, email);
	}

	@ApiOperation(value = "Returns List of all Ngo's")
	@GetMapping(value = "/getNGOS")
	public Iterable<NGO> getNGOS() {
		return ngoViewModel.getListOfAllNGO();
	}


}
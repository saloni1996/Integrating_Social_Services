package com.social.iss.viewModel;

import java.util.List;

import com.social.iss.databaseRepository.NGORepository;

public class NGOViewModel {
	
	NGORepository ngoRepository;
	public NGOViewModel()
	{
		this.ngoRepository=new NGORepository();
	}	
	
	public List<String> getListOfAllNGO()
	{
		return ngoRepository.getNGOs();
	}
}

package com.social.iss.viewModel;

import com.social.iss.dataModel.NGO;
import com.social.iss.databaseRepository.NGORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NGOViewModel {

	@Autowired
	NGORepository ngoRepository;

	public Iterable<NGO> getListOfAllNGO()
	{
		return ngoRepository.findAll();
	}

	public String addListOfNGO(String name, String email) {
		NGO ngo = new NGO();
		ngo.setName(name);
		ngo.setEmail(email);
		ngoRepository.save(ngo);
		return "Success";
	}
}

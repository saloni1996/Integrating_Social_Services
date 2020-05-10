package com.social.iss.viewModel;

import com.social.iss.dataModel.NGO;
import com.social.iss.databaseRepository.NGORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

	public List<NGO> getNgoByName(String ngoName) {
		List<NGO> listContainingMatchingName = new ArrayList<NGO>();
		ngoRepository.findAll().forEach((ngo) -> {
			if(ngo.getName().contains(ngoName)) {
				listContainingMatchingName.add(ngo);
			}
		});
		return listContainingMatchingName;
	}
}

package com.social.iss.viewModel;

import com.social.iss.dataModel.NGO;
import com.social.iss.databaseRepositories.NGORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class NGOViewModel {

	@Autowired
	NGORepository ngoRepository;

	public Iterable<NGO> getListOfAllNGO()
	{
		return ngoRepository.findAll();
	}

	public String addListOfNGO(String name, String email, String phoneNumber, String address, String description, String latitude, String longitude) {
		NGO ngo = new NGO();
		ngo.setName(name);
		ngo.setEmail(email);
		ngo.setPhoneNumber(phoneNumber);
		ngo.setAddress(address);
		ngo.setDescription(description);
		ngo.setLatitude(latitude);
		ngo.setLongitude(longitude);
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
	
	public String deleteNGO(Integer id)
	{
		ngoRepository.deleteById(id);
		return "Success";
	}
	
	public HashMap<NGO, Double> getNgoByDistance(String latitude,String longitude) {
		HashMap<NGO, Double> getNearestNgos = new HashMap<NGO, Double>(); 
		ngoRepository.findAll().forEach((ngo) -> {
			Double distance=getDistanceFromLatLonInKm(latitude,longitude,ngo.getLatitude(),ngo.getLongitude());
			
			getNearestNgos.put(ngo,distance);
			
		});
		
		return sortByValue(getNearestNgos);
	}
	
	Double getDistanceFromLatLonInKm(String lat1,String lon1,String lat2,String lon2) {
		  Double R = (double) 6371; // Radius of the earth in km
		  Double dLat = degreeToRadian((Double.parseDouble(lat2))-(Double.parseDouble(lat1)));  // deg2rad below
		  Double dLon = degreeToRadian((Double.parseDouble(lon2))-(Double.parseDouble(lon1)));  // deg2rad below
		  Double a = 
		    Math.sin(dLat/2) * Math.sin(dLat/2) +
		    Math.cos(degreeToRadian(Double.parseDouble(lat1))) * Math.cos(degreeToRadian(Double.parseDouble(lat2))) * 
		    Math.sin(dLon/2) * Math.sin(dLon/2)
		    ; 
		  Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a)); 
		  Double d = R * c; // Distance in km
		  return d;
		}

		Double degreeToRadian(Double degree) {
		  return degree * (Math.PI/180);
		}
		
		
		public static HashMap<NGO, Double> sortByValue(HashMap<NGO, Double> hm) 
	    { 
	        // Create a list from elements of HashMap 
	        List<Map.Entry<NGO, Double> > list = 
	               new LinkedList<Map.Entry<NGO, Double> >(hm.entrySet()); 
	  
	        // Sort the list 
	        Collections.sort(list, new Comparator<Map.Entry<NGO, Double> >() { 
	            public int compare(Map.Entry<NGO, Double> o1,  
	                               Map.Entry<NGO, Double> o2) 
	            { 
	                return (o1.getValue()).compareTo(o2.getValue()); 
	            } 
	        }); 
	          
	        // put data from sorted list to hashmap  
	        HashMap<NGO, Double> temp = new LinkedHashMap<NGO, Double>(); 
	        for (Map.Entry<NGO, Double> aa : list) { 
	            temp.put(aa.getKey(), aa.getValue()); 
	        } 
	        return temp; 
	    }

	  
}
	
	

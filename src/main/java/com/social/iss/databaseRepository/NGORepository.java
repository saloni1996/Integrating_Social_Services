package com.social.iss.databaseRepository;

import java.util.ArrayList;
import java.util.List;

public class NGORepository {

public NGORepository()
{
	
}

public List<String> getNGOs()
{
	List<String>ngosList=new ArrayList<>();
	ngosList.add("sarvahitey");
	ngosList.add("milaap");
	return ngosList;
}
}

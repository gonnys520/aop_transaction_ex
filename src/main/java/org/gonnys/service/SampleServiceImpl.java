package org.gonnys.service;

import org.gonnys.mapper.T1Mapper;
import org.gonnys.mapper.T2Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import lombok.Setter;

@Service
public class SampleServiceImpl implements SampleService {

	@Setter(onMethod_ = @Autowired)
	private T1Mapper t1Mapper;
	
	@Setter(onMethod_ = @Autowired)
	private T2Mapper t2Mapper;
	
	
	@Override
	public Integer doAdd(String str1, String str2) throws Exception {
	
		Thread.sleep(3000);
		
		return Integer.parseInt(str1) + Integer.parseInt(str2);
	}


	@Transactional
// (propagation=Propagation.NESTED)
	@Override
	public void addMulti(String str) {

		t1Mapper.insert(str);
		t2Mapper.insert(str);
		
	}




	
	
}

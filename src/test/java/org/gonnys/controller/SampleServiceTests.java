package org.gonnys.controller;

import org.gonnys.service.SampleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@Log4j
public class SampleServiceTests {

	@Setter(onMethod_ = @Autowired)
	private SampleService service;

	
	@Test
	public void testAdd()throws Exception{
		log.info(service.doAdd("123", "456"));
	}
	
	
	@Test
	public void testMulti() {
		String str = "긴글은안들어갈거에요알겠져?들어가기만해봐라가만안둬두개다들어가는건어떻게해야하나요?아근데t2에도들어가는데..";
		
		service.addMulti(str);
	}
}

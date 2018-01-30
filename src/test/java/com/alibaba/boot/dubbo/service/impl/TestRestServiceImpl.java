package com.alibaba.boot.dubbo.service.impl;

import org.springframework.stereotype.Component;

import com.alibaba.boot.dubbo.service.ITestRestService;
import com.alibaba.dubbo.config.annotation.Service;

@Service(interfaceClass = ITestRestService.class,protocol="rest")
@Component
public class TestRestServiceImpl implements ITestRestService {

	@Override
	public String getString(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTest() {
		// TODO Auto-generated method stub
		return "Holle,Howd1";
	}


}

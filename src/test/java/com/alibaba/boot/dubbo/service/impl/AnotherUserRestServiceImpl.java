package com.alibaba.boot.dubbo.service.impl;

import org.springframework.stereotype.Component;

import com.alibaba.boot.dubbo.service.AnotherUserRestService;
import com.alibaba.dubbo.config.annotation.Service;

@Service(interfaceClass = AnotherUserRestService.class,protocol="rest")
@Component
public class AnotherUserRestServiceImpl implements AnotherUserRestService {

	@Override
	public String getString(String name) {
		// TODO Auto-generated method stub
		return "Holle,Word    "+name;
	}

	@Override
	public String getTest() {
		// TODO Auto-generated method stub
		return "Holle,Word";
	}

}

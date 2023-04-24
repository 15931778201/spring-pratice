package cn.wusx.springboot.service.impl;

import org.springframework.stereotype.Service;

import cn.wusx.springboot.service.TestService;
@Service
public class TestServiceImpl implements TestService{

	@Override
	public void doTest() {
		int x = 1 / 0;
	}

}

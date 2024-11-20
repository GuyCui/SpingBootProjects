package com.leo.architecture.a_original.service.impl;

import com.leo.architecture.a_original.dao.DemoDao;
import com.leo.architecture.a_original.dao.impl.DemoDaoImpl;
import com.leo.architecture.a_original.service.DemoService;

import java.util.List;

public class DemoServiceImpl implements DemoService {
    
    private DemoDao demoDao = new DemoDaoImpl();
    @Override
    
    public List<String> findAll() {
        return demoDao.findAll();
    }
}

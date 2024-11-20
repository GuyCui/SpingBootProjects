package com.leo.architecture.a_original.dao.impl;

import com.leo.architecture.a_original.dao.DemoDao;

import java.util.Arrays;
import java.util.List;

public class DemoDaoImpl implements DemoDao {
    
    
    @Override
    public List<String> findAll() {
        return Arrays.asList("a", "b", "c");
    }
}

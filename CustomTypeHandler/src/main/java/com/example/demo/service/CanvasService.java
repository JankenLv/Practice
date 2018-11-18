package com.example.demo.service;

import com.example.demo.mapper.CanvasMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CanvasService {

    @Autowired
    private CanvasMapper canvasMapper;

    /**
     * 检验Mybatis结果集一条记录结果集映射到Boolean类型
     *
     * @param id
     * @return
     */
    public Boolean checkBooleanOfOneRow(Integer id) {
        return canvasMapper.checkBooleanOfOneRow(id);
    }

    /**
     * 检验Mybatis结果集多条记录结果集映射到Boolean类型
     *
     * @param id
     * @return
     */
    public Boolean checkBooleanOfMultiRow(String name) {
        return canvasMapper.checkBooleanOfMultiRow(name);
    }
}

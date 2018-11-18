package com.oc.boot.portal.service.impl;

import com.oc.boot.portal.bean.ConstsClassify;
import com.oc.boot.portal.dao.ConstsClassifyMapper;
import com.oc.boot.portal.dto.ConstsClassifyDto;
import com.oc.boot.portal.service.ConstsClassifyService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConstsClassifyServiceImpl implements ConstsClassifyService {

    @Autowired
    private ConstsClassifyMapper constsClassifyMapper;

    @Override
    @Transactional(readOnly = true)
    public List<ConstsClassifyDto> getClassify() {
        List<ConstsClassifyDto> list = new ArrayList<>();
        List<ConstsClassify> classify = constsClassifyMapper.selectByParentCode("0");
        for (ConstsClassify constsClassify : classify) {
            ConstsClassifyDto dto = new ConstsClassifyDto();
            List<ConstsClassify> subClassify = constsClassifyMapper.selectByParentCode(constsClassify.getCode());
            BeanUtils.copyProperties(constsClassify,dto);
            dto.setSubClassify(subClassify);
            list.add(dto);
        }
        return list;
    }
}

package com.oc.boot.portal.service.impl;

import com.oc.boot.portal.bean.ConstsSiteCarousel;
import com.oc.boot.portal.dao.ConstsSiteCarouselMapper;
import com.oc.boot.portal.service.ConstsSiteCarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ConstsSiteCarouselServiceImpl implements ConstsSiteCarouselService {

    @Autowired
    private ConstsSiteCarouselMapper constsSiteCarouselMapper;

    @Override
    @Transactional(readOnly = true)
    public List<ConstsSiteCarousel> getAll() {
        List<ConstsSiteCarousel> list = constsSiteCarouselMapper.selectAll();
        if (list.size() != 0) {
            for (ConstsSiteCarousel carousel : list) {
                carousel.setPicture("http://onw21pjl5.bkt.clouddn.com/@" + carousel.getPicture());
            }
        }
        return list;
    }
}

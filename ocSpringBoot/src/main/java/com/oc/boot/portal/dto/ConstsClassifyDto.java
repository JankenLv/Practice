package com.oc.boot.portal.dto;

import com.oc.boot.portal.bean.ConstsClassify;

import java.util.ArrayList;
import java.util.List;

public class ConstsClassifyDto extends ConstsClassify {

    private List<ConstsClassify> subClassify = new ArrayList<>();

    public List<ConstsClassify> getSubClassify() {
        return subClassify;
    }

    public void setSubClassify(List<ConstsClassify> subClassify) {
        this.subClassify = subClassify;
    }
}

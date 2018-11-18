package com.lvjing.FilterPattern;

import java.util.List;

public interface Criteria {
    public List<person> meetCriteria(List<person> personList);
}

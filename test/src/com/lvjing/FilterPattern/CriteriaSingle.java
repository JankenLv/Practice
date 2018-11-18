package com.lvjing.FilterPattern;

import java.util.ArrayList;
import java.util.List;

public class CriteriaSingle implements Criteria{
    @Override
    public List<person> meetCriteria(List<person> personList) {
        List<person> single = new ArrayList<>();
        for(person person : personList) {
            if (person.getMaritalStatus().equalsIgnoreCase("single")) {
                single.add(person);
            }
        }
        return single;
    }
}

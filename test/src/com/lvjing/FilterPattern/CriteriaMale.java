package com.lvjing.FilterPattern;

import java.util.ArrayList;
import java.util.List;

public class CriteriaMale implements Criteria{
    @Override
    public List<person> meetCriteria(List<person> personList) {
        List<person> male = new ArrayList<>();
        for(person person : personList) {
            if (person.getGender().equalsIgnoreCase("male")) {
                male.add(person);
            }
        }
        return male;
    }
}

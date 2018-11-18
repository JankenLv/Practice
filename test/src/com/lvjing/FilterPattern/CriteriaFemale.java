package com.lvjing.FilterPattern;

import java.util.ArrayList;
import java.util.List;

public class CriteriaFemale implements Criteria{
    @Override
    public List<person> meetCriteria(List<person> personList) {
        List<person> female = new ArrayList<>();
        for(person person : personList) {
            if (person.getGender().equalsIgnoreCase("female")) {
                female.add(person);
            }
        }
        return female;
    }
}

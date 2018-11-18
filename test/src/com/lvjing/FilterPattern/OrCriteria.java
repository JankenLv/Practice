package com.lvjing.FilterPattern;

import java.util.List;

public class OrCriteria implements Criteria {
    private Criteria firstCriteria;
    private Criteria secondCriteria;

    public OrCriteria(Criteria firstCriteria, Criteria secondCriteria) {
        this.firstCriteria = firstCriteria;
        this.secondCriteria = secondCriteria;
    }

    @Override
    public List<person> meetCriteria(List<person> personList) {
        List<person> firstCriteria = this.firstCriteria.meetCriteria(personList);
        List<person> secondCriteria = this.secondCriteria.meetCriteria(personList);
        for(person secondCriterion : secondCriteria) {
            if (!firstCriteria.contains(secondCriterion)) {
                firstCriteria.add(secondCriterion);
            }
        }
        return firstCriteria;
    }
}

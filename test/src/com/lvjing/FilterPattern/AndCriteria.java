package com.lvjing.FilterPattern;

import java.util.List;

public class AndCriteria implements Criteria {
    private Criteria firstCriteria;
    private Criteria secondCriteria;

    public AndCriteria(Criteria firstCriteria, Criteria secondCriteria) {
        this.firstCriteria = firstCriteria;
        this.secondCriteria = secondCriteria;
    }

    @Override
    public List<person> meetCriteria(List<person> personList) {
        List<person> firstCriteria = this.firstCriteria.meetCriteria(personList);

        return secondCriteria.meetCriteria(firstCriteria);
    }
}

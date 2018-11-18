package com.lvjing.FilterPattern;

import java.util.ArrayList;
import java.util.List;

public class CriteriaPatternDemo {
    public static void main(String[] args) {
        ArrayList<person> people = new ArrayList<>();
        people.add(new person("Davie","male","married"));
        people.add(new person("Mike","male","married"));
        people.add(new person("Hulk","male","single"));
        people.add(new person("Ben","male","single"));
        people.add(new person("Lily","female","married"));
        people.add(new person("Susan","female","married"));
        people.add(new person("Tiffany","female","single"));
        people.add(new person("Lucy","female","single"));

        Criteria male = new CriteriaMale();
        Criteria female = new CriteriaFemale();
        Criteria single = new CriteriaSingle();

        System.out.println("\nMale:");
        printPerson(male.meetCriteria(people));
        System.out.println("\nFemale:");
        printPerson(female.meetCriteria(people));
        System.out.println("\nSingle:");
        printPerson(single.meetCriteria(people));
        System.out.println("\nMale Or Single:");
        printPerson(new OrCriteria(male,single).meetCriteria(people));
        System.out.println("\nFemale And Single:");
        printPerson(new AndCriteria(female,single).meetCriteria(people));
    }

    private static void printPerson(List<person> personList) {
        for(person person : personList) {
            System.out.println(person);
        }
    }
}

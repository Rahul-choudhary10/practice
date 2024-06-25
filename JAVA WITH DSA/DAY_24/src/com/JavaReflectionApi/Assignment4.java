package com.JavaReflectionApi;


import java.util.*;

class Assignment4 {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<Person>();
        people.add(new Person("Rahul", 30));
        people.add(new Person("priyanshu", 25));
        people.add(new Person("Sam", 35));
        Comparator<Person> byAge = new Comparator<Person>() {
			public int compare(Person person1, Person person2) {
				return person1.getAge() - person2.getAge();
			}
		};
        Collections.sort(people, byAge);
        System.out.println("Sorted list of people by age:");
        for (Person person : people) {
            System.out.println(person.getName() + " - " + person.getAge());
        }
    }
}

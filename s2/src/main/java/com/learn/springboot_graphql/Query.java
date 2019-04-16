package com.learn.springboot_graphql;

import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.learn.springboot_graphql.model.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class Query implements GraphQLQueryResolver {

    public List<Person> persons() {
        List<Person> persons = new ArrayList<>();

        Person psn = new Person();
        psn.setId(1l);
        psn.setFirstName("John");
        psn.setLastName("Doe III");

        persons.add(psn);
        return persons;
    }
}

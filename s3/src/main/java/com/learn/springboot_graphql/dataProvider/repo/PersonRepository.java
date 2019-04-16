package com.learn.springboot_graphql.dataProvider.repo;


import com.learn.springboot_graphql.dataProvider.model.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {

}

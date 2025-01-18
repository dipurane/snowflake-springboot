package com.demo.snowflake.repository;

import com.demo.snowflake.model.PersonModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<PersonModel,Long> {

    public List<PersonModel> findPersonByEmail(String email);
}

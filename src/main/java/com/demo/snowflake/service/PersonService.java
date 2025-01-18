package com.demo.snowflake.service;

import com.demo.snowflake.dto.PersonDTO;

import java.util.List;

public interface PersonService {

    public void savePerson(PersonDTO dto);

    public PersonDTO findPersonByEmail(String email);

    public void deletePersonById(Long id);
}

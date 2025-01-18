package com.demo.snowflake.service.impl;

import com.demo.snowflake.dto.PersonDTO;
import com.demo.snowflake.model.PersonModel;
import com.demo.snowflake.repository.PersonRepository;
import com.demo.snowflake.service.PersonService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    /**
     *
     * @param PersonDTO
     */
    @Override
    public void savePerson(PersonDTO personDTO) {
        PersonModel personModel = new PersonModel();
        BeanUtils.copyProperties(personDTO,personModel);
        personRepository.save(personModel);
    }

    /**
     *
     * @param email
     * @return PersonDTO
     */
    @Override
    public PersonDTO findPersonByEmail(String email) {
        List<PersonModel> personModels =  personRepository.findPersonByEmail(email);

        if(!personModels.isEmpty()) {
            PersonDTO personDTOdto = new PersonDTO();
            BeanUtils.copyProperties(personModels.get(0), personDTOdto);
            return personDTOdto;
        }
        return  null;
    }

    /**
     *
     * @param id
     */
    @Override
    public void deletePersonById(Long id) {
        personRepository.deleteById(id);
    }
}

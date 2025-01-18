package com.demo.snowflake.controller;

import com.demo.snowflake.dto.PersonDTO;
import com.demo.snowflake.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    /**
     *
     * @param emailId
     * @return
     */
    @GetMapping("/{emailId}")
    public ResponseEntity<?> findPersonByEmail(@PathVariable("emailId") String emailId){
        PersonDTO personDTO =  personService.findPersonByEmail(emailId);
        if(personDTO == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<PersonDTO>(personDTO,HttpStatus.OK);
    }

    /**
     *
     * @param personDTO
     * @return
     */
    @PostMapping
    public ResponseEntity<?> savePerson(@RequestBody PersonDTO personDTO) {
       try {
           personService.savePerson(personDTO);
           return new ResponseEntity<>(HttpStatus.OK);
       }catch (Exception e){
           return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }

    /**
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePerson(@PathVariable("id") Long id){
        personService.deletePersonById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

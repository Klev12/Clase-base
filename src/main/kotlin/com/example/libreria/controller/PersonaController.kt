package com.example.libreria.controller

import com.example.libreria.model.Persona
import com.example.libreria.service.PersonaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/persona")   //endpoint
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT, RequestMethod.DELETE])
class PersonaController {
    @Autowired
    lateinit var personaService: PersonaService

    @GetMapping
    fun list(): List<Persona> {
        return personaService.list()
    }


    @PostMapping
    fun save(@RequestBody persona: Persona): ResponseEntity<Persona> {
        return ResponseEntity(personaService.save(persona), HttpStatus.OK)
    }
    @PatchMapping
    fun updateName (@RequestBody persona:Persona):ResponseEntity<Persona>{
        return ResponseEntity(personaService.updateName(persona), HttpStatus.OK)
    }
    @DeleteMapping("persona/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return personaService.delete(id)
    }
}




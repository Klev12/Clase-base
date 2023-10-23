package com.example.libreria.controller

import com.example.libreria.model.Persona
import com.example.libreria.service.PersonaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/persona")   //endpoint
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
}


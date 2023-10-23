package com.example.libreria.service

import com.example.libreria.model.Persona
import com.example.libreria.repository.PersonaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException


@Service
class PersonaService {
    @Autowired
    lateinit var personaRepository: PersonaRepository

    fun list(): List<Persona> {
        return personaRepository.findAll()
    }


    fun save(persona: Persona): Persona {
        try {
            return personaRepository.save(persona)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }
}



package com.example.libreria.controller

import com.example.libreria.model.Libro
import com.example.libreria.model.Persona
import com.example.libreria.service.LibroService
import com.example.libreria.service.PersonaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/libro")   //endpoint
class LibroController {
    @Autowired
    lateinit var libroService: LibroService

    @GetMapping
    fun list(): List<Libro> {
        return libroService.list()
    }


    @PostMapping
    fun save(@RequestBody libro: Libro): ResponseEntity<Libro> {
        return ResponseEntity(libroService.save(libro), HttpStatus.OK)
    }
    @PatchMapping
    fun updateName (@RequestBody libro: Libro): ResponseEntity<Libro> {
        return ResponseEntity(libroService.updateName(libro), HttpStatus.OK)
    }
    @DeleteMapping("libro/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return libroService.delete(id)
    }
}


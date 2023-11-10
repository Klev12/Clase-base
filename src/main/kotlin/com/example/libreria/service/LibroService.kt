package com.example.libreria.service

import com.example.libreria.model.Libro
import com.example.libreria.model.Persona
import com.example.libreria.repository.LibroRepository
import com.example.libreria.repository.PersonaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class LibroService {
    @Autowired
    lateinit var libroRepository: LibroRepository

    fun list(): List<Libro> {
        return libroRepository.findAll()
    }


    fun save(libro: Libro): Libro {
        try {
            return libroRepository.save(libro)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }
    fun updateName(libro: Libro): Libro {
        try{
            val response = libroRepository.findById(libro.id)
                    ?: throw Exception("ID no existe")
            response.apply {
                autor=libro.autor
            }
            return libroRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun delete (id: Long?):Boolean?{
        try{
            val response = libroRepository.findById(id)
                    ?: throw Exception("ID no existe")
            libroRepository.deleteById(id!!)
            return true
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

}
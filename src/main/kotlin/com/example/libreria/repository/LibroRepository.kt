package com.example.libreria.repository

import com.example.libreria.model.Libro
import com.example.libreria.model.Persona
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
    interface LibroRepository : JpaRepository<Libro, Long?> {

        fun findById (id: Long?): Libro?
}
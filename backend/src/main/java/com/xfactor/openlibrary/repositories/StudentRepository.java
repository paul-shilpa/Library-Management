package com.xfactor.openlibrary.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xfactor.openlibrary.domain.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
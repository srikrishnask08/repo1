package com.htc.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.htc.entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {

}

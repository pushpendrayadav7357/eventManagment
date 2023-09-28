package com.university.eventmanagement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository  extends JpaRepository<Student, Long> {


        List<Student> findByDepartment(Department department);


        List<Student> findByAgeBetween(int minAge, int maxAge);


        List<Student> findByFirstName(String firstName);


        List<Student> findByLastName(String lastName);

}

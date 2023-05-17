package com.javaguides.departmentservice.repository;

import com.javaguides.departmentservice.entity.Departement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Departement, Long> {
    Departement findDepartementByDepartmentCode(String departmentCode);
}

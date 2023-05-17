package com.javaguides.departmentservice.service;

import com.javaguides.departmentservice.dto.DepartmentDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
public interface DepartmentService {
    DepartmentDto saveDepartment(DepartmentDto departmentDto);
    DepartmentDto getDepartmentByCode(String code);

}

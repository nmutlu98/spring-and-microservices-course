package com.javaguides.departmentservice.service.impl;

import com.javaguides.departmentservice.dto.DepartmentDto;
import com.javaguides.departmentservice.entity.Departement;
import com.javaguides.departmentservice.exception.ResourceNotFoundException;
import com.javaguides.departmentservice.repository.DepartmentRepository;
import com.javaguides.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentRepository repository;
    private ModelMapper modelMapper;
    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        Departement department = modelMapper.map(departmentDto, Departement.class);
        repository.save(department);
        return modelMapper.map(department, DepartmentDto.class);
    }

    @Override
    public DepartmentDto getDepartmentByCode(String code) throws ResourceNotFoundException {
        Departement departement = repository.findDepartementByDepartmentCode(code);
        if (departement == null) throw new ResourceNotFoundException("Department with code " + code + " does not exist.");
        DepartmentDto departmentDto = modelMapper.map(departement, DepartmentDto.class);
        return departmentDto;
    }
}

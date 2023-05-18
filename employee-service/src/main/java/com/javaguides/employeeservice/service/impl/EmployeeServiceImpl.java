package com.javaguides.employeeservice.service.impl;

import com.javaguides.employeeservice.dto.APIResponseDto;
import com.javaguides.employeeservice.dto.DepartmentDto;
import com.javaguides.employeeservice.dto.EmployeeDto;
import com.javaguides.employeeservice.entity.Employee;
import com.javaguides.employeeservice.repository.EmployeeRepository;
import com.javaguides.employeeservice.service.APIClient;
import com.javaguides.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
    private ModelMapper modelMapper;
    private APIClient apiClient;
    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = modelMapper.map(employeeDto, Employee.class);
        employeeRepository.save(employee);
        return modelMapper.map(employee, EmployeeDto.class);
    }

    @Override
    public APIResponseDto getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).get();
        DepartmentDto departmentDto = apiClient.getDepartment(employee.getDepartmentCode());
        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployee(modelMapper.map(employee, EmployeeDto.class));
        apiResponseDto.setDepartment(departmentDto);
        return apiResponseDto;
    }


}

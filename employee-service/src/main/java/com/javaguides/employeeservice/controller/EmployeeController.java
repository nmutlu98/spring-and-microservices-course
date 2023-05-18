package com.javaguides.employeeservice.controller;

import com.javaguides.employeeservice.dto.APIResponseDto;
import com.javaguides.employeeservice.dto.EmployeeDto;
import com.javaguides.employeeservice.entity.Employee;
import com.javaguides.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("api/employees")
public class EmployeeController {
    private EmployeeService service;

    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto employeeDto1 = service.saveEmployee(employeeDto);
        return new ResponseEntity<>(employeeDto1, HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<APIResponseDto> getEmployee(@PathVariable("id") Long employeeId){
        APIResponseDto apiResponseDto = service.getEmployeeById(employeeId);
        return new ResponseEntity<>(apiResponseDto, HttpStatus.OK);
    }
}

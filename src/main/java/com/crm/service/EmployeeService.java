package com.crm.service;


import com.crm.entity.Employee;
import com.crm.exception.ResourceNotFound;
import com.crm.payload.EmployeeDto;
import com.crm.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;
    private ModelMapper modelMapper;
    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }


// public void addEmployee(Employee employee) {
//     employeeRepository.save(employee);
// }
public EmployeeDto addEmployee(EmployeeDto dto) {
        Employee employee=maptoEntity(dto);
        Employee emp=employeeRepository.save(employee);
        EmployeeDto employeeDto=maptoDto(emp);
//        employeeDto.setDate(new Date());
    return employeeDto;
}


    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public EmployeeDto updateEmployee(Long id, EmployeeDto dto) {
        Employee employee = maptoEntity(dto);
//        employee.setId(id);
        Employee updatedEmployee=employeeRepository.save(employee);
        EmployeeDto employeeDto=maptoDto(updatedEmployee);
        return employeeDto;

    }

//    public List<EmployeeDto > getEmployee() {
//        List<Employee> employees = employeeRepository.findAll();
//        List<EmployeeDto> dto = employees.stream().map(e -> maptoDto(e)).collect(Collectors.toList());
//        return dto;
//    }

    public List<EmployeeDto > getEmployee(int pageNo, int pageSize, String sortBy, String sortDir) {
      Sort sort=  sortDir.equalsIgnoreCase("asc")?Sort.by(sortBy).ascending():Sort.by(sortBy).descending();
        Pageable page = PageRequest.of(pageNo, pageSize, sort);
        Page<Employee> all = employeeRepository.findAll(page);
        List<Employee> employees = all.getContent();
        List<EmployeeDto> dto = employees.stream().map(e -> maptoDto(e)).collect(Collectors.toList());
        return dto;
    }

    EmployeeDto maptoDto(Employee employee){
        EmployeeDto dto = modelMapper.map(employee, EmployeeDto.class);
//       EmployeeDto dto=new EmployeeDto();
//       dto.setId(employee.getId());
//       dto.setName(employee.getName());
//       dto.setEmailId(employee.getEmailId());
//       dto.setMobile(employee.getMobile());

       return dto;
    }

    Employee maptoEntity(EmployeeDto dto){
        Employee emp = modelMapper.map(dto, Employee.class);
//        Employee employee=new Employee();
//        employee.setId(dto.getId());
//        employee.setName(dto.getName());
//        employee.setEmailId(dto.getEmailId());
//        employee.setMobile(dto.getMobile());
        return emp;

    }


//    public EmployeeDto getEmployeeById(long empId) {
//        Optional<Employee> ompeg = employeeRepository.findById(empId);
//        Employee employee=ompeg.get();
//        return maptoDto(employee);
//    }

    public EmployeeDto getEmployeeById(long empId) {
        Employee employee=employeeRepository.findById(empId).orElseThrow(
        ()->new ResourceNotFound("Record not found with id" +empId)
        );
        EmployeeDto dto = maptoDto(employee);
        return dto;
    }
}

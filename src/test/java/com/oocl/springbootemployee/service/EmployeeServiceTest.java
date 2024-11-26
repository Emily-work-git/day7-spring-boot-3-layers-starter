package com.oocl.springbootemployee.service;

import com.oocl.springbootemployee.model.Employee;
import com.oocl.springbootemployee.model.Gender;
import com.oocl.springbootemployee.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class EmployeeServiceTest {
    EmployeeRepository mockedEmployeeRepository = mock(EmployeeRepository.class);

    @Test
    void should_return_the_given_employees_when_getAllEmployees() {
        //given
        when(mockedEmployeeRepository.getAll()).thenReturn(List.of(new Employee(1, "Lucy", 18, Gender.FEMALE, 8000.0)));
        EmployeeService employeeService = new EmployeeService(mockedEmployeeRepository);

        //when
        List<Employee> allEmployees = employeeService.getAllEmployees();

        //then
        assertEquals(1, allEmployees.size());
        assertEquals("Lucy", allEmployees.get(0).getName());
    }

    @Test
    void should_return_the_created_employee_when_create_given_a_employee() {
        //given
        Employee lucy = new Employee(1, "Lucy", 18, Gender.FEMALE, 8000.0);
        when(mockedEmployeeRepository.addEmployee(any())).thenReturn(lucy);
        EmployeeService employeeService = new EmployeeService(mockedEmployeeRepository);

        //when
        Employee createdEmployee = employeeService.creat(lucy);

        //then
        assertEquals("Lucy", createdEmployee.getName());
    }
    @Test
    public void should_return_invalid_age_error_when_create_given_employee_age_17(){
        // Given
        Employee lucy = new Employee(1, "Lucy", 17, Gender.FEMALE, 8000.0);
        EmployeeService employeeService = new EmployeeService(mockedEmployeeRepository);
        // When
        // Then
        assertThrows(InvalidAgeException.class, ()-> employeeService.creat(lucy));
        verify(mockedEmployeeRepository, never()).addEmployee(any());
    }
    @Test
    public void should_return_invalid_age_error_when_create_given_employee_age_66(){
        // Given
        Employee lucy = new Employee(1, "Lucy", 66, Gender.FEMALE, 8000.0);
        EmployeeService employeeService = new EmployeeService(mockedEmployeeRepository);
        // When
        // Then
        assertThrows(InvalidAgeException.class, ()-> employeeService.creat(lucy));
        verify(mockedEmployeeRepository, never()).addEmployee(any());
    }
    @Test
    public void should_return_invalid_age_with_salary_error_when_create_given_employee_age_30_and_salary_8000(){
        // Given
        Employee lucy = new Employee(1, "Lucy", 30, Gender.FEMALE, 8000.0);
        EmployeeService employeeService = new EmployeeService(mockedEmployeeRepository);
        // When
        // Then
        assertThrows(InvalidAgeWithSalaryException.class, ()-> employeeService.creat(lucy));
        verify(mockedEmployeeRepository, never()).addEmployee(any());
    }
}

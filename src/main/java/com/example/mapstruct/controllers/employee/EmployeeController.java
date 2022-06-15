package com.example.mapstruct.controllers.employee;

import com.example.mapstruct.model.Employee;
import com.example.mapstruct.service.employee.IEmployeeService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
    private final IEmployeeService iEmployeeService;
    public EmployeeController(@Autowired IEmployeeService iEmployeeService) {
        this.iEmployeeService = iEmployeeService;
    }
    @ApiOperation("search all employees of bd")
    @ApiResponses({
            @ApiResponse(code = 200, message = "ok"),
            @ApiResponse(code = 404, message = "employee no found"),
    })
    @GetMapping("/employee")
    public ResponseEntity<Iterable<Employee>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(iEmployeeService.getAll());
    }
    @ApiOperation("save a employee")
    @ApiResponses({
            @ApiResponse(code = 200, message = "ok"),
            @ApiResponse(code = 404, message = "employee no found"),
    })
    @PostMapping("/employee")
    public ResponseEntity<Employee> addEmpleado(@RequestBody Employee employee) {
        return ResponseEntity.status(HttpStatus.OK).body(iEmployeeService.save(employee));
    }
}

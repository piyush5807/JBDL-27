package com.example.jbdl.apis;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
public class EmployeeController {

    /**
     * TRACE - 1000
     * DEBUG - 300
     * INFO - 100
     * WARN - 10
     * ERROR - 1
     **/


    private static int count = 1;
    private HashMap<Integer, Employee> employeeMap = new HashMap<>();

    /**
     Hashmap - {employee.id, employee}

     * Add a new employee --> input : employee object, output: void
     * Get the details of a particular employee --> input: employee id, output: employee
     * Get details of all the employees present --> input: <>, output: List<employee>
     * Update details of an employee --> input: id, (details to be updated) , output: employee
     * Delete the employee --> input: id, output : boolean | employee | void
     **/

    // conversion from json object to a java object and vice versa is done by some spring-web utility

    @PostMapping("/employee/add")
    public Employee addEmployee(@Valid @RequestBody Employee employee){

//        employee.setEmployeeId(UUID.randomUUID().toString());

        System.out.println(this);
        //

        System.out.println("Inside add employee function");

        employee.setId(count++);
        employeeMap.putIfAbsent(employee.getId(), employee);

        return employee;
    }

    @GetMapping("/employee/get")
    public Employee getEmployee(@RequestParam("id") int id){
        System.out.println(this);
        return employeeMap.get(id);
    }

    @GetMapping("/employee/get/all")
    public List<Employee> getAllEmployees(){
        System.out.println(this);
        return employeeMap.values()
                .stream()
                .collect(Collectors.toList());
    }

    @PutMapping("/employee/update")
    public Employee updateEmployee(@RequestBody Employee employee) throws Exception {

        if(employee.getId() == null){
            throw new Exception("Id is not present for the employee to be updated");
        }

        if(!employeeMap.containsKey(employee.getId())){
            throw new Exception("Employee is not present");
        }

        employeeMap.put(employee.getId(), employee);
        return employee;

    }

    @DeleteMapping("/employee/delete")
    public Employee deleteEmployee(@PathVariable("id") int id){
        return employeeMap.remove(id);
    }

    @GetMapping("/dummy")
    public List<Integer> getListOfNumbers(@RequestParam(value = "start", required = false, defaultValue = "20") int start,
                                          @RequestParam("end") int end){

        System.out.println(this);
        return IntStream.range(start, end + 1)
                .boxed()
                .collect(Collectors.toList());
    }

    // com.example.jbdl.apis.EmployeeController@720cc6d0


}

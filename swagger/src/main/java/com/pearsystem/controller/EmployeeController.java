package com.pearsystem.controller;

import com.pearsystem.model.Employee;
import com.pearsystem.service.EmployeeService;
import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiPathParam;
import org.jsondoc.core.pojo.ApiStage;
import org.jsondoc.core.pojo.ApiVisibility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(name="Employee Management System",description = "Employee info",group = "Management",visibility = ApiVisibility.PUBLIC,stage = ApiStage.BETA)
public class EmployeeController {

    @Autowired
    private EmployeeService service;

   @RequestMapping(value ="ems_create",method=RequestMethod.POST)
   @ApiMethod(description = "add new employee")
    public String save(@RequestBody Employee employee){      // http://localhost:9094/swagger-ui.html
                                                             // http://localhost:9094/jsondoc-ui.html
       service.saveEmployee(employee);
       return "Successfully create Employee";

    }
    @RequestMapping(value ="ems_get/{id}",method=RequestMethod.GET)
    @ApiMethod(description = "get employee by id",path = "{id}")
    public Employee getEmployee(@PathVariable  @ApiPathParam(description = "input employee id to get",name = "id")
                                    int id){
      return service.getEmployee(id);

    }
    @RequestMapping(value ="ems_delete/{id}",method=RequestMethod.DELETE)
    @ApiMethod(description = "delete employee by id",path = "{id}")
    public List<Employee> deleteEmployee(@PathVariable @ApiPathParam(description = "input employee id to delete",name = "id") int id){
       return service.deleteEmployee(id);

    }
}

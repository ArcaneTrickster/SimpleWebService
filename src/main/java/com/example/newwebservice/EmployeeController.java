package com.example.newwebservice;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value= "/api/employee")  // this decorator specify the url for your web service. url will be http://localhost:8102/api/employee to access functions/methods of this class.
public class EmployeeController {
    @Autowired
    Employeedao edao;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * Method to fetch all employees from the db.
     * @return
     */
    @GetMapping(value= "/getall")  //i.e http://localhost:8102/api/employee/getall to get all data from table.
    public Iterable<Employee> getAll() {
        logger.debug("Get all employees.");
        return edao.getAllEmployees();
    }

    /**
     * Method to fetch employees on the basis of department.
     * @param department
     * @return
     */
    @GetMapping(value= "/department/{employee-department}") //i.e http://localhost:8102/api/departmeent/Technology to get all entries with Technology department from table.
    public Iterable<Employee> getEmployeesByDepartment(@PathVariable(name= "employee-department") String department) {
        logger.debug("Getting count for department= {}.", department);
        return edao.getEmployeesByDepartment(department);
    }
    //@RequestMapping(value = "/pdepartment", method = RequestMethod.GET)
    @GetMapping(value= "/pdepartment")
    public Iterable<Employee> pgetEmployeesByDepartment(@RequestParam String department) {
        logger.debug("Getting count for department= {}.", department);
        return edao.getEmployeesByDepartment(department);
    }
    /**
     * Method to fetch employees count on the basis of designation.
     * @param designation
     * @return
     */
    @GetMapping(value= "/count/{employee-designation}")//i.e http://localhost:8102/api/employee/count/Lead to get all number of entries with Lead designation from table.
    public Integer getEmployeeCountByDesignation(@PathVariable(name= "employee-designation") String designation) {
        logger.debug("Getting count for employee-designations= {}.", designation);
        return edao.getEmployeesCountByDesignation(designation);
    }
}

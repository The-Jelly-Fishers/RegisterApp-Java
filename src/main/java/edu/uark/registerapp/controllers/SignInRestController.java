package edu.uark.registerapp.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.uark.registerapp.commands.employees.EmployeeCreateCommand;
import edu.uark.registerapp.commands.employees.EmployeeDeleteCommand;
import edu.uark.registerapp.commands.employees.EmployeeUpdateCommand;
import edu.uark.registerapp.commands.ActiveUserCreateCommand;
import edu.uark.registerapp.commands.ActiveUserDeleteCommand;
import edu.uark.registerapp.models.api.ActiveUser;
import edu.uark.registerapp.models.api.ApiResponse;
import edu.uark.registerapp.models.api.Employee;

@RestController
@RequestMapping(value = "/{signInView}")
public class SignInRestController {
	// @RequestMapping(value = "/signInView", method = RequestMethod.POST) // this was moved to SignInRoute
	// public @ResponseBody ApiResponse createUser(
	// 	@RequestBody final ActiveUser user
	// ) {
	// 	// System.out.println("creating user");
	// 	 return this.activeUserCreateCommand
	// 	// 	.setApiActiveUser(user)
	// 	// 	.execute();
	// }

	// @RequestMapping(value = "/{employeeid}", method = RequestMethod.PUT) // not required for now
	// public @ResponseBody ApiResponse updateEmployee(
	// 	@PathVariable final int employeeId,
	// 	@RequestBody final Employee employee
	// ) {

	// 	return this.employeeUpdateCommand
	// 		.setEmployeeId(employeeId).setApiEmployee(employee).execute();
    // }

    @RequestMapping(value = "/signInView", method = RequestMethod.DELETE)
    public @ResponseBody ApiResponse deleteUser(@PathVariable final int employeeId) {
		System.out.println("deleteing user");
        this.activeUserDeleteCommand
            //.setEmployeeId(employeeId)
			.execute();
		return new ApiResponse();
	}

	// Properties
	@Autowired
	private ActiveUserCreateCommand activeUserCreateCommand;
	
	@Autowired
	private ActiveUserDeleteCommand activeUserDeleteCommand;
	
	@Autowired
	private EmployeeUpdateCommand employeeUpdateCommand;
}

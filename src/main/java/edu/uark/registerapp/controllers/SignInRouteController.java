package edu.uark.registerapp.controllers;

import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import edu.uark.registerapp.commands.employees.ActiveEmployeeExistsQuery;
import edu.uark.registerapp.commands.employees.EmployeeCreateCommand;
import edu.uark.registerapp.commands.employees.EmployeeQuery;
import edu.uark.registerapp.commands.employees.EmployeeCreateCommand;
import edu.uark.registerapp.controllers.enums.ViewModelNames;
import edu.uark.registerapp.controllers.enums.ViewNames;
import edu.uark.registerapp.models.api.Employee;
import edu.uark.registerapp.models.api.Employeesignin;


@Controller
public class SignInRouteController {
	// testing: 
	@RequestMapping(value = "/signInView", method = RequestMethod.GET)
	@ResponseBody
	// add request param later
	public ModelAndView showEmployeeListing(@RequestParam Map<String, String> allParams) {
		System.out.println("Sign In View Success");
		System.out.println("params: " + allParams.entrySet()); 
		ModelAndView modelAndView =
			new ModelAndView(ViewNames.EMPLOYEE_LISTING.getViewName());
		
		return modelAndView;
	
	}
//////////////////////////////////////////////////////////////Sign In View Routing///////////////////////////////////////////////

	@RequestMapping(value = "/")
	@ResponseBody
	// add request param later
	public ModelAndView showSignIn() {
		// if at least one employee exists, allow sign in page to be viewed first 
		ModelAndView modelAndView =
			new ModelAndView(ViewNames.EMPLOYEE_LISTING.getViewName());

		try { // will reroute if no employee... is is what I have below correct? 
			System.out.println("inside try..."); 
			modelAndView.addObject(
			ViewModelNames.EMPLOYEE.getValue(),
			this.employeeQuery.execute());
			// ModelAndView modAndView = new ModelAndView(ViewNames.EMPLOYEE_LISTING.getViewName()); 
		} catch (final Exception e) {
			System.out.println("inside catch...");
			ModelAndView model = new ModelAndView(ViewNames.EMPLOYEE_DETAIL.getViewName()); 
			System.out.println("return model"); 
			
			return model; 
		}
		System.out.println("return modelAndView"); 
		return modelAndView; 
	}

	@RequestMapping(value = "/signInView", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	@ResponseBody
	public String showSignInfo(@RequestParam Map<String, String> allParams)//httpservletrequest also goes here
	{
		System.out.println("Parameters are: " + allParams.entrySet()); 
		System.out.println("inside sign in info");
		return "Sign Success"; 
	}

// 	@RequestMapping(value = "/productDetail")
// public class ProductDetailRouteController {
// 	@RequestMapping(method = RequestMethod.GET)
// 	public ModelAndView start() {
// 		return (new ModelAndView(ViewNames.PRODUCT_DETAIL.getViewName()))
// 			.addObject(
// 				ViewModelNames.PRODUCT.getValue(),
// 				(new Product()).setLookupCode(StringUtils.EMPTY).setCount(0));
// 	}

	// @RequestMapping(value = "/{productId}", method = RequestMethod.GET)
	// original: @RequestMapping(value = "/employeeDetail", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	@RequestMapping(value = "/employeeDetail", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ModelAndView showDetailInfo(@RequestParam int employeeid, @RequestParam String firstname, @RequestParam String lastname, @RequestParam String password, @RequestParam int classification)
	{
		System.out.println("employeeid: " + employeeid); 
		System.out.println("firstname: " + firstname); 
		System.out.println("lastname" + lastname); 
		System.out.println("password" + password); 
		System.out.println("classification" + classification); 

		// newEmployee.setManagerId(-1); I think it already does this... 
		ModelAndView modelAndView = new ModelAndView(ViewNames.EMPLOYEE_DETAIL.getViewName());  

		// try { // will reroute if no employee... is is what I have below correct? 
		// 	System.out.println("inside try 2..."); 
		// 	modelAndView.addObject(
		// 	ViewModelNames.EMPLOYEE.getValue(),
		// 	this.employeeQuery.execute());
		// 	// ModelAndView modAndView = new ModelAndView(ViewNames.EMPLOYEE_LISTING.getViewName()); 
		// } catch (final Exception e) {
		// 	System.out.println("inside catch 2...");
		// 	modelAndView.addObject(
		// 	ViewModelNames.EMPLOYEE.getValue(),
		// 	this.employeeCreate.execute()); 
		// }
		Employee newEmployee = new Employee(); 
				newEmployee.setId(UUID.randomUUID()); 
				newEmployee.setEmployeeId(employeeid); 
				newEmployee.setFirstName(firstname); 
				newEmployee.setLastName(lastname); 
				newEmployee.setPassword(password); 
				newEmployee.setActive(false); 
				newEmployee.setClassification(classification);

		try {
			modelAndView.addObject(
				ViewModelNames.EMPLOYEE.getValue(),
				this.employeeQuery.setEmployeeId(employeeid).execute());
		} catch (final Exception e) {
			System.out.println("inside inside"); 
			modelAndView.addObject(ViewModelNames.EMPLOYEE.getValue(), newEmployee);   
			modelAndView.addObject(ViewModelNames.EMPLOYEE.getValue(), this.employeeCreate.setApiEmployee(newEmployee).execute());   
		} 

		return modelAndView; // rerouting back to sign in page, should eventually only do this if first employee 
	}
		
		@RequestMapping(value = "/{employeeid}", method = RequestMethod.GET)
		public ModelAndView startWithProduct(@RequestParam final String employeeid) {
			System.out.println("inside employeeid"); 
			final ModelAndView modelAndView = new ModelAndView(ViewNames.EMPLOYEE_DETAIL.getViewName());
			return modelAndView;
		}

		
//////////////////////////////////////////////////////////////Employee Detail Routing////////////////////////////////////////////
//////////////////////////////////////////////////////////////Main Menu Routing//////////////////////////////////////////////////
@RequestMapping(value = "/mainMenu", method = RequestMethod.GET)
@ResponseBody
// add request param later
public ModelAndView showMainMenu() {
	System.out.println("will it enter? ");
	
	ModelAndView modelAndView =
		new ModelAndView(ViewNames.MAIN_MENU.getViewName());
	
	return modelAndView;

}

@RequestMapping(value = "/managerMenu", method = RequestMethod.GET)
@ResponseBody
// add request param later
public ModelAndView showManagerMenu() {
	System.out.println("will it enter? ");
	
	ModelAndView modelAndView =
		new ModelAndView(ViewNames.MANAGER_MENU.getViewName());
	
	return modelAndView;

}

@RequestMapping(value = "/mainMenu", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
@ResponseBody
public String showMenuInfo(@RequestParam Map<String, String> allParams)
{
	System.out.println("Parameters are: " + allParams.entrySet()); 
	return "Menu Success"; 
}
//////////////////////////////////////////////////////////////Main Menu Routing//////////////////////////////////////////////////
	// Properties
	@Autowired
	private EmployeeQuery employeeQuery;
	@Autowired
	private EmployeeCreateCommand employeeCreate; 
	@Autowired
	private ActiveEmployeeExistsQuery activeEmployee; 
}
	
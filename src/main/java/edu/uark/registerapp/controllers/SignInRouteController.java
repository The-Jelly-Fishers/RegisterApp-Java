package edu.uark.registerapp.controllers;

import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import edu.uark.registerapp.commands.employees.EmployeeQuery;
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
			return model; 
			// modelAndView.addObject(
			// 	ViewModelNames.ERROR_MESSAGE.getValue(),
			// 	e.getMessage());
		}
		/*try 
		{
			employeeQuery
			ModelAndView modAndView = new ModelAndView(ViewNames.EMPLOYEE_LISTING.getViewName()); 
			return modAndView; 
		}
		catch (Exception e) // if no employees exist, reroute to employeeDetails so that html page is viewed first 
		{
			ModelAndView model = new ModelAndView(ViewNames.EMPLOYEE_DETAIL.getViewName()); 
			return model; 
		}
		*/
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

	// @RequestMapping(value = "/{empId}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	// public ModelAndView startWithEmployee(@PathVariable final UUID empId, @RequestParam Map<String, String> allParams) {
	// 	System.out.println("Parameters are: " + allParams.entrySet()); 
	// 	final ModelAndView modelAndView =
	// 		new ModelAndView(ViewNames.EMPLOYEE_LISTING.getViewName());//should actually be redirecting to main menu

	// 	try {
	// 		modelAndView.addObject(
	// 			ViewModelNames.EMPLOYEE.getValue(),
	// 			this.employeeQuery.setEmployeeId(empId).execute());
	// 	} catch (final Exception e) {
	// 		modelAndView.addObject(
	// 			ViewModelNames.ERROR_MESSAGE.getValue(),
	// 			e.getMessage());
	// 		modelAndView.addObject(
	// 			ViewModelNames.EMPLOYEE.getValue(),
	// 			(new Employee())
	// 				.setPassword(" ")
	// 				.setEmployeeId(StringUtils.EMPTY));
	// 	}
	// 	return modelAndView;
	// }
//////////////////////////////////////////////////////////////Sign In View Routing///////////////////////////////////////////////
//////////////////////////////////////////////////////////////Employee Detail Routing////////////////////////////////////////////
	// @RequestMapping(value = "/employeeDetail", method = RequestMethod.GET)
	// @ResponseBody
	// // add request param later
	// public ModelAndView showEmployeeDetail() {
	// 	System.out.println("will it enter? ");
		
	// 	ModelAndView modelAndView =
	// 		new ModelAndView(ViewNames.EMPLOYEE_DETAIL.getViewName());
		
	// 	return modelAndView;
	
	// }

	@RequestMapping(value = "/employeeDetail", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	@ResponseBody
	public ModelAndView showDetailInfo(@RequestParam Map<String, String> allParams)
	{
		System.out.println("Parameters are: " + allParams.entrySet()); 


		return (new ModelAndView(ViewNames.EMPLOYEE_LISTING.getViewName())); // rerouting back to sign in page, should eventually only do this if first employee 
	}

		@RequestMapping(value = "/employeeDetail", method = RequestMethod.GET)
		@ResponseBody
		public ModelAndView employeeDetail() {
			System.out.println("Employee Detail Success"); 

			return (new ModelAndView(ViewNames.EMPLOYEE_DETAIL.getViewName()));
		}
	
		/*@RequestMapping(value = "/{employeeId}", method = RequestMethod.GET)
		public ModelAndView startWithProduct(@PathVariable final UUID productId) {
			System.out.println("Employee Detail Success");
			final ModelAndView modelAndView =
				new ModelAndView(ViewNames.PRODUCT_DETAIL.getViewName());
			return modelAndView;
		}
		*/
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
}
	
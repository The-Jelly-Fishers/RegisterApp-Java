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

import edu.uark.registerapp.commands.products.EmployeeQuery;
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
	public ModelAndView showEmployeeListing() {
		System.out.println("Sign In View Success");
		
		ModelAndView modelAndView =
			new ModelAndView(ViewNames.EMPLOYEE_LISTING.getViewName());
		
		return modelAndView;
	
	}
//////////////////////////////////////////////////////////////Sign In View Routing///////////////////////////////////////////////
	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	// add request param later
	public ModelAndView showSignIn() {
		System.out.println("Sign In Success");
		// commented out at 10:45 pm 
		ModelAndView modelAndView =
			new ModelAndView(ViewNames.EMPLOYEE_LISTING.getViewName());
		
		return modelAndView;
	}

	@RequestMapping(value = "/signInView", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	@ResponseBody
	public String showSignInfo(@RequestParam Map<String, String> allParams)//httpservletrequest also goes here
	{
		System.out.println("Parameters are: " + allParams.entrySet()); 
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

	// @RequestMapping(value = "/employeeDetail", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	// @ResponseBody
	// public String showDetailInfo(@RequestParam Map<String, String> allParams)
	// {
	// 	System.out.println("Parameters are: " + allParams.entrySet()); 
	// 	return "Employee Success"; 
	// }

	public class EmployeeDetailRouteController {
		@RequestMapping(value = "/employeeDetail")
		public ModelAndView start() {
			System.out.println("Employee Detail Success");
			return (new ModelAndView(ViewNames.EMPLOYEE_DETAIL.getViewName()));
		}
	
		@RequestMapping(value = "/{employeeId}", method = RequestMethod.GET)
		public ModelAndView startWithProduct(@PathVariable final UUID productId) {
			System.out.println("Employee Detail Success");
			final ModelAndView modelAndView =
				new ModelAndView(ViewNames.PRODUCT_DETAIL.getViewName());
			return modelAndView;
		}
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
	
package edu.uark.registerapp.controllers;

import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

//import edu.uark.registerapp.commands.products.ProductQuery;
import edu.uark.registerapp.controllers.enums.ViewModelNames;
import edu.uark.registerapp.controllers.enums.ViewNames;
//import edu.uark.registerapp.models.api.Product;
//import edu.uark.registerapp.models.entities.EmployeeEntity;
import edu.uark.registerapp.models.api.Employee;
import edu.uark.registerapp.models.api.Employeesignin;
//import edu.uark.registerapp.models.entities.EmployeeEntity;

// localhosthost:8080/signInView/
// www.google.com/cat
@Controller
@GetMapping("/signInView/api/Employeesignin")

public class SignInRouteController {
	
	@GetMapping("/")
	public ModelAndView showEmployeeListing(@RequestParam("Employeesignin") String employeeId, String password) {
		ModelAndView modelAndView =
			new ModelAndView(ViewNames.EMPLOYEE_LISTING.getViewName());

		try {
			modelAndView.addObject(
				ViewModelNames.EMPLOYEES.getValue());
				//@RequestParam(Map <String , String> allParams)
				//Task 5 command will be called here
		} catch (final Exception e) {
			modelAndView.addObject(
				ViewModelNames.ERROR_MESSAGE.getValue(),
				e.getMessage());
			modelAndView.addObject(
				ViewModelNames.EMPLOYEES.getValue(),
				(new Employee[0]));
		}
		
		return modelAndView;
	}
    /*@RequestMapping(method = RequestMethod.GET)
	public ModelAndView start() {
		return (new ModelAndView(ViewNames.EMPLOYEE_DETAIL.getViewName()))
			.addObject(
				ViewModelNames.EMPLOYEE.getValue(),
				(new Employee()).setEmployeeId(StringUtils.EMPTY).setPassword(" "));
	}*/
/*
	@RequestMapping(value = "/{productId}", method = RequestMethod.GET)
	public ModelAndView startWithProduct(@PathVariable final UUID productId) {
		final ModelAndView modelAndView =
			new ModelAndView(ViewNames.PRODUCT_DETAIL.getViewName());

		try {
			modelAndView.addObject(
				ViewModelNames.PRODUCT.getValue(),
				this.productQuery.setProductId(productId).execute());
		} catch (final Exception e) {
			modelAndView.addObject(
				ViewModelNames.ERROR_MESSAGE.getValue(),
				e.getMessage());
			modelAndView.addObject(
				ViewModelNames.PRODUCT.getValue(),
				(new Product())
					.setCount(0)
					.setLookupCode(StringUtils.EMPTY));
		}

		return modelAndView;
	}

	// Properties
	@Autowired
	private ProductQuery productQuery;*/
	
    
}

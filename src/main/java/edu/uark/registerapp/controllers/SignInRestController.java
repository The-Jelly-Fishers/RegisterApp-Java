<<<<<<< HEAD
// package edu.uark.registerapp.controllers;

// import java.util.UUID;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.web.bind.annotation.ResponseBody;
// import org.springframework.web.bind.annotation.RestController;

// import edu.uark.registerapp.commands.products.ProductCreateCommand;
// import edu.uark.registerapp.commands.products.ProductDeleteCommand;
// import edu.uark.registerapp.commands.products.ProductUpdateCommand;
// import edu.uark.registerapp.models.api.ApiResponse;
// import edu.uark.registerapp.models.api.Product;
// import edu.uark.registerapp.models.api.Employee;
// import edu.uark.registerapp.models.api.Employeesignin;
// //import edu.uark.registerapp.models.entities.EmployeeEntity;

// @RestController
// // @RequestMapping(value = "/signInView/api/Employeesignin")
// // public class EmployeeRestController {
// // 	@RequestMapping(value = "/", method = RequestMethod.POST)
// // 	public @ResponseBody ApiResponse createProduct(
// // 		@RequestBody final Product product
// // 	) {

// 		// return this.productCreateCommand
// 		// 	.setApiProduct(product)
// 		// 	.execute();
// //	}

// 	// @RequestMapping(value = "/{EmployeeId}", method = RequestMethod.PUT)
// 	// public @ResponseBody ApiResponse updateProduct(
// 	// 	@PathVariable final UUID productId,
// 	// 	@RequestBody final Product product
// 	// ) {

// 	// 	return this.productUpdateCommand
// 	// 		.setProductId(productId)
// 	// 		.setApiProduct(product)
// 	// 		.execute();
// 	// }

// 	// @RequestMapping(value = "/{EmployeeId}", method = RequestMethod.DELETE)
// 	// public @ResponseBody ApiResponse removeEmployee(
// 	// 	@PathVariable final UUID EmployeeId
// 	// ) {

// 	// 	// this.removeEmployeeCommand
// 	// 	// 	.setEmployeeId(EmployeeId)
// 	// 	// 	.execute();

// 	// 	return new ApiResponse();
// 	// }

// 	// Properties
// 	// @Autowired
// 	// private ProductCreateCommand productCreateCommand;
	
// 	//@Autowired
// 	//private RemoveEmployeeCommand removeEmployeeCommand;
	
// 	// @Autowired
// 	// private ProductUpdateCommand productUpdateCommand;
// //}
=======
package edu.uark.registerapp.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.uark.registerapp.commands.products.ProductCreateCommand;
import edu.uark.registerapp.commands.products.ProductDeleteCommand;
import edu.uark.registerapp.commands.products.ProductUpdateCommand;
import edu.uark.registerapp.models.api.ApiResponse;
import edu.uark.registerapp.models.api.Product;
import edu.uark.registerapp.models.api.Employee;
import edu.uark.registerapp.models.api.Employeesignin;
//import edu.uark.registerapp.models.entities.EmployeeEntity;

@RestController
@RequestMapping(value = "/signInView/api/Employeesignin")
public class SignInRestController {
	// @RequestMapping(value = "/", method = RequestMethod.POST)
	// public @ResponseBody ApiResponse createProduct(
	// 	@RequestBody final Product product
	// ) {

	// 	return this.productCreateCommand
	// 		.setApiProduct(product)
	// 		.execute();
	// }

	// @RequestMapping(value = "/{EmployeeId}", method = RequestMethod.PUT)
	// public @ResponseBody ApiResponse updateProduct(
	// 	@PathVariable final UUID productId,
	// 	@RequestBody final Product product
	// ) {

	// 	return this.productUpdateCommand
	// 		.setProductId(productId)
	// 		.setApiProduct(product)
	// 		.execute();
	// }

	@RequestMapping(value = "/{EmployeeId}", method = RequestMethod.DELETE)
	public @ResponseBody ApiResponse removeEmployee(
		@PathVariable final UUID EmployeeId
	) {

		// this.removeEmployeeCommand
		// 	.setEmployeeId(EmployeeId)
		// 	.execute();

		return new ApiResponse();
	}

	// Properties
	// @Autowired
	// private ProductCreateCommand productCreateCommand;
	
	@Autowired
	private RemoveEmployeeCommand removeEmployeeCommand;
	
	// @Autowired
	// private ProductUpdateCommand productUpdateCommand;
}
>>>>>>> f78369a6d30e155f0e53528e9c636710f0865020

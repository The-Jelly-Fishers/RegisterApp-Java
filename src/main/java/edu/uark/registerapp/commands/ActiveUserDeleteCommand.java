// package edu.uark.registerapp.commands;

// import java.util.Optional;

// import javax.transaction.Transactional;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import edu.uark.registerapp.models.api.ActiveUser;
// //import edu.uark.registerapp.models.api.Employee;
// import edu.uark.registerapp.models.entities.ActiveUserEntity;
// import javassist.NotFoundException;
// import edu.uark.registerapp.models.repositories.ActiveUserRepository;
// //import edu.uark.registerapp.commands.VoidCommandInterface;


// @Service
// public class ActiveUserDeleteCommand implements VoidCommandInterface
// {
//     @Transactional
//     @Override
//     public void execute() {
//         final Optional<ActiveUserEntity> activeUserEntity = 
//             this.activeUserRepository.findById(activeUser.getId());
//         if (!activeUserEntity.isPresent()){
//             try {
//                 throw new NotFoundException("Active User");
//             } catch (NotFoundException e) {
//                 // TODO Auto-generated catch block
//                 e.printStackTrace();
//             }
//         }
//         (this.activeUserRepository).deleteById(activeUser.getId());
//     }
    
//     @Autowired
// 	private ActiveUserRepository activeUserRepository;
//     @Autowired
//     private ActiveUser activeUser; 
// }
 
package edu.uark.registerapp.commands;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.uark.registerapp.commands.VoidCommandInterface;
import edu.uark.registerapp.commands.exceptions.NotFoundException;
import edu.uark.registerapp.models.entities.ActiveUserEntity;
import edu.uark.registerapp.models.repositories.ActiveUserRepository;

@Service
public class ActiveUserDeleteCommand implements VoidCommandInterface {
	@Transactional
	@Override
	public void execute() {
		final Optional<ActiveUserEntity> activeUserEntity =
			this.activeUserRepository.findById(this.id);
		if (!activeUserEntity.isPresent()) { // No record with the associated record ID exists in the database.
			throw new NotFoundException("id");
		}

		this.activeUserRepository.delete(activeUserEntity.get());
	}

	// Properties
	private UUID id;
	public UUID getId() {
		return this.id;
	}
	public ActiveUserDeleteCommand setProductId(final UUID id) {
		this.id = id;
		return this;
	}
	
	@Autowired
	private ActiveUserRepository activeUserRepository;
}

package alkemy.challenge.Challenge.Alkemy.controller;

import alkemy.challenge.Challenge.Alkemy.model.User;
import alkemy.challenge.Challenge.Alkemy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
	
	// error critico: no hace falta que la variable sea final
	@Autowired
    private  UserService userService;

/*
	 * mala practica: no es necesario crear un metodo para que cambie de valor la variable
	 con tan solo poner la anotacion @Autowired arriba de la creacion de la variable es suficiente.
    public UserController(UserService userService) {
        this.userService = userService;
    }
*/

    @DeleteMapping("/{id}")
    // error critico: agregarle a la clase que tiene que devolver un tipo de parametro 
    public ResponseEntity<Object> deleteUserById(@PathVariable Long id) {
        Optional<User> user = userService.findById(id);
        /*
         *error de logica: en vez de usar !user.isEmpty() para que devuelva un booleano
         se debe utilizar isPresent() que devuelve verdadero si contiene se encuentra el
         elemento o en caso contrario devuelve falso. 
         */
        
        if (user.isPresent()) {
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    //error critico: agregarle un parametro a la clase que se tiene que devolver.
    @GetMapping("/id/{email}")
    public ResponseEntity<List<User>> getUserByAge (@PathVariable String email){
        return new  ResponseEntity<> (userService.findByAge(email), HttpStatus.FORBIDDEN);
    }
}

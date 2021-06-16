package alkemy.challenge.Challenge.Alkemy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import alkemy.challenge.Challenge.Alkemy.model.User;
import alkemy.challenge.Challenge.Alkemy.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
/*
 * mala practica: nunca se una la variable 
 
  ------>private static final String USER_NOT_FOUND = "User with email %s don't found";<---------
*/
	// error critico: la variable no necesita que sea final.
	@Autowired
	private  UserRepository userRepository;
/*
 * mala practica: no es necesario crear un metodo para que cambie de valor la variable
 con tan solo poner la anotacion @Autowired arriba de la creacion de la variable es suficiente. 

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
*/

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        userRepository.findByEmail(email);
        return null;
    }

    public List<User> findByAge (String age){
        return userRepository.findByAge(age);
    }

}

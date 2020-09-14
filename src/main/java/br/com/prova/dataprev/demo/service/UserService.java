package br.com.prova.dataprev.demo.service;

import br.com.prova.dataprev.demo.model.User;
import br.com.prova.dataprev.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    public Page<User> findUserByName(String email, Pageable pagination){
        Optional<User> user =  userRepository.findByEmail(email);
        if(user.isPresent()){
            user.get();
        }
        throw new UsernameNotFoundException("Dados Invalidos!");
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}

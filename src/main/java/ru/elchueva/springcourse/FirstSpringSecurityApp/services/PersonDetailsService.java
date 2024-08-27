package ru.elchueva.springcourse.FirstSpringSecurityApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.elchueva.springcourse.FirstSpringSecurityApp.models.Person;
import ru.elchueva.springcourse.FirstSpringSecurityApp.repositories.PeopleRepository;
import ru.elchueva.springcourse.FirstSpringSecurityApp.security.PersonDetails;

import java.util.Optional;

@Service
public class PersonDetailsService implements UserDetailsService {

    private final PeopleRepository personRepository;

    @Autowired
    public PersonDetailsService(PeopleRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Person> person = personRepository.findByUsername(username);

        if (person.isEmpty())
            throw new UsernameNotFoundException("User not found");
        return new PersonDetails(person.get());
    }

}

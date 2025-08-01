package br.com.wallacewolv.repository;

import br.com.wallacewolv.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> { }

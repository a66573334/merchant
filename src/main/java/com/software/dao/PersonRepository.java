package com.software.dao;

import com.software.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by hasee on 2017/11/5.
 */
public interface PersonRepository extends JpaRepository<Person,Long> {
}

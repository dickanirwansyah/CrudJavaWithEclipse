package com.dickanirwansyah.main.CrudJavaWithEclipse.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.dickanirwansyah.main.CrudJavaWithEclipse.entities.Nasabah;

public interface NasabahServices extends CrudRepository<Nasabah, Integer>{

}

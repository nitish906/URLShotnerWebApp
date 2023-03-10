package com.masai.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.beans.URL;

@Repository
public interface URLRepo extends JpaRepository<URL, Integer>{

}

package tn.opengov.spring.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tn.opengov.spring.entity.FileDB;




public interface FileDBRepository extends JpaRepository<FileDB, Long> {
	

}

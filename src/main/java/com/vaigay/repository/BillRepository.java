package com.vaigay.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vaigay.Entity.Bill;

public interface BillRepository extends JpaRepository<Bill, Long>{
	
	Optional<Bill> findByIdAndCart_User_Id(long id,long idUser);
	
	List<Bill> findAllByCart_User_Id(long idUser);
}

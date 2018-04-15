package com.example.bortakvall.Repositories;

import com.example.bortakvall.entity.RentedInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentedInfoRepository extends JpaRepository<RentedInfo, Long> {

}

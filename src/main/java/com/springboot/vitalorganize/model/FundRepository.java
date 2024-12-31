package com.springboot.vitalorganize.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface FundRepository extends JpaRepository<FundEntity, Long> {

    @Query("SELECT f FROM FundEntity f JOIN f.users u WHERE u.id = :userId")
    List<FundEntity> findFundsByUserId(@Param("userId") Long userId);

    List<FundEntity> findByAdmin(UserEntity admin);
}

package com.springboot.vitalorganize.model;


import com.paypal.api.payments.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PaymentRepository  extends JpaRepository<Zahlung, Long> {
    @Query("SELECT p FROM Zahlung p ORDER BY p.date DESC LIMIT 1")
    Optional<Zahlung> findLatestTransaction();


    List<Zahlung> findAllByUser(UserEntity profileData);

    @Modifying
    @Query("UPDATE Zahlung o SET o.user = NULL WHERE o.user.id = :userId")
    void updateUserReferencesToNull(@Param("userId") Long userId);

}

package com.footstep.domain.mail.repository;

import com.footstep.domain.mail.entity.MailVerification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MailVerificationRepository extends JpaRepository<MailVerification, Long> {
    @Query("SELECT m FROM MailVerification m WHERE m.mail = :mail AND m.code = :code")
    Optional<MailVerification> findByMailAndCode(@Param("mail") String mail, @Param("code") String code);
}

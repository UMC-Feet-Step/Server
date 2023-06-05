package com.footstep.domain.mail.entity;

import com.footstep.domain.base.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
public class MailVerification extends BaseTimeEntity {

    @Id @GeneratedValue
    @Column(name = "mail_verification_id")
    private Long id;
    private String mail;
    private String code;
    private LocalDateTime expiredDate;

    public MailVerification(String mail, String code) {
        this.code = code;
        this.mail = mail;
        this.expiredDate = LocalDateTime.now().plusMinutes(3);
    }
}

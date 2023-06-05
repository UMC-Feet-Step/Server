package com.footstep.domain.posting.domain;

import com.footstep.domain.base.Status;
import com.footstep.domain.posting.domain.posting.Posting;
import com.footstep.domain.users.domain.Users;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Likes {

    @Id
    @GeneratedValue
    @Column(name = "like_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id")
    private Users users;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "posting_id")
    private Posting posting;

    @Builder
    public Likes(Users users, Posting posting) {
        this.users = users;
        this.posting = posting;
        this.status = Status.NORMAL;
    }

    public void removeLikes() {
        this.status = Status.EXPIRED;
    }
}

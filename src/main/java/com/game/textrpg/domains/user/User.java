package com.game.textrpg.domains.user;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Entity
@Builder
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(name="user_id", unique=true)
    @NonNull
    private String userId;
    
    @Column(name="user_pwd")
    @NonNull
    private String userPwd;

    @Column(name="user_name")
    private String userName;
}

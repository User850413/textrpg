package com.game.textrpg.domains.backpack;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="backpacks")
public class Backpack {
    
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(name="name")
    @NonNull
    private String name;

    @Column(name="max_carriage")
    @NonNull
    private Integer maxCarriage;
}

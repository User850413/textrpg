package com.game.textrpg.domains.item;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="items")
public class Item {
    
    @Id
    @GeneratedValue(generator="UUID")
    private UUID id;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;
}

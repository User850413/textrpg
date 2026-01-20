package com.game.textrpg.domains.item;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

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
    @NonNull
    private String name;

    @Column(name="description")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name="category")
    @NonNull
    private ItemType category;

    public enum ItemType {
        EQUIP, CONSUME, MATERIAL, QUEST
    }
}

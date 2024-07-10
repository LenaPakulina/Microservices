package ru.skill.openfeign.model;

import lombok.*;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Item {
    @EqualsAndHashCode.Include
    private int id;

    private String name;
}

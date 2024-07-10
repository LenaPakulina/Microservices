package ru.skill.resttemplate.model;

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

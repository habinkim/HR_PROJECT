package com.ecoandrich.hr.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "regions")
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "region_id", nullable = false)
    private Integer id;

    @Size(max = 25)
    @Column(name = "region_name", length = 25)
    private String regionName;

    @OneToMany(mappedBy = "region")
    private Set<Country> countries = new LinkedHashSet<>();

}

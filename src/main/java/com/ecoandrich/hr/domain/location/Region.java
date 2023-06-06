package com.ecoandrich.hr.domain.location;

import jakarta.persistence.*;
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

    @Column(name = "region_name", length = 25)
    private String regionName;

    @Builder.Default
    @OneToMany(mappedBy = "region")
    private Set<Country> countries = new LinkedHashSet<>();

}

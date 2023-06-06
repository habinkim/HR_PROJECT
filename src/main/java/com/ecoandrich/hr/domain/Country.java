package com.ecoandrich.hr.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "countries")
public class Country {

    @Id
    @Column(name = "country_id", columnDefinition = "char(2) not null")
    private String countryId;

    @Column(name = "country_name", length = 40)
    private String countryName;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "region_id", nullable = false)
    private Region region;

    @OneToMany(mappedBy = "country")
    private Set<Location> locations = new LinkedHashSet<>();

}

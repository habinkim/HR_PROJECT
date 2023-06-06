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

    @Builder.Default
    @OneToMany(mappedBy = "country")
    private Set<Location> locations = new LinkedHashSet<>();

}

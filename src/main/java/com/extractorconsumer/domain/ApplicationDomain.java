package com.extractorconsumer.domain;

import com.extractorconsumer.dto.ApplicationDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "application")
@Entity
@Data
@NoArgsConstructor
public class ApplicationDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "application_owner")
    private String applicationOwner;

    @Column(name = "application_name")
    private String applicationName;

    @Column(name = "application_description")
    private String applicationDescription;

    @Column(name = "application_language")
    private String applicationLanguage;

    public ApplicationDomain adapt(final ApplicationDTO applicationDTO) {
        ApplicationDomain applicationDomain = new ApplicationDomain();
        applicationDomain.setApplicationOwner(applicationDTO.getApplicationOwner());
        applicationDomain.setApplicationName(applicationDTO.getApplicationName());
        applicationDomain.setApplicationDescription(applicationDTO.getApplicationDescription());
        applicationDTO.setApplicationLanguage(applicationDTO.getApplicationLanguage());
        return applicationDomain;
    }
}

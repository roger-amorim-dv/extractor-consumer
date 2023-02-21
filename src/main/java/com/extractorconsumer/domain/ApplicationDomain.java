package com.extractorconsumer.domain;

import com.extractorconsumer.dto.ApplicationDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Table(name = "application")
@Entity
@Data
@NoArgsConstructor
public class ApplicationDomain implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "application_owner")
    private String application_owner;

    @Column(name = "application_name")
    private String application_name;

    @Column(name = "application_description")
    private String application_description;

    @Column(name = "application_language")
    private String application_language;

    public ApplicationDomain adapt(final ApplicationDTO applicationDTO) {
        ApplicationDomain applicationDomain = new ApplicationDomain();
        applicationDomain.setApplication_owner(applicationDTO.getApplication_owner());
        applicationDomain.setApplication_name(applicationDTO.getApplication_name());
        applicationDomain.setApplication_description(applicationDTO.getApplication_description());
        applicationDomain.setApplication_language(applicationDTO.getApplication_language());
        return applicationDomain;
    }
}

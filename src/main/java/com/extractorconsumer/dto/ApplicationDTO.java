package com.extractorconsumer.dto;

import com.extractorconsumer.domain.ApplicationDomain;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ApplicationDTO {

    private String applicationOwner;

    private String applicationName;

    private String applicationDescription;

    private String applicationLanguage;

    public static ApplicationDTO adapt(final ApplicationDomain application) {
        return ApplicationDTO.builder()
                .applicationOwner(application.getApplicationOwner())
                .applicationName(application.getApplicationName())
                .applicationDescription(application.getApplicationDescription())
                .applicationLanguage(application.getApplicationLanguage())
                .build();

    }
}

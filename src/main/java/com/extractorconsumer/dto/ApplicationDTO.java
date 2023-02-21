package com.extractorconsumer.dto;

import com.extractorconsumer.domain.ApplicationDomain;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ApplicationDTO {

    @NotNull(message = "field application owner not be null")
    private String application_owner;
    @NotNull(message = "field application name not be null")
    private String application_name;
    @NotNull(message = "field application description not be null")
    private String application_description;
    @NotNull(message = "field application language not be null")
    private String application_language;

    public static ApplicationDTO adapt(final ApplicationDomain application) {
        return ApplicationDTO.builder()
                .application_owner(application.getApplication_owner())
                .application_name(application.getApplication_name())
                .application_description(application.getApplication_description())
                .application_language(application.getApplication_language())
                .build();

    }
}

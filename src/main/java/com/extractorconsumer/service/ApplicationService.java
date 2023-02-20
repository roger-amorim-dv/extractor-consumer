package com.extractorconsumer.service;

import com.extractorconsumer.domain.ApplicationDomain;
import com.extractorconsumer.dto.ApplicationDTO;
import com.extractorconsumer.repository.ApplicationRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class ApplicationService {

    private final ApplicationRepository applicationRepository;

    public ApplicationDTO createApplication(final ApplicationDTO applicationDTO) {
        log.info("[CREATE-APPLICATION] Starting create application stream [{}]", applicationDTO.getApplicationName());
        applicationRepository.saveAndFlush(new ApplicationDomain().adapt(applicationDTO));
        log.info("[CREATE-APPLICATION] New application [{}] created successfully!", applicationDTO.getApplicationName());
        return applicationDTO;
    }

    public List<ApplicationDTO> getApplicationDTOList() {
        return applicationRepository.findAll()
                .stream()
                .map(ApplicationDTO::adapt)
                .distinct()
                .collect(Collectors.toList());
    }

}

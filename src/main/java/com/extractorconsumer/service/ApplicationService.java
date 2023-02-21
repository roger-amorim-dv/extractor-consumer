package com.extractorconsumer.service;

import com.extractorconsumer.domain.ApplicationDomain;
import com.extractorconsumer.dto.ApplicationDTO;
import com.extractorconsumer.repository.ApplicationRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    public ApplicationDTO createApplication(final ApplicationDTO applicationDTO) {
        log.info("[CREATE-APPLICATION] Starting create application stream [{}]", applicationDTO.getApplication_name());
        applicationRepository.saveAndFlush(new ApplicationDomain().adapt(applicationDTO));
        log.info("[CREATE-APPLICATION] New application [{}] created successfully!", applicationDTO.getApplication_name());
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

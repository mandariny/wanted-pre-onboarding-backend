package wanted.pre.onboarding.jobportal.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import wanted.pre.onboarding.jobportal.domain.Company;
import wanted.pre.onboarding.jobportal.domain.Recruit;
import wanted.pre.onboarding.jobportal.dto.RecruitPostResponse;
import wanted.pre.onboarding.jobportal.dto.RecruitRequest;
import wanted.pre.onboarding.jobportal.exception.NoSuchCompanyException;
import wanted.pre.onboarding.jobportal.repository.CompanyRepository;
import wanted.pre.onboarding.jobportal.repository.RecruitRepository;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class RecruitService {
    private final CompanyRepository companyRepository;
    private final RecruitRepository recruitRepository;

    public RecruitPostResponse saveRecruit(Long coompanyId, RecruitRequest recruitRequest) {
        Company company = companyRepository.findById(coompanyId)
                .orElseThrow(NoSuchCompanyException::new);

        Recruit recruit = Recruit.builder()
                .company(company)
                .position(recruitRequest.getPosition())
                .reward(recruitRequest.getReward())
                .contents(recruitRequest.getContents())
                .skill(recruitRequest.getSkill())
                .build();

        Recruit savedRecruit = recruitRepository.save(recruit);
        return new RecruitPostResponse(savedRecruit.getId());
    }
}

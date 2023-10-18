package wanted.pre.onboarding.jobportal.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.transaction.annotation.Transactional;
import wanted.pre.onboarding.jobportal.domain.Address;
import wanted.pre.onboarding.jobportal.domain.Company;
import wanted.pre.onboarding.jobportal.domain.Recruit;
import wanted.pre.onboarding.jobportal.domain.SkillType;
import wanted.pre.onboarding.jobportal.dto.RecruitResponse;
import wanted.pre.onboarding.jobportal.dto.RecruitRequest;
import wanted.pre.onboarding.jobportal.exception.NoSuchCompanyException;
import wanted.pre.onboarding.jobportal.exception.NoSuchRecruitException;
import wanted.pre.onboarding.jobportal.repository.CompanyRepository;
import wanted.pre.onboarding.jobportal.repository.RecruitRepository;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;

@SpringBootTest
@Transactional
class RecruitServiceTest {

    @MockBean
    private CompanyRepository companyRepository;

    @MockBean
    private RecruitRepository recruitRepository;

    @Autowired
    private RecruitService recruitService;

    private Company company;
    private RecruitRequest recruitRequest;

    @BeforeEach
    void setUp(){
        company = Company.builder()
                .id(1L)
                .name("구글 코리아")
                .addr(Address.builder()
                        .nation("한국")
                        .region("서울")
                        .detailAddr("강남구?")
                        .build())
                .build();

        recruitRequest = RecruitRequest.builder()
                .position("백엔드")
                .reward(100000)
                .contents("백엔드 개발자 채용합니다.")
                .skill(SkillType.Java)
                .build();
    }

    @Test
    @DisplayName("채용공고 등록 요청시 공고 생성")
    public void 채용공고_등록(){
        // given
        Recruit newRecruit = Recruit.builder()
                .id(1L)
                .company(company)
                .position("백엔드")
                .reward(100000)
                .contents("백엔드 개발자 채용합니다.")
                .skill(SkillType.Java)
                .build();

        given(companyRepository.findById(anyLong()))
                .willReturn(Optional.of(company));
        given(recruitRepository.save(any(Recruit.class)))
                .willReturn(newRecruit);

        // when
        RecruitResponse response = recruitService.saveRecruit(company.getId(), recruitRequest);

        // then
        assertThat(response.getId()).isEqualTo(newRecruit.getId());
    }

    @Test
    @DisplayName("채용공고 등록 요청시 회사 정보가 틀리면 예외 발생")
    void 채용공고_등록_회사가_없는_경우(){
        // given
        given(companyRepository.findById(anyLong()))
                .willReturn(Optional.empty());

        // when, then
        assertThatThrownBy(() -> recruitService.saveRecruit(company.getId(), recruitRequest))
                .isInstanceOf(NoSuchCompanyException.class);

    }

    @Test
    @DisplayName("채용공고 수정 요청시 공고가 없으면 예외 발생")
    void 채용공고_수정_공고가_없는_경우(){
        // given
        Recruit newRecruit = Recruit.builder()
                .id(1L)
                .company(company)
                .position("백엔드")
                .reward(100000)
                .contents("파이썬 백엔드 개발자 채용합니다.")
                .skill(SkillType.Python)
                .build();

        given(recruitRepository.findById(anyLong()))
                .willReturn(Optional.empty());

        // when, then
        assertThatThrownBy(() -> recruitService.updateRecruit(newRecruit.getId(), recruitRequest))
                .isInstanceOf(NoSuchRecruitException.class);
    }
}
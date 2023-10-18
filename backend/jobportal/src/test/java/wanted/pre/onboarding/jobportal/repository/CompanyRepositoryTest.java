package wanted.pre.onboarding.jobportal.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import wanted.pre.onboarding.jobportal.domain.Address;
import wanted.pre.onboarding.jobportal.domain.Company;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CompanyRepositoryTest {

    @Autowired
    CompanyRepository companyRepository;

    private Company company;

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
    }

    @Test
    @DisplayName("회사 저장")
    void 회사_저장(){
        // given, when
        Company savedCompany = companyRepository.save(company);

        // then
        assertThat(savedCompany).isEqualTo(company);
    }

    @Test
    @DisplayName("Id로 회사 조회")
    void 아이디로_회사_조회(){
        // given
        Company savedCompany = companyRepository.save(company);

        // when
        Company foundCompany = companyRepository.findById(company.getId()).get();

        // then
        assertThat(savedCompany).isEqualTo(foundCompany);
    }
}

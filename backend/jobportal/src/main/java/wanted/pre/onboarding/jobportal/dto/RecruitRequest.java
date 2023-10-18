package wanted.pre.onboarding.jobportal.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import wanted.pre.onboarding.jobportal.domain.SkillType;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecruitRequest {

    private String position;
    private int reward;
    private String contents;
    private SkillType skill;

}

package wanted.pre.onboarding.jobportal.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@DynamicInsert
@DynamicUpdate
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="Recruit")
public class Recruit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

    private String position;

    private int reward;

    private String contents;

    @Enumerated(EnumType.STRING)
    private SkillType skill;

    @Column(name = "post_date")
    private LocalDateTime postDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recruit recruit = (Recruit) o;
        return reward == recruit.reward && Objects.equals(id, recruit.id) && Objects.equals(company, recruit.company) && Objects.equals(position, recruit.position) && Objects.equals(contents, recruit.contents) && skill == recruit.skill && Objects.equals(postDate, recruit.postDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, company, position, reward, contents, skill, postDate);
    }

}

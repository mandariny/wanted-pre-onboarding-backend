package wanted.pre.onboarding.jobportal.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="Company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Embedded
    private Address addr;

    @Column(name = "establishment")
    private LocalDateTime establishedTime;

    @OneToMany(mappedBy = "company", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Recruit> recruits;

    public int getRecruitsSize(){
        return recruits.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return Objects.equals(id, company.id) && Objects.equals(name, company.name) && Objects.equals(addr, company.addr) && Objects.equals(establishedTime, company.establishedTime) && Objects.equals(recruits, company.recruits);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, addr, establishedTime, recruits);
    }

}

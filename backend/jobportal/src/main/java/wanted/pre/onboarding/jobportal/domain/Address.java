package wanted.pre.onboarding.jobportal.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class Address {

    private String nation;

    private String region;

    @Column(name = "detail_addr")
    private String detailAddr;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(nation, address.nation) && Objects.equals(region, address.region) && Objects.equals(detailAddr, address.detailAddr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nation, region, detailAddr);
    }
}

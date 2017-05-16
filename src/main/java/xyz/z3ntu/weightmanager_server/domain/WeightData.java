package xyz.z3ntu.weightmanager_server.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "weight_data")
public class WeightData extends AbstractPersistable<Long> {

    @Version
    private Long version;

    @NotNull
    @Size(min = 5, max = 4096)
    @Column(name = "content", nullable = false)
    private String content;
}
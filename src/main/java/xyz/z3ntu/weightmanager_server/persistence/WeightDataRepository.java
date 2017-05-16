package xyz.z3ntu.weightmanager_server.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.z3ntu.weightmanager_server.domain.WeightData;

import java.util.Optional;

@Repository
public interface WeightDataRepository extends JpaRepository<WeightData, Long> {
    Optional<WeightData> findById(Long id);
}

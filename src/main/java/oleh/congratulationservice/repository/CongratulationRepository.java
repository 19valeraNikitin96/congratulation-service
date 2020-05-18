package oleh.congratulationservice.repository;

import oleh.congratulationservice.entity.CongratulationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CongratulationRepository extends JpaRepository<CongratulationEntity, Integer> {
}

package smartbits.junior.meditrack.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import smartbits.junior.meditrack.Entities.PillEntity;

public interface PillRepository extends JpaRepository<PillEntity, Integer> {
    
}

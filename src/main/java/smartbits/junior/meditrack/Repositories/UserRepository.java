package smartbits.junior.meditrack.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import smartbits.junior.meditrack.Entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    
}

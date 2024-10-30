package smartbits.junior.meditrack.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import smartbits.junior.meditrack.Entities.PillEntity;
import smartbits.junior.meditrack.Repositories.PillRepository;

@Service
public class PillService {

    @Autowired
    private PillRepository pillRepository;

    public List<PillEntity> getAllPills() {
        return pillRepository.findAll();
    }

    public PillEntity getPillById(int id) {
        return pillRepository.findById(id).orElse(null);
    }

    public PillEntity createPill(PillEntity pill) {
        return pillRepository.save(pill);
    }

    public PillEntity updatePill(PillEntity pill) {
        return pillRepository.save(pill);
    }

    public void deletePill(int id) {
        pillRepository.deleteById(id);
    }
}
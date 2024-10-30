package smartbits.junior.meditrack.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import smartbits.junior.meditrack.Entities.PillEntity;
import smartbits.junior.meditrack.Services.PillService;

@RestController
@RequestMapping("/pills")
public class PillController {

    @Autowired
    private PillService pillService;

    @GetMapping("/get_all")
    public List<PillEntity> getAllPills() {
        return pillService.getAllPills();
    }

    @GetMapping("/get_by_id/{id}")
    public PillEntity getPillById(@PathVariable int id) {
        return pillService.getPillById(id);
    }

    @PostMapping("/create")
    public PillEntity createPill(@RequestBody PillEntity pill) {
        return pillService.createPill(pill);
    }

    @PutMapping("/update/{id}")
    public PillEntity updatePill(@PathVariable int id, @RequestBody PillEntity pill) {
        pill.setPill_ID(id);
        return pillService.updatePill(pill);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePill(@PathVariable int id) {
        pillService.deletePill(id);
    }

    @GetMapping("/test_req")
    public String TestRequest() {
        return "TEST REQUEST PILL";
    }
}
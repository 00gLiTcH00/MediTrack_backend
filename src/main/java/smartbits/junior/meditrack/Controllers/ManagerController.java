package smartbits.junior.meditrack.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import smartbits.junior.meditrack.Services.ManagerService;

@RestController
@RequestMapping("/manager")
public class ManagerController {

    private final ManagerService managerService;

    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }

    @PostMapping({"{id}"})
    public ResponseEntity<?> releasePill(@PathVariable Long id){
        managerService.releasePill(id);
        return ResponseEntity.ok().build();
    }

}

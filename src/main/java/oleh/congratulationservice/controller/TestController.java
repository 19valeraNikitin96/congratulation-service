package oleh.congratulationservice.controller;

import oleh.congratulationservice.entity.CongratulationEntity;
import oleh.congratulationservice.repository.CongratulationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private CongratulationRepository repository;

    @GetMapping("/test1")
    public String test1(){
        return "test1";
    }

    @PostMapping("/test2")
    public String test2(){
        return "test2";
    }

    @GetMapping("/test3/{id}")
    public String test3(@PathVariable Integer id){
        return "Path variable: "+id;
    }

    @PostMapping("/create-congrat")
    public String createCongrat(){
        CongratulationEntity entity = new CongratulationEntity();
        entity.setEmail("abra@abra.abra");
        entity.setMsg("Test msg");
        CongratulationEntity res = repository.save(entity);
        return "id: "+res.getId();
    }

    @GetMapping("/after-git")
    public String afterGit(){
        return "After git";
    }
}

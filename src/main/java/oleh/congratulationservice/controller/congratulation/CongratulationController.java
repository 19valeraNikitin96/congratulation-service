package oleh.congratulationservice.controller.congratulation;

import oleh.congratulationservice.bo.CongratulationBO;
import oleh.congratulationservice.controller.congratulation.model.CongratulationJSON;
import oleh.congratulationservice.controller.congratulation.model.CongratulationIdJSON;
import oleh.congratulationservice.controller.model.ResponseJSON;
import oleh.congratulationservice.exception.CongratulationException;
import oleh.congratulationservice.exception.Validation;
import oleh.congratulationservice.mapper.CongratulationMapper;
import oleh.congratulationservice.service.congratulation.CongratulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static oleh.congratulationservice.common.ResponseStatus.*;

@RestController
@RequestMapping("/congratulation")
public class CongratulationController {

    @Autowired
    private CongratulationService congratulationService;
    @Autowired
    private CongratulationMapper congratulationMapper;

    @PostMapping("/create")
    public ResponseEntity<ResponseJSON<CongratulationIdJSON>> create(@RequestBody CongratulationJSON json){
        Integer id = congratulationService.save(congratulationMapper.toBO(json));
        ResponseJSON<CongratulationIdJSON> r = new ResponseJSON<>();
        r.setMsg("Congratulation successfully created");
        r.setStatus("ok");
        r.setData(new CongratulationIdJSON(id));
        return ResponseEntity.status(HttpStatus.OK).body(r);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseJSON<?>> deleteBy(@PathVariable(name = "id") Integer id){
        Validation<Void, CongratulationException> res = congratulationService.deleteBy(id);
        ResponseJSON<Void> r = new ResponseJSON<>();
        if(res.isValid()){
            r.setMsg("Congratulation successfully deleted");
            r.setStatus(OK.getStatus());
            return ResponseEntity.status(HttpStatus.OK).body(r);
        }
        r.setStatus(FAILED.getStatus());
        r.setMsg(res.getExceptions().get(0).getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(r);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<ResponseJSON<?>> updateBy(@PathVariable(name = "id") Integer id, @RequestBody CongratulationJSON json){
        CongratulationBO bo = congratulationMapper.toBO(json);
        bo.setId(id);
        Validation<Void, CongratulationException> res = congratulationService.update(bo);
        ResponseJSON<Void> r = new ResponseJSON<>();
        if(res.isValid()){
            r.setStatus(OK.getStatus());
            r.setMsg("Congratulation successfuly updated");
            return ResponseEntity.status(HttpStatus.OK).body(r);
        }
        r.setStatus(FAILED.getStatus());
        r.setMsg(res.getExceptions().get(0).getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(r);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseJSON<CongratulationJSON>> getBy(@PathVariable(name = "id") Integer id){
        Validation<CongratulationBO, CongratulationException> res = congratulationService.getBy(id);
        ResponseJSON<CongratulationJSON> r = new ResponseJSON<>();
        if(res.isValid()){
            r.setStatus(OK.getStatus());
            r.setData(congratulationMapper.toJSON(res.getData()));
            return ResponseEntity.status(HttpStatus.OK).body(r);
        }
        r.setStatus(FAILED.getStatus());
        r.setMsg(res.getExceptions().get(0).getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(r);
    }
}

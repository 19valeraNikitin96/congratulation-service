package oleh.congratulationservice.controller.congratulation;

import oleh.congratulationservice.controller.congratulation.model.RequestJSON;
import oleh.congratulationservice.controller.congratulation.model.ResponseDataJSON;
import oleh.congratulationservice.controller.model.ResponseJSON;
import oleh.congratulationservice.exception.CongratulationException;
import oleh.congratulationservice.exception.Validation;
import oleh.congratulationservice.mapper.CongratulationMapper;
import oleh.congratulationservice.service.congratulation.CongratulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/congratulation")
public class CongratulationController {

    @Autowired
    private CongratulationService congratulationService;
    @Autowired
    private CongratulationMapper congratulationMapper;

    @PostMapping("/create")
    public ResponseEntity<ResponseDataJSON> create(@RequestBody RequestJSON json){
        Integer id = congratulationService.save(congratulationMapper.toBO(json));
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDataJSON(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseJSON<?>> deleteBy(@PathVariable(name = "id") Integer id){
        Validation<Void, CongratulationException> res = congratulationService.deleteBy(id);
        ResponseJSON<Object> r = new ResponseJSON<>();
        if(res.isValid()){
            r.setMsg("Congratulation successfully deleted");
            r.setStatus("ok");
            return ResponseEntity.status(HttpStatus.OK).body(r);
        }
        r.setStatus("failed");
        r.setMsg(res.getExceptions().get(0).getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(r);
    }

    /*
    URL: "/congratulation/create"
    Method: POST
    Request body:
    {
        "email": "a@a.a",
        "message": "Поздравляю тебя, мой дорогой друг!!!",
        "date":{
            "day": 26,
            "month": 12,
            "year": 1996
        }
    }
    Response body:
    {
        "status": "ok",
        "msg": "Congratulation successfully created",
        "data":{
            "congratulation-id": 345
        }
    }

    URL: "/congratulation/delete/{id}"
    Method: DELETE
    Request body:
    Response body #1:
    {
        "status": "ok",
        "msg": "Congratulation successfully deleted"
    }
    Response body #2:
    {
        "status": "failed",
        "msg": "Congratulation not found"
    }
     */
}

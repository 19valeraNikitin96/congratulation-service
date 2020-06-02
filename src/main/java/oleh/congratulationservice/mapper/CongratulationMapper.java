package oleh.congratulationservice.mapper;

import oleh.congratulationservice.bo.CongratulationBO;
import oleh.congratulationservice.bo.DateBO;
import oleh.congratulationservice.controller.congratulation.model.RequestJSON;
import oleh.congratulationservice.entity.CongratulationEntity;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class CongratulationMapper {

    public CongratulationEntity toEntity(CongratulationBO bo) {
        CongratulationEntity entity = new CongratulationEntity();
        entity.setId(bo.getId());
        entity.setEmail(bo.getEmail());
        entity.setMsg(bo.getMessage());
        entity.setDate(new Date(bo.getDate().getYear()-1900, bo.getDate().getMonth(), bo.getDate().getDay()));
        return entity;
    }

    public CongratulationBO toBO(RequestJSON json) {
        CongratulationBO bo = new CongratulationBO();
        bo.setEmail(json.getEmail());
        bo.setMessage(json.getMessage());
        bo.setDate(new DateBO(json.getDate().getDay(),json.getDate().getMonth(),json.getDate().getYear()));
        return bo;
    }
}

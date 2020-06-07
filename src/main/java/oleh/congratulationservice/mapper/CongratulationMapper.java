package oleh.congratulationservice.mapper;

import oleh.congratulationservice.bo.CongratulationBO;
import oleh.congratulationservice.bo.DateBO;
import oleh.congratulationservice.controller.congratulation.model.CongratulationJSON;
import oleh.congratulationservice.controller.congratulation.model.DateJSON;
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

    public CongratulationBO toBO(CongratulationJSON json) {
        CongratulationBO bo = new CongratulationBO();
        bo.setEmail(json.getEmail());
        bo.setMessage(json.getMessage());
        bo.setDate(new DateBO(json.getDate().getDay(),json.getDate().getMonth(),json.getDate().getYear()));
        return bo;
    }

    public CongratulationBO toBO(CongratulationEntity entity){
        CongratulationBO bo = new CongratulationBO();
        bo.setId(entity.getId());
        bo.setDate(toBO(entity.getDate()));
        bo.setMessage(entity.getMsg());
        bo.setEmail(entity.getEmail());
        return bo;
    }

    private DateBO toBO(Date date) {
        DateBO bo = new DateBO();
        bo.setDay(date.getDay());
        bo.setMonth(date.getMonth());
        bo.setYear(date.getYear());
        return bo;
    }

    public CongratulationJSON toJSON(CongratulationBO bo) {
        CongratulationJSON json = new CongratulationJSON();
        json.setId(bo.getId());
        json.setDate(toJSON(bo.getDate()));
        json.setEmail(bo.getEmail());
        json.setMessage(bo.getMessage());
        return json;
    }

    private DateJSON toJSON(DateBO bo) {
        DateJSON json = new DateJSON();
        json.setDay(bo.getDay());
        json.setMonth(bo.getMonth());
        json.setYear(bo.getYear());
        return json;
    }
}

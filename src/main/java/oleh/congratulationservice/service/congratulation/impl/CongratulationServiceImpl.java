package oleh.congratulationservice.service.congratulation.impl;

import oleh.congratulationservice.bo.CongratulationBO;
import oleh.congratulationservice.bo.DateBO;
import oleh.congratulationservice.entity.CongratulationEntity;
import oleh.congratulationservice.exception.CongratulationException;
import oleh.congratulationservice.exception.Validation;
import oleh.congratulationservice.mapper.CongratulationMapper;
import oleh.congratulationservice.repository.CongratulationRepository;
import oleh.congratulationservice.service.congratulation.CongratulationService;
import oleh.congratulationservice.service.mail.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CongratulationServiceImpl implements CongratulationService {

    @Autowired
    private CongratulationRepository congratulationRepository;
    @Autowired
    private CongratulationMapper congratulationMapper;
    @Autowired
    private EmailService emailService;

    @Override
    public Integer save(CongratulationBO bo) {
        CongratulationEntity entity = congratulationRepository.save(congratulationMapper.toEntity(bo));
        return entity.getId();
    }

    @Override
    public Validation<Void, CongratulationException> deleteBy(Integer id) {
        Validation<Void, CongratulationException> res = new Validation<>();
        try {
            congratulationRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            res.add(new CongratulationException("Congratulation not found"));
            return res;
        }
        return res;
    }

    @Override
    public Validation<Void, CongratulationException> update(CongratulationBO bo) {
        congratulationRepository.save(congratulationMapper.toEntity(bo));
        return new Validation<>();
    }

    @Override
    public Validation<CongratulationBO, CongratulationException> getBy(Integer id) {
        Validation<CongratulationBO, CongratulationException> resp = new Validation<>();
        Optional<CongratulationEntity> res = congratulationRepository.findById(id);
        if(res.isEmpty()){
            resp.add(new CongratulationException("Congratulation not found"));
            return resp;
        }
        resp.setData(congratulationMapper.toBO(res.get()));
        return resp;
    }

    @Override
    public void sendUrgentMsg(String email, String message) {
        emailService.sendSimpleMessage(email, message);
    }

    @Override
    public void distribution(DateBO dateBO) {
        List<CongratulationEntity> entities = congratulationRepository.findAll();
        if (entities.size() == 0)
            return;
        Date date = congratulationMapper.toSqlDate(dateBO);
        for (int i = 0; i < entities.size(); i++){
            CongratulationEntity entity = entities.get(i);
            if (
                    date.getDay() == entity.getDate().getDay() &&
                    date.getMonth() == entity.getDate().getMonth() &&
                    date.getYear() == entity.getDate().getYear()
            ){
                emailService.sendSimpleMessage(entity.getEmail(), entity.getMsg());
                //congratulationRepository.delete(entity);
                congratulationRepository.deleteById(entity.getId());
            }
        }
    }

    @PostConstruct
    public void after(){
        CongratulationBO bo = new CongratulationBO();
        bo.setEmail("movaba8348@brosj.net");
        bo.setMessage("Happy Birthday!");
        bo.setDate(DateBO.builder()
                .day(16)
                .month(8)
                .year(2020)
                .build());
        save(bo);
    }
}

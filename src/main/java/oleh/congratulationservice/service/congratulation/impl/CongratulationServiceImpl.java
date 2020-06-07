package oleh.congratulationservice.service.congratulation.impl;

import oleh.congratulationservice.bo.CongratulationBO;
import oleh.congratulationservice.entity.CongratulationEntity;
import oleh.congratulationservice.exception.CongratulationException;
import oleh.congratulationservice.exception.Validation;
import oleh.congratulationservice.mapper.CongratulationMapper;
import oleh.congratulationservice.repository.CongratulationRepository;
import oleh.congratulationservice.service.congratulation.CongratulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CongratulationServiceImpl implements CongratulationService {

    @Autowired
    private CongratulationRepository congratulationRepository;
    @Autowired
    private CongratulationMapper congratulationMapper;

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
}

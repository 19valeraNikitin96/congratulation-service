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
}

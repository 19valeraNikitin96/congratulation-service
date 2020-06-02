package oleh.congratulationservice.service.congratulation;

import oleh.congratulationservice.bo.CongratulationBO;
import oleh.congratulationservice.exception.CongratulationException;
import oleh.congratulationservice.exception.Validation;

public interface CongratulationService {

    Integer save(CongratulationBO bo);

    Validation<Void, CongratulationException> deleteBy(Integer id);

}

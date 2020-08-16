package oleh.congratulationservice.service.congratulation;

import oleh.congratulationservice.bo.CongratulationBO;
import oleh.congratulationservice.bo.DateBO;
import oleh.congratulationservice.exception.CongratulationException;
import oleh.congratulationservice.exception.Validation;

public interface CongratulationService {

    Integer save(CongratulationBO bo);

    Validation<Void, CongratulationException> deleteBy(Integer id);

    Validation<Void, CongratulationException> update(CongratulationBO bo);

    Validation<CongratulationBO, CongratulationException> getBy(Integer id);

    void sendUrgentMsg(String email, String message);

    void distribution(DateBO toBO);
}

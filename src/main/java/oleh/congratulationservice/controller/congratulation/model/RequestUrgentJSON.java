package oleh.congratulationservice.controller.congratulation.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class RequestUrgentJSON {
    private String email;
    private String message;
}

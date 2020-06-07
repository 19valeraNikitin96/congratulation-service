package oleh.congratulationservice.controller.congratulation.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CongratulationJSON {
    private Integer id;
    private String email;
    private String message;
    private DateJSON date;
}

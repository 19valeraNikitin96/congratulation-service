package oleh.congratulationservice.controller.congratulation.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class RequestJSON {
    private String email;
    private String message;
    private DateJSON date;
}

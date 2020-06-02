package oleh.congratulationservice.bo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CongratulationBO {
    private Integer id;
    private String email;
    private String message;
    private DateBO date;
}

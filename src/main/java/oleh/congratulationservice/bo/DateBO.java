package oleh.congratulationservice.bo;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class DateBO {
    private Integer day;
    private Integer month;
    private Integer year;
}

package oleh.congratulationservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "congratulations")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CongratulationEntity {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "email")
    private String email;

    @Column(name = "msg")
    private String msg;

    @Column(name = "date")
    private Date date;
}

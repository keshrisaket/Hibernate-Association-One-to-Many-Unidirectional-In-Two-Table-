package beans;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    @Column(name = "Employee_Name",nullable = false,length = 50)
    private String name;

    @Column(name = "Employee_Addr",nullable = false,length = 50)
    private String addr;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "Emp_Ref")
    private List<PhoneNumber> phoneNumber;


}

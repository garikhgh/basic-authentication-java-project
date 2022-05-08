package am.hgh.basicauthentication.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer_date")
public class CustomerEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customerName;

    @OneToMany(mappedBy = "customerEntity", targetEntity = CarEntity.class, cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JsonManagedReference
    private List<CarEntity> customerCar;

    @OneToOne
    @JoinColumn(name = "cusomer_details_id")
    private CustomerDetailsEntity customerDetailsEntity;
}

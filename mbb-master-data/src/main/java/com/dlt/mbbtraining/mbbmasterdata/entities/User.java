package com.dlt.mbbtraining.mbbmasterdata.entities;

import com.dlt.mbbtraining.mbbmasterdata.entities.base.MasterEntity;
import com.dlt.mbbtraining.mbbmasterdata.utils.enums.IdType;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Amir on 12/4/2019 12:48 PM
 */

@Builder
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USER")
public class User extends MasterEntity {

    private static final long serialVersionUID = -2815835906596478669L;

    @Column(name = "first_name", length = 64)
    private String firstName;

    @Column(name = "middle_name", length = 64)
    private String middleName;

    @Column(name = "last_name", length = 64)
    private String lastName;

    @Column(name = "age", length = 3)
    private Integer age;

    @Column(name = "id_type", length = 10)
    private IdType idType;

    @Column(name = "id_no", length = 15)
    private String idNo;

    @OneToMany(targetEntity = Address.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private Set<Address> address = new HashSet<>();


}

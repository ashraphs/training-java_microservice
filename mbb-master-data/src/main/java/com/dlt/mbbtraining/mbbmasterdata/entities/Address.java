package com.dlt.mbbtraining.mbbmasterdata.entities;

import com.dlt.mbbtraining.mbbmasterdata.entities.base.MasterEntity;
import com.dlt.mbbtraining.mbbmasterdata.utils.enums.AddressType;
import lombok.*;

import javax.persistence.*;

/**
 * Created by Amir on 12/4/2019 12:48 PM
 */

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "ADDRESS")
public class Address extends MasterEntity {

    private static final long serialVersionUID = -2815835906596478669L;

    @Column(name = "address_1", length = 100)
    private String address1;

    @Column(name = "address_2", length = 100)
    private String address2;

    @Column(name = "postal_code", length = 10)
    private String postalCode;

    @Column(name = "district", length = 15)
    private String district;

    @Column(name = "state", length = 15)
    private String state;

    @Column(name = "address_type", length = 10)
    private AddressType addressType;

}

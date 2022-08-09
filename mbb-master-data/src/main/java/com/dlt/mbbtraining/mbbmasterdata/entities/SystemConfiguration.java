package com.dlt.mbbtraining.mbbmasterdata.entities;

import com.dlt.mbbtraining.mbbmasterdata.entities.base.MasterEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 * Created by AmirBahar on 12/4/2019 11:28 AM
 */

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "SYSTEM_CONFIGURATIONS")
public class SystemConfiguration extends MasterEntity {

    private static final long serialVersionUID = 4732366004076689893L;

    @Size(max = 64)
    @Column(name = "name")
    private String name;

    @Size(max = 32)
    @Column(name = "type")
    private String type;

    @Size(max = 64)
    @Column(name = "value")
    private String value;

}

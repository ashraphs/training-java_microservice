package com.dlt.mbbtraining.mbbmasterdata.entities;

import com.dlt.mbbtraining.mbbmasterdata.entities.base.MasterEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 * Created by Amir on 12/4/2019 12:48 PM
 */

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "CRONS")
public class Cron extends MasterEntity {

    private static final long serialVersionUID = -2815835906596478669L;

    @Size(max = 64)
    @Column(name = "name")
    private String name;

    @Size(max = 64)
    @Column(name = "value")
    private String value;

    @Size(max = 128)
    @Column(name = "description")
    private String description;

    @Size(max = 25)
    @Column(name = "timezone")
    private String timeZone;


}

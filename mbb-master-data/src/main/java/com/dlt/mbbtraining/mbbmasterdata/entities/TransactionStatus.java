package com.dlt.mbbtraining.mbbmasterdata.entities;

import com.dlt.mbbtraining.mbbmasterdata.entities.base.MasterEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 * Created by Amir on 12/4/2019 12:48 PM
 */

//@RedisHash("TRANSACTION_STATUS")
@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "TRANSACTION_STATUS")
public class TransactionStatus extends MasterEntity {

    private static final long serialVersionUID = -2815835906596478669L;

    @Column(name = "code",length = 3)
    private String code;

    @Column(name = "value",length = 25)
    private String value;

}

package com.dlt.mbbtraining.mbbmasterdata.entities.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * AuditEntity entity which should be extends for all entity
 * <p>
 * Created by amir on 29/06/2018.
 */
@Data
@EqualsAndHashCode(callSuper = false)
@MappedSuperclass
public abstract class MasterEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 3014033880246198593L;

    @JsonIgnore
    @Column(name = "deleted", nullable = false)
    private Boolean deleted = false;

    @Column(name = "active", nullable = false)
    private Boolean active = true;

    @Version
    @Column(name = "version", nullable = false)
    private Integer version = 0;

    @Column(name = "restricted", nullable = false)
    private Boolean restricted = false;

    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "last_modified_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Column(name = "last_modified_by")
    private String lastModifiedBy;

    @PrePersist
    void onCreate() {
        this.setCreatedDate(new Date());
        this.setLastModifiedDate(new Date());
    }

    @PreUpdate
    void onUpdate() {
        this.setLastModifiedDate(new Date());
    }
}

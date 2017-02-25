package com.restaurant.dto;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Martha on 2/24/2017.
 */
@Immutable
@Entity
@Table(name = "role")
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL, region = "role")
public class Role implements Serializable {

    // region Fields
    private Integer id;
    private String role;
    private String number;
    // endregion

    // region Constructurs
    protected Role() {
    }

    public Role(String role,
                String number) {
        this.role = role;
        this.number = number;
    }
    // endregion

    // region Properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_role")
    public Integer getId() {
        return id;
    }

    @Column(name = "role",
            unique = true,
            nullable = false)
    public String getRole() {
        return role;
    }

    @Column(name = "business_key",
            unique = true,
            nullable=false,
            updatable=false)
    public String getNumber() {
        return number;
    }
    // endregion

    // region Setters

    private void setId(Integer id) {
        this.id = id;
    }

    private void setRole(String role) {
        this.role = role;
    }

    private void setNumber(String number) {
        this.number = number;
    }

    // endregion

    // region Hashcode/equals overrides
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if ( !(other instanceof Role) ) return false;

        final Role order = (Role) other;

        if (!order.getNumber().equals(getNumber())) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getNumber() != null ? getNumber().hashCode() : 0);
        return result;
    }
    // endregion
}
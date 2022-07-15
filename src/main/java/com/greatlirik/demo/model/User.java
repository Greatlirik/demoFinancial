package com.greatlirik.demo.model;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * User entity
 *
 * @author Zhuk Kirill
 * @version 1.0
 */
@Entity
@Table(name = "account")
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class User {

    /**
     * Field id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * Field name
     */
    @NotBlank
    @Column(name = "name", nullable = false)
    private String name;

    /**
     * Field password
     */
    @NotBlank
    @Column(name = "password", nullable = false)
    private String password;
    /**
     * Field active
     */
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Column(name = "active")
    private boolean active;

    /**
     * Field roles
     */
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(
            name = "account_role",
            joinColumns = {
                    @JoinColumn(name = "account_id", nullable = false)
            }
    )
    @Column(name = "role_id", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private List<Role> roles;


    /**
     * Field records
     */
    @ToString.Exclude
    @ManyToMany(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH,
            CascadeType.PERSIST})
    @JoinTable(name = "account_record",
            joinColumns = @JoinColumn(name = "account_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "record_id", referencedColumnName = "id")
    )
    private List<Record> records;
}

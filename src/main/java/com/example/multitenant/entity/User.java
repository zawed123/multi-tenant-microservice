package com.example.multitenant.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;


import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class User implements Serializable {
    private static final long serialVersionUID = -4551953276601557391L;
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String department;
    private String email;
    private String forename;
    @LastModifiedDate
    private Instant lastModifiedDate=Instant.now();
    private String familyName;
    private String password;
    private String phone;
    private String profileFileType;
    private String notificationPreference;
    private String username;
    @CreatedDate
    private Instant createdDate=Instant.now();

    @Column(name = "tenant_id")
    private String tenantId;
}

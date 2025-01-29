package com.wellsfargo.counselor.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private Long clientId;
    
    @ManyToOne
    @JoinColumn(name = "advisor_id", nullable = false)  // Foreign Key
    private Advisor advisor;
    
    @Column(nullable = false)
    private String firstName;
    
    @Column(nullable = false)
    private String lastName;
    
    @Column(nullable = false)
    private String address;
    
    @Column(nullable = false)
    private String phone;
    
    @Column(nullable = false, unique = true)
    private String email;
    
    // One Client has One Portfolio
    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private Portfolio portfolio;
}

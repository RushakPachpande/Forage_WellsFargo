package com.wellsfargo.counselor.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Portfolio {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long portfolioId;
    
    @OneToOne
    @JoinColumn(name = "client_id", nullable = false, unique = true)  // Foreign Key
    private Client client;
    
    @Temporal(TemporalType.DATE)
    private Date creationDate;
    
    // One Portfolio has Many Securities
    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Securities> securities;
}

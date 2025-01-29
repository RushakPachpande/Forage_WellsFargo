package com.wellsfargo.counselor.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Securities {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long securityId;
    
    @ManyToOne
    @JoinColumn(name = "portfolio_id", nullable = false)  // Foreign Key
    private Portfolio portfolio;
    
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false)
    private String category;
    
    @Temporal(TemporalType.DATE)
    private Date purchaseDate;
    
    @Column(nullable = false)
    private double purchasePrice;
    
    @Column(nullable = false)
    private int quantity;
}

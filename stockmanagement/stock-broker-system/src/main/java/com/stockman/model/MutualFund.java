package com.stockman.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "mutual_funds")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MutualFund {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mutual_fund_id")
    private Integer mutualFundId;

    @Column(name = "mutual_fund_name")
    private String mutualFundName;

    @Column(name = "current_price")
    private double currentPrice;

    @Column(name = "total_quantity")
    private Integer totalQuantity;

    @Column(name = "available_quantity")
    private Integer availableQuantity;

    @Column(name = "is_active")
    private boolean isActive = true;

    
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    
    
    @OneToMany(mappedBy = "mutualFund", cascade = CascadeType.ALL)
    private List<Transaction> transactions = new ArrayList<>();
    
    // getters and setters
}


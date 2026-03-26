package com.wellsfargo.counselor.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Portfolio {

    @Id
    @GeneratedValue()
    private long portfolioId;

    @ManyToOne
    @JoinColumn(name = "clientId", nullable = false)
    private Client client;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Date createdDate;

    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL)
    private List<Security> securities;

    protected Portfolio() {}

    public Portfolio(Client client, String name, Date createdDate) {
        this.client = client;
        this.name = name;
        this.createdDate = createdDate;
    }

    public long getPortfolioId() { return portfolioId; }
    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Date getCreatedDate() { return createdDate; }
    public void setCreatedDate(Date createdDate) { this.createdDate = createdDate; }
    public List<Security> getSecurities() { return securities; }
    public void setSecurities(List<Security> securities) { this.securities = securities; }
}
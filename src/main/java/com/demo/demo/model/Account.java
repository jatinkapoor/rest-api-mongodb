package com.demo.demo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "account")
public class Account {

    @Id
    private String id;

    private Double strike;

    private Date maturity;

    private Date tradeDate;

    private String underlying;

    private String currency;
}

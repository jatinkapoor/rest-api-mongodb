package com.demo.demo.domain.request;


import lombok.Data;

import java.util.Date;

@Data
public class AccountRequest {

    private Double strike;

    private Date maturity;

    private Date tradeDate;

    private String underlying;

    private String currency;
}

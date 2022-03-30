package com.Ecommerce.entityDto;

import com.Ecommerce.entities.User;

import javax.persistence.MapsId;
import javax.persistence.OneToOne;

public class SellerDto {
    private Long sellerId;
    private String gst;
    private Long companyContact;
    private String companyName;

    @OneToOne
    @MapsId//Maps primary key of both the tables
    private User user;
}

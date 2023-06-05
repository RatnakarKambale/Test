package com.csi.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private long productId;

    private String productName;

    private double productPrice;

    @JsonFormat(pattern = "dd-mm-yyyy",timezone = "Asia/Kolkata")
    private Date productLaunchDate;

}

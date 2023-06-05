package com.csi.vo;

import com.csi.model.Enquiry;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestTemplateVO {
    private long enquiryId;
    private Date enquiryDate;
    private String enquiryDescription;
    private String enquiryStatus;

    private Product product;

    private User user;
}

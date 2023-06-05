package com.csi.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User{

    @Id
    private long userId;

    private String userName;

    private String userEmailId;

    private String userAddress;

    private long userContactNumber;

}

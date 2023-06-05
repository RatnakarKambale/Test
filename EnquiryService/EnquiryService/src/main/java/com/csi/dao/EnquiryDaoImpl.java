package com.csi.dao;

import com.csi.model.Enquiry;
import com.csi.repo.EnquiryRepo;
import com.csi.vo.Product;
import com.csi.vo.RestTemplateVO;
import com.csi.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class EnquiryDaoImpl {

    @Autowired
    EnquiryRepo enquiryRepoImpl;

    @Autowired
    RestTemplate restTemplate;


    public Enquiry saveData(Enquiry enquiry) {

        return enquiryRepoImpl.save(enquiry);
    }

    public List<RestTemplateVO> getAllData() {
        List<RestTemplateVO> restTemplateVOS = new ArrayList<>();
        List<Enquiry> voobj = enquiryRepoImpl.findAll();

        voobj.forEach(fan -> {
            Product product = restTemplate.getForObject("http://ProductService/Product/getDataByProductID/" + fan.getProductId(), Product.class);
            User user = restTemplate.getForObject("http://UserService/User/" + fan.getUserId(), User.class);
            RestTemplateVO restTemplateVO = new RestTemplateVO(fan.getEnquiryId(), fan.getEnquiryDate(), fan.getEnquiryDescription(), fan.getEnquiryStatus(), product, user);
            restTemplateVOS.add(restTemplateVO);
        });
        return restTemplateVOS;
    }

    public RestTemplateVO getDataById(long enquiryId) {

        Optional<Enquiry> enquiry = enquiryRepoImpl.findById(enquiryId);
        Product product = restTemplate.getForObject("http://ProductService/Product" + enquiry.get().getProductId(), Product.class);
        User user = restTemplate.getForObject("http://UserService/User" + enquiry.get().getUserId(), User.class);

        RestTemplateVO restTemplateVO = new RestTemplateVO(enquiry.get().getEnquiryId(), enquiry.get().getEnquiryDate(),
                enquiry.get().getEnquiryDescription(), enquiry.get().getEnquiryStatus(), product, user);
        return restTemplateVO;
    }

    public Enquiry updateData(Enquiry enquiry) {

        return enquiryRepoImpl.save(enquiry);
    }

    public List<Enquiry> getEnquiryBySatus(String enquirySatus) {
        List<Enquiry> enquiryList = enquiryRepoImpl.findAll();
        return enquiryList.stream().filter(enq -> enq.getEnquiryStatus().equals(enquirySatus)).collect(Collectors.toList());
    }

    public List<RestTemplateVO> getDataByProductId(long productId) {
        List<RestTemplateVO> restTemplateVOS = new ArrayList<>();

        List<Enquiry> enquiryList = enquiryRepoImpl.findAll();

        enquiryList.stream().filter(enquiry -> enquiry.getProductId() == productId).collect(Collectors.toList())
                .forEach(enquiry -> {
                    Product product = restTemplate.getForObject("http://ProductService/Product" + enquiry.getProductId(), Product.class);
                    User user = restTemplate.getForObject("http://UserService/User" + enquiry.getUserId(), User.class);
                    RestTemplateVO restTemplateVO = new RestTemplateVO(enquiry.getEnquiryId(), enquiry.getEnquiryDate(),
                            enquiry.getEnquiryDescription(), enquiry.getEnquiryStatus(), product, user);
                    restTemplateVOS.add(restTemplateVO);
                });

        return restTemplateVOS;
    }



    public List<Enquiry> sortByDateAsc() {

        return enquiryRepoImpl.findAll().stream().sorted(Comparator.comparing(Enquiry::getEnquiryDate)).collect(Collectors.toList());
    }

    public List<Enquiry> sortByDateDesc() {
        return enquiryRepoImpl.findAll().stream().sorted(Comparator.comparing(Enquiry::getEnquiryDate).reversed()).collect(Collectors.toList());
    }

    public List<Enquiry> filterDataByDate(String startDate) throws ParseException {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

        Date sDate= simpleDateFormat.parse(startDate);

        return enquiryRepoImpl.findAll().stream().filter(enq-> enq.getEnquiryDate().compareTo(sDate)>=0).collect(Collectors.toList());
    }
}

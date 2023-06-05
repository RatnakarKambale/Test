package com.csi.service;

import com.csi.dao.EnquiryDaoImpl;
import com.csi.model.Enquiry;
import com.csi.vo.RestTemplateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

@Service
public class EnquiryServiceImpl {

    @Autowired
    EnquiryDaoImpl enquiryDaoImpl;


    public Enquiry saveData(Enquiry enquiry) {

        return enquiryDaoImpl.saveData(enquiry);
    }

    public List<RestTemplateVO> getAllData() {
        return enquiryDaoImpl.getAllData();
    }

    public RestTemplateVO getDataById(long enquiryId) {
        return enquiryDaoImpl.getDataById(enquiryId);
    }

    public Enquiry updateData(Enquiry enquiry) {
        return enquiryDaoImpl.updateData(enquiry);

    }

    public List<Enquiry> getEnquiryBySatus(String enquirySatus) {
        return enquiryDaoImpl.getEnquiryBySatus(enquirySatus);
    }

    public List<RestTemplateVO> getDataByProductId(long productId) {
        return enquiryDaoImpl.getDataByProductId(productId);
    }

    public List<Enquiry> sortByDateAsc() {
        return enquiryDaoImpl.sortByDateAsc();
    }

    public List<Enquiry> sortByDateDesc() {
        return enquiryDaoImpl.sortByDateDesc();
    }

    public List<Enquiry> filterDataByDate(String startDate) throws ParseException {
        return  enquiryDaoImpl.filterDataByDate(startDate);
    }
}

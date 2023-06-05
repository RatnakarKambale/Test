package com.csi.controller;

import com.csi.model.Enquiry;
import com.csi.service.EnquiryServiceImpl;
import com.csi.vo.RestTemplateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/enquiry")
public class EnquiryController {

    @Autowired
    EnquiryServiceImpl enquiryServiceImpl;

    @PostMapping("/")
    public ResponseEntity<Enquiry> saveData(@RequestBody Enquiry enquiry) {

        return ResponseEntity.ok(enquiryServiceImpl.saveData(enquiry));
    }

    @GetMapping("/getAllData")
    public ResponseEntity<List<RestTemplateVO>> getAllData() {
        return ResponseEntity.ok(enquiryServiceImpl.getAllData());
    }

    @GetMapping("/getDataById {enquiryId}")
    public ResponseEntity<RestTemplateVO> getDataById(@PathVariable long enquiryId) {
        return ResponseEntity.ok(enquiryServiceImpl.getDataById(enquiryId));
    }

    @PutMapping("/updateData/{enquiryId}")
    public ResponseEntity<Enquiry> updateData(@PathVariable int enquiryId, @RequestBody Enquiry enquiry) {
        return ResponseEntity.ok(enquiryServiceImpl.updateData(enquiry));
    }

    @GetMapping("/getDataByStatus/{enquirySatus}")
    public ResponseEntity<List<Enquiry>> getEnquiryBySatus(@PathVariable String enquirySatus) {
        return ResponseEntity.ok(enquiryServiceImpl.getEnquiryBySatus(enquirySatus));
    }

    @GetMapping("/getDataByProductId/{productId}")
    public ResponseEntity<List<RestTemplateVO>> getDataByProductId(@PathVariable long productId) {
        return ResponseEntity.ok(enquiryServiceImpl.getDataByProductId(productId));
    }

    @GetMapping("/sortByDateAsc")
    public ResponseEntity<List<Enquiry>> sortByDateAsc() {
        return ResponseEntity.ok(enquiryServiceImpl.sortByDateAsc());
    }

    @GetMapping("/sortByDateDesc")
    public ResponseEntity<List<Enquiry>> sortByDateDesc() {
        return ResponseEntity.ok(enquiryServiceImpl.sortByDateDesc());
    }

    @GetMapping("/filterDataByDate/{startDate}")
    public ResponseEntity<List<Enquiry>> filterDataByDate(@PathVariable String startDate) throws ParseException {
        return ResponseEntity.ok(enquiryServiceImpl.filterDataByDate(startDate));
    }

}

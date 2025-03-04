package com.technica_studio.product_service.controller;

import com.technica_studio.product_service.model.Summary;
import com.technica_studio.product_service.service.SummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SummaryController {

    @Autowired
    SummaryService summaryService;

    @GetMapping(value = "/summary")
    public ResponseEntity<Summary> getSummary() {
        Summary summary = summaryService.getSummary();
        return new ResponseEntity<>(summary, HttpStatus.OK);
    }

    @PostMapping(value = "/summary")
    public ResponseEntity<Summary> insertSummary() {
        Summary summary = summaryService.insertSummary();
        return new ResponseEntity<>(summary, HttpStatus.OK);
    }

    @PutMapping(value = "/summary")
    public ResponseEntity<Summary> updateSummary() {
        Summary summary = summaryService.updateSummary();
        return new ResponseEntity<>(summary, HttpStatus.OK);
    }

    @DeleteMapping(value = "/summary")
    public ResponseEntity<Summary> removeSummary() {
        Summary summary = summaryService.removeSummary();
        return new ResponseEntity<>(summary, HttpStatus.OK);
    }
}

package com.dubaicustoms.umsservice.controller;

import com.dubaicustoms.umsservice.domain.ums.UmsDetails;
import com.dubaicustoms.umsservice.exception.UmsException;
import com.dubaicustoms.umsservice.service.IUmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UmsController {

    @Autowired
    private IUmsService umsService;


    @GetMapping("ums-info")
    ResponseEntity<UmsDetails> getUmsInfo() throws UmsException {
        return umsService.getUmsInfo();
    }

}

package com.dubaicustoms.umsservice.service;

import com.dubaicustoms.umsservice.domain.ums.UmsDetails;
import com.dubaicustoms.umsservice.exception.UmsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UmsService implements IUmsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UmsService.class);

    @Override
    public ResponseEntity<UmsDetails> getUmsInfo() throws UmsException {
        try {
            UmsDetails umsDetails = new UmsDetails();
            umsDetails.setFullName("Test User");
            umsDetails.setUsername("testUser");
            umsDetails.setEmail("user@gmail.com");
            umsDetails.setActive(true);
            umsDetails.setCreatedAt(LocalDateTime.now());
            return new ResponseEntity<>(umsDetails, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("class ={} method={} errorMessage={}", this.getClass(), "getUmsInfo", e.getMessage());
            throw new UmsException("Ums User not found!", HttpStatus.NOT_FOUND);
        }
    }

}

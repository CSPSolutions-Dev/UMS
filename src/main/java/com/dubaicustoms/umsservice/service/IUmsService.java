package com.dubaicustoms.umsservice.service;

import com.dubaicustoms.umsservice.domain.ums.UmsDetails;
import com.dubaicustoms.umsservice.exception.UmsException;
import org.springframework.http.ResponseEntity;

public interface IUmsService {

    ResponseEntity<UmsDetails> getUmsInfo() throws UmsException;
}

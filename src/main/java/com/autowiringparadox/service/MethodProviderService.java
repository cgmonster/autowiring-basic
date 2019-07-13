package com.autowiringparadox.service;

import com.autowiringparadox.dto.Data;
import org.springframework.stereotype.Component;

@Component("method")
public class MethodProviderService {
    public double power(Data data){
        return Math.pow(data.getNumber(), data.getPower());
    }
}

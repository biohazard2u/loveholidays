package com.loveholidays.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loveholidays.test.dto.StreetAddress;
import com.loveholidays.test.serviceidealpostcodes.api.ExternalApiable;

@Service
public class PostcodeService {
	
	@Autowired
	ExternalApiable externalApi;
	
	public StreetAddress findStreetAddress(String postcode) {
		return new StreetAddress(externalApi.getAddressFromPostcode(postcode));
	}
}

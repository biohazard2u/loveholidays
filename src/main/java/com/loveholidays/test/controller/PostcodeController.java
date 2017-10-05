package com.loveholidays.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.loveholidays.test.dto.StreetAddress;
import com.loveholidays.test.service.PostcodeService;

@RestController
@RequestMapping("postcode")
public class PostcodeController {

	@Autowired
	PostcodeService postcodeService; // This could be an interface.

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StreetAddress> checkout(@RequestParam(required = false) String postcode) {

		StreetAddress output = postcodeService.findStreetAddress(postcode);
		return new ResponseEntity<>(output, HttpStatus.OK);
	}
}

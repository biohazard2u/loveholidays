package com.loveholidays.test.dto;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(description = "Street address")
public class StreetAddress extends ResourceSupport{

	@ApiModelProperty(value = "Name / Street address")
	@JsonProperty("address")
	String address;
	
	public StreetAddress() {} 
	
	public StreetAddress(String address) {
		this.address = address;
	}
}

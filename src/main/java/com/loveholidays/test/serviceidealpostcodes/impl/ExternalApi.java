package com.loveholidays.test.serviceidealpostcodes.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.loveholidays.test.serviceidealpostcodes.api.ExternalApiable;

@Component
public class ExternalApi implements ExternalApiable {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExternalApi.class);

	private static final String URL_PREFIX = "https://api.ideal-postcodes.co.uk/v1/postcodes/";
	private static final String URL_POSTFIX = "?api_key=iddqd";

	@Override
	public String getAddressFromPostcode(String postcode) {
		String address = "";

		try {
			HttpURLConnection conn = getConnection(postcode);
			checkConnection(conn);
			String rawData = getRawData(address, conn);
			address = parseRawData(rawData);
			conn.disconnect();
		} catch (Exception e) {
			LOGGER.error("Connection error ", e);
		}
		return address;
	}

	private HttpURLConnection getConnection(String postcode)
			throws MalformedURLException, IOException, ProtocolException {
		URL url = new URL(URL_PREFIX + postcode + URL_POSTFIX);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");
		return conn;
	}

	private void checkConnection(HttpURLConnection conn) throws IOException {
		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
		}
	}

	private String getRawData(String address, HttpURLConnection conn) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
		String output;
		while ((output = br.readLine()) != null) {
			address += output;
		}
		LOGGER.debug("raw data: " + address);
		return address;
	}

	private String parseRawData(String rawData) {

		Pattern p = Pattern.compile("line_3\":(.*?),");
		Matcher m = p.matcher(rawData);
		String theGroup = null;
		if (m.find()) {
			theGroup = m.group(1);
		}
		return theGroup.substring(1, theGroup.length() - 1);
	}
}
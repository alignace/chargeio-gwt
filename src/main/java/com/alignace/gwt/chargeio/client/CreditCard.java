package com.alignace.gwt.chargeio.client;

import com.alignace.gwt.chargeio.client.model.Card;
import com.google.gwt.core.client.Callback;

public class CreditCard {

	private static native String createTokenJNI(Card cardInfo,
			Callback<String, Exception> callback) /*-{
		ChargeIO.create_token({
			type : 'card',
			number : cardInfo.getNumber(),
			exp_month : cardInfo.getExpMonth(),
			exp_year : cardInfo.getExpYear(),
			cvv : cardInfo.getCvv(),
			name : cardInfo.getName(),
			address1 : cardInfo.getAddress1(),
			address2 : cardInfo.getAddress2(),
			phone : cardInfo.getPhone(),
			city : cardInfo.getCity(),
			state : cardInfo.getState(),
			postal_code : cardInfo.getPostalCode(),
			country : cardInfo.getCountry()
		}, callback);
	}-*/;

	public void createToken(Card cardInfo,
			final Callback<String, Exception> callback) {

	}
}

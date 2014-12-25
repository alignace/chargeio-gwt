/**
 * Copyright 2014 Alignace LLC.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.alignace.gwt.chargeio.client;

import com.alignace.gwt.chargeio.client.card.CreditCardResponseHandler;
import com.alignace.gwt.chargeio.client.card.model.CreditCard;
import com.google.gwt.core.client.Callback;
import com.google.gwt.core.client.ScriptInjector;

public class ChargeIOImpl implements ChargeIO {

	private static final String CHARGEIO_JAVASCRIPT_URL = "https://api.chargeio.com/assets/api/v1/chargeio.min.js";

	@Override
	public void inject(final Callback<Void, Exception> callback) {
		if (!isInjected()) {
			ScriptInjector.fromUrl(CHARGEIO_JAVASCRIPT_URL)
					.setWindow(ScriptInjector.TOP_WINDOW)
					.setCallback(new Callback<Void, Exception>() {
						@Override
						public void onFailure(Exception reason) {
							callback.onFailure(reason);
						}

						@Override
						public void onSuccess(Void result) {
							callback.onSuccess(result);
						}
					}).inject();
		}

	}

	@Override
	public native boolean isInjected() /*-{
		return typeof $wnd.ChargeIO !== "undefined";
	}-*/;

	@Override
	public void getCreditCardToken(CreditCard creditCard,
			CreditCardResponseHandler creditCardResponseHandler) {

		getCreditCardToken(creditCard.getNumber(), creditCard.getCvv(),
				creditCard.getExpMonth(), creditCard.getExpYear(),
				creditCard.getName(), creditCard.getAddress1(),
				creditCard.getAddress2(), creditCard.getPhone(),
				creditCard.getCity(), creditCard.getState(),
				creditCard.getPostalCode(), creditCard.getCountry(),
				creditCardResponseHandler);

	}

	private native void getCreditCardToken(String creditCardNumber, int cvv,
			int expiryMonth, int expiryYear, String name, String addressLine1,
			String addressLine2, String phone, String addressCity,
			String addressState, String addressZip, String addressCountry,
			CreditCardResponseHandler creditCardResponseHandler) /*-{
		var creditCardInfo = {
			type : 'card',
			number : creditCardNumber,
			exp_month : expiryMonth,
			exp_year : expiryYear,
			cvv : cvv,
			name : name,
			address1 : addressLine1,
			address2 : addressLine2,
			phone : phone,
			city : addressCity,
			state : addressState,
			postal_code : addressZip,
			country : addressCountry
		};
		var createTokenCallback = function(response) {
			creditCardResponseHandler.@com.alignace.gwt.chargeio.client.card.CreditCardResponseHandler::onCreditCardReceived(Lcom/alignace/gwt/chargeio/client/card/model/CreditCardResponse;)(response);
		}
		$wnd.ChargeIO.create_token(creditCardInfo, createTokenCallback);
	}-*/;

	@Override
	public native void setPublicKey(String publicKey) /*-{
		$wnd.ChargeIO.init({
			public_key : publicKey
		});
	}-*/;

}

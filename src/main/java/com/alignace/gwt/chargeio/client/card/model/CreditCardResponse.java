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

package com.alignace.gwt.chargeio.client.card.model;

import java.util.Date;

import com.google.gwt.core.client.JavaScriptObject;

public class CreditCardResponse extends JavaScriptObject {

	protected CreditCardResponse() {
	}

	public final native String getId() /*-{
		return this.id;
	}-*/;

	public final native Date getCreated() /*-{
		return this.created;
	}-*/;

	public final native Date getModified() /*-{
		return this.modified;
	}-*/;

	public final native String getType() /*-{
		return this.type;
	}-*/;

	public final native String getNumber() /*-{
		return this.number;
	}-*/;

	public final native int getExpMonth() /*-{
		return this.expMonth;
	}-*/;

	public final native int getExpYear() /*-{
		return this.expYear;
	}-*/;

	public final native int getCvv() /*-{
		return this.cvv;
	}-*/;

	public final native String getName() /*-{
		return this.name;
	}-*/;

	public final native String getAddress1() /*-{
		return this.address1;
	}-*/;

	public final native String getAddress2() /*-{
		return this.address2;
	}-*/;

	public final native String getPhone() /*-{
		return this.phone;
	}-*/;

	public final native String getCity() /*-{
		return this.city;
	}-*/;

	public final native String getState() /*-{
		return this.state;
	}-*/;

	public final native String getPostalCode() /*-{
		return this.postalCode;
	}-*/;

	public final native String getCountry() /*-{
		return this.country;
	}-*/;

}

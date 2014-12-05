package com.alignace.gwt.chargeio.client;

import com.google.gwt.core.client.Callback;
import com.google.gwt.core.client.ScriptInjector;

public class ChargeIO {

	private static final String CHARGEIO_JAVASCRIPT_URL = "https://api.chargeio.com/assets/api/v1/chargeio.min.js";

	/**
	 * Constructor is private just to avoid accidental use without
	 * initialization
	 */
	private ChargeIO() {

	}

	/**
	 * This should always be called first to initialize Google Analytics.
	 * 
	 * @param publicKey
	 *            - Public Key
	 * @param callback
	 */
	public static void initialize(String publicKey,
			Callback<Void, Exception> callback) {
		inject(publicKey, callback);
	}

	/**
	 * Native Method to initialize
	 * 
	 * @param trackingId
	 * @return
	 */
	private static native String initChargeIO(String publicKey) /*-{
		ChargeIO.init({
			public_key : publicKey
		});
	}-*/;

	/**
	 * Injects ChargeIO Javascript
	 * 
	 * @param callback
	 */
	private static void inject(final String publicKey,
			final Callback<Void, Exception> callback) {
		if (!isInjected()) {
			ScriptInjector.fromUrl(CHARGEIO_JAVASCRIPT_URL)
					.setWindow(ScriptInjector.TOP_WINDOW)
					.setCallback(new Callback<Void, Exception>() {
						public void onFailure(Exception reason) {
							callback.onFailure(reason);
						}

						public void onSuccess(Void result) {
							callback.onSuccess(result);
							initChargeIO(publicKey);
						}

					}).inject();
		}
	}

	/**
	 * Checks if ChargeIO JS is already imported
	 * 
	 * @return
	 */
	private static native boolean isInjected() /*-{
		return typeof $wnd.ChargeIO !== "undefined";
	}-*/;

}

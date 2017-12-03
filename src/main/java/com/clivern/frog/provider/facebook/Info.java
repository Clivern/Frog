/*
 * Copyright (C) 2017 A.F <http://clivern.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.clivern.frog.provider.facebook;

import com.clivern.frog.exception.InvalidProviderConfigs;

/**
 * Facebook Info Class
 *
 * @author A.F
 * @since 1.0.0
 */
public class Info {

	public static final String oauthURL = "https://www.facebook.com/v2.11/dialog/oauth";

	/**
	 * Get Oauth URL (Login URL)
	 *
	 * @param  client_id              The ID of your app, found in your app's dashboard.
	 * @param  redirect_uri           The URL that you want to redirect the person logging in back to
	 * @param  state                  An arbitrary unique string created by your app to guard against Cross-site Request Forgery.
	 * @param  response_type          Determines whether the response data included when the redirect back to the app occurs is in URL parameters or fragments
	 * @param  scope                  A comma separated list of Permissions to request from the person using your app.
	 * @return String
	 * @throws InvalidProviderConfigs
	 */
	public static final String getOauthURL(String client_id, String redirect_uri, String state, String response_type, String scope) throws InvalidProviderConfigs
	{
		String url = Info.oauthURL;

        if( client_id.isEmpty() || redirect_uri.isEmpty() || state.isEmpty() ){
            throw new InvalidProviderConfigs("Facebook Oauth URL is Invalid! This may be due to missing Client ID, Redirect URI or State.");
        }

        if( !client_id.isEmpty() ){
            url += "?client_id=" + client_id;
        }

        if( !redirect_uri.isEmpty() ){
            url += "&redirect_uri=" + redirect_uri;
        }

        if( !state.isEmpty() ){
            url += "&state=" + state;
        }

        if( !response_type.isEmpty() ){
            url += "&response_type=" + response_type;
        }

        if( !scope.isEmpty() ){
            url += "&scope=" + scope;
        }

		return url;
	}

	/**
	 * Get Declined Oauth URL (Re-asking for Declined Permissions)
	 *
	 * @param  client_id              The ID of your app, found in your app's dashboard.
	 * @param  redirect_uri           The URL that you want to redirect the person logging in back to
	 * @param  state                  An arbitrary unique string created by your app to guard against Cross-site Request Forgery.
	 * @param  response_type          Determines whether the response data included when the redirect back to the app occurs is in URL parameters or fragments
	 * @param  scope                  A comma separated list of Permissions to request from the person using your app.
	 * @return String
	 * @throws InvalidProviderConfigs
	 */
	public static final String getDeclinedOauthURL(String client_id, String redirect_uri, String state, String response_type, String scope) throws InvalidProviderConfigs
	{
		String url = Info.oauthURL;

        if( client_id.isEmpty() || redirect_uri.isEmpty() || state.isEmpty() ){
            throw new InvalidProviderConfigs("Facebook Oauth URL is Invalid! This may be due to missing Client ID, Redirect URI or State.");
        }

        if( !client_id.isEmpty() ){
            url += "?client_id=" + client_id;
        }

        url += "&auth_type=rerequest";

        if( !redirect_uri.isEmpty() ){
            url += "&redirect_uri=" + redirect_uri;
        }

        if( !state.isEmpty() ){
            url += "&state=" + state;
        }

        if( !response_type.isEmpty() ){
            url += "&response_type=" + response_type;
        }

        if( !scope.isEmpty() ){
            url += "&scope=" + scope;
        }

		return url;
	}
}
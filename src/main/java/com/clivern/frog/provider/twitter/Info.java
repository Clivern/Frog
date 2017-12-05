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
package com.clivern.frog.provider.twitter;

import com.clivern.frog.exception.InvalidProviderConfigs;

/**
 * Twitter Info Class
 *
 * @author A.F
 * @since 1.0.0
 */
public class Info {

	public static final String authenticateURL = "https://api.twitter.com/oauth/authenticate";

	public static final String requestTokenURL = "https://api.twitter.com/oauth/request_token";

	public static final String accessTokenURL = "https://api.twitter.com/oauth/access_token";

	public static final String userDetailsURL = "https://api.twitter.com/1.1/account/verify_credentials.json";


	public static final String getAuthenticateURL(String oauthToken, String forceLogin, String screenName) throws InvalidProviderConfigs
	{
		String url = Info.authenticateURL;

        if( oauthToken.isEmpty() ){
            throw new InvalidProviderConfigs("Twitter Authenticate URL is Invalid! This may be due to missing Oauth Token.");
        }

        if( !oauthToken.isEmpty() ){
            url += "?oauth_token=" + oauthToken;
        }

        if( !forceLogin.isEmpty() ){
            url += "&force_login=" + forceLogin;
        }

        if( !screenName.isEmpty() ){
            url += "&screen_name=" + screenName;
        }

		return url;
	}

	public static final String getRequestTokenURL() throws InvalidProviderConfigs
	{
		String url = Info.requestTokenURL;

		return url;
	}

	public static final String getAccessTokenURL() throws InvalidProviderConfigs
	{
		String url = Info.accessTokenURL;

		return url;
	}

	public static final String getUserDetailsURL() throws InvalidProviderConfigs
	{
		String url = Info.userDetailsURL;

		return url;
	}
}
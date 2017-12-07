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
package com.clivern.frog.provider.linkedin;

import com.clivern.frog.exception.InvalidProviderConfigs;

/**
 * Linkedin Info Class
 *
 * @author A.F
 * @since 1.0.0
 */
public class Info {

    public static final String authenticateURL = "https://www.linkedin.com/oauth/v2/authorization";

    public static final String accessTokenURL = "https://www.linkedin.com/oauth/v2/accessToken";

    /**
     * Get Authentication URL
     *
     * @param  responseType           The value of this field should always be:  code
     * @param  clientId               The "API Key" value generated when you registered your application.
     * @param  redirectUri            The URI your users will be sent back to after authorization.
     * @param  state                  A unique string value of your choice that is hard to guess. Used to prevent CSRF.
     * @param  scope                  A URL-encoded, space delimited list of member permissions your application is requesting on behalf of the user.  If you do not specify a scope in your call, we will fall back to using the default member permissions you defined in your application configuration.
     * @return String
     * @throws InvalidProviderConfigs
     */
    public static final String getAuthenticationURL(String responseType, String clientId, String redirectUri, String state, String scope) throws InvalidProviderConfigs
    {
        String url = Info.authenticateURL;

        if( responseType.isEmpty() || clientId.isEmpty() || redirectUri.isEmpty() || state.isEmpty() ){
            throw new InvalidProviderConfigs("Linkedin Oauth URL is Invalid! This may be due to missing Response Type, Client ID, Redirect URI and State.");
        }

        if( !responseType.isEmpty() ){
            url += "?response_type=" + responseType;
        }

        if( !clientId.isEmpty() ){
            url += "&client_id=" + clientId;
        }

        if( !redirectUri.isEmpty() ){
            url += "&redirect_uri=" + redirectUri;
        }

        if( !state.isEmpty() ){
            url += "&state=" + state;
        }

        if( !scope.isEmpty() ){
            url += "&scope=" + scope;
        }

        return url;
    }

	/**
	 * Get Access Token URL
	 *
	 * @param  grantType              The value of this field should always be:  authorization_code
	 * @param  code                   The authorization code you received from Step 2.
	 * @param  redirectUri            The same 'redirect_uri' value that you passed in the previous step.
	 * @param  clientId               The "API Key" value generated Step 1.
	 * @param  clientSecret           The "Secret Key" value generated in Step 1.
	 * @return String
	 * @throws InvalidProviderConfigs
	 */
    public static final String getAccessTokenURL(String grantType, String code, String redirectUri, String clientId, String clientSecret) throws InvalidProviderConfigs
    {
        String url = Info.accessTokenURL;

        if( grantType.isEmpty() || code.isEmpty() || redirectUri.isEmpty() || clientId.isEmpty() || clientSecret.isEmpty() ){
            throw new InvalidProviderConfigs("Linkedin Access Token URL is Invalid! This may be due to missing Grant Type, Code, Redirect URI, Client ID and Client Secret.");
        }

        if( !grantType.isEmpty() ){
            url += "?grant_type=" + grantType;
        }

        if( !code.isEmpty() ){
            url += "&code=" + code;
        }

        if( !redirectUri.isEmpty() ){
            url += "&redirect_uri=" + redirectUri;
        }

        if( !clientId.isEmpty() ){
            url += "&client_id=" + clientId;
        }

        if( !clientSecret.isEmpty() ){
            url += "&client_secret=" + clientSecret;
        }

        return url;
    }
}
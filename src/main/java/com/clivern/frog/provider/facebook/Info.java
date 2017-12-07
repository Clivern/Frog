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
 * For More Info, Please Check <a href="https://developers.facebook.com/docs/facebook-login/manually-build-a-login-flow">Facebook Manual Login</a>
 *
 * @author A.F
 * @since 1.0.0
 */
public class Info {

    public static final String authenticateURL = "https://www.facebook.com/v2.11/dialog/oauth";

    public static final String accessTokenURL = "https://graph.facebook.com/v2.11/oauth/access_token";

    public static final String inspectAccessTokenURL = "https://graph.facebook.com/debug_token";

    /**
     * Get Oauth URL (Login URL)
     *
     * @param  clientId              The ID of your app, found in your app's dashboard.
     * @param  redirectUri           The URL that you want to redirect the person logging in back to
     * @param  state                  An arbitrary unique string created by your app to guard against Cross-site Request Forgery.
     * @param  responseType          Determines whether the response data included when the redirect back to the app occurs is in URL parameters or fragments
     * @param  scope                  A comma separated list of Permissions to request from the person using your app.
     * @return String
     * @throws InvalidProviderConfigs
     */
    public static final String getAuthenticationURL(String clientId, String redirectUri, String state, String responseType, String scope) throws InvalidProviderConfigs
    {
        String url = Info.authenticateURL;

        if( clientId.isEmpty() || redirectUri.isEmpty() || state.isEmpty() ){
            throw new InvalidProviderConfigs("Facebook Oauth URL is Invalid! This may be due to missing Client ID, Redirect URI or State.");
        }

        if( !clientId.isEmpty() ){
            url += "?client_id=" + clientId;
        }

        if( !redirectUri.isEmpty() ){
            url += "&redirect_uri=" + redirectUri;
        }

        if( !state.isEmpty() ){
            url += "&state=" + state;
        }

        if( !responseType.isEmpty() ){
            url += "&response_type=" + responseType;
        }

        if( !scope.isEmpty() ){
            url += "&scope=" + scope;
        }

        return url;
    }

    /**
     * Get Declined Oauth URL (Re-asking for Declined Permissions)
     *
     * @param  clientId              The ID of your app, found in your app's dashboard.
     * @param  redirectUri           The URL that you want to redirect the person logging in back to
     * @param  state                  An arbitrary unique string created by your app to guard against Cross-site Request Forgery.
     * @param  responseType          Determines whether the response data included when the redirect back to the app occurs is in URL parameters or fragments
     * @param  scope                  A comma separated list of Permissions to request from the person using your app.
     * @return String
     * @throws InvalidProviderConfigs
     */
    public static final String getDeclinedAuthenticationURL(String clientId, String redirectUri, String state, String responseType, String scope) throws InvalidProviderConfigs
    {
        String url = Info.authenticateURL;

        if( clientId.isEmpty() || redirectUri.isEmpty() || state.isEmpty() ){
            throw new InvalidProviderConfigs("Facebook Oauth URL is Invalid! This may be due to missing Client ID, Redirect URI or State.");
        }

        if( !clientId.isEmpty() ){
            url += "?client_id=" + clientId;
        }

        url += "&auth_type=rerequest";

        if( !redirectUri.isEmpty() ){
            url += "&redirect_uri=" + redirectUri;
        }

        if( !state.isEmpty() ){
            url += "&state=" + state;
        }

        if( !responseType.isEmpty() ){
            url += "&response_type=" + responseType;
        }

        if( !scope.isEmpty() ){
            url += "&scope=" + scope;
        }

        return url;
    }

    /**
     * Get Access Token URL
     *
     * @param  clientId               Your app's IDs
     * @param  redirectUri            This argument is required and must be the same as the original request_uri that you used when starting the OAuth login process.
     * @param  clientSecret           Your unique app secret, shown on the App Dashboard.
     * @param  code                   The parameter received from the Login Dialog redirect.
     * @return String
     * @throws InvalidProviderConfigs
     */
    public static final String getAccessTokenURL(String clientId, String redirectUri, String clientSecret, String code) throws InvalidProviderConfigs
    {
        String url = Info.accessTokenURL;

        if( clientId.isEmpty() || redirectUri.isEmpty() || clientSecret.isEmpty() || code.isEmpty() ){
            throw new InvalidProviderConfigs("Facebook Access Token URL is Invalid! This may be due to missing Client ID, Redirect URI, Client Secret or Code.");
        }

        if( !clientId.isEmpty() ){
            url += "?client_id=" + clientId;
        }

        if( !redirectUri.isEmpty() ){
            url += "&redirect_uri=" + redirectUri;
        }

        if( !clientSecret.isEmpty() ){
            url += "&client_secret=" + clientSecret;
        }

        if( !code.isEmpty() ){
            url += "&code=" + code;
        }

        return url;
    }

    /**
     * Inspect Access Token
     *
     * @param  inputToken  The token you need to inspect.
     * @param  accessToken An app access token or an access token for a developer of the app.
     * @return String
     * @throws InvalidProviderConfigs
     */
    public static final String getInspectAccessTokenURL(String inputToken, String accessToken) throws InvalidProviderConfigs
    {
        String url = Info.inspectAccessTokenURL;

        if( inputToken.isEmpty() || accessToken.isEmpty() ){
            throw new InvalidProviderConfigs("Facebook Inspect Access Token URL is Invalid! This may be due to missing Input Token or Access Token.");
        }

        if( !inputToken.isEmpty() ){
            url += "?input_token=" + inputToken;
        }

        if( !accessToken.isEmpty() ){
            url += "&access_token=" + accessToken;
        }

        return url;
    }
}
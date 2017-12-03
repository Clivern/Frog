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
package com.clivern.frog.contract;

import java.util.HashMap;
import java.util.Map;
import com.clivern.frog.util.*;

/**
 * Provider Base Class
 *
 * For More Info About OAuth2, Please Read <a href="https://aaronparecki.com/oauth-2-simplified/">OAuth 2 Simplified</a>
 *
 * @author A.F
 * @since 1.0.0
 */
public abstract class Provider {

    protected final Config config;
    protected final Request request;
    protected Map<String, String> options = new HashMap<String, String>();
    protected Map<String, String> authData = new HashMap<String, String>();
    protected Map<String, String> accessData = new HashMap<String, String>();
    protected Map<String, String> userData = new HashMap<String, String>();

    /**
     * Class Constructor
     */
    public Provider(Config config, Request request, Map<String, String> options)
    {
        this.config = config;
        this.request = request;
        this.options = options;
    }

    /**
     * Get Auth Link
     *
     * @return String
     */
    abstract public String getAuthLink();

    /**
     * Receive Auth Data
     *
     * @param authData
     * @return String
     */
    abstract public Boolean receiveAuthData(Map<String, String> authData);

    /**
     * Exchange Access Token
     *
     * @return String
     */
    abstract public Boolean exchangeAccessToken();

    /**
     * Is Access Token Expired
     *
     * @return String
     */
    abstract public Boolean isAccessTokenExpired();

    /**
     * Refresh Access Token
     *
     * @return String
     */
    abstract public Boolean refreshAccessToken();

    /**
     * Fetch User Data
     *
     * @return String
     */
    abstract public Boolean fetchUserData();

    /**
     * Get Auth Data
     *
     * @return Map<String, String>
     */
    public Map<String, String> getAuthData()
    {
        return this.authData;
    }

    /**
     * Get Access Data
     *
     * @return Map<String, String>
     */
    public Map<String, String> getAccessData()
    {
        return this.accessData;
    }

    /**
     * Get User Data
     *
     * @return Map<String, String>
     */
    public Map<String, String> getUserData()
    {
        return this.userData;
    }
}
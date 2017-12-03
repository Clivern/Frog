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

import java.util.HashMap;
import java.util.Map;
import com.clivern.frog.util.*;
import com.clivern.frog.contract.Provider;
import com.clivern.frog.provider.linkedin.Info;

/**
 * Linkedin Provider Class
 *
 * @author A.F
 * @since 1.0.0
 */
public class Linkedin extends Provider {

    /**
     * Class Constructor
     *
     * @param  config
     * @param  fetcher
     * @param  options
     */
    public Linkedin(Config config, Fetcher fetcher, Map<String, String> options)
    {
        super(config, fetcher, options);
    }

    /**
     * Get Auth Link
     *
     * @return String
     */
    public String getAuthLink()
    {
        return "";
    }

    /**
     * Receive Auth Data
     *
     * @param authData
     * @return String
     */
    public Boolean receiveAuthData(Map<String, String> authData)
    {
        return true;
    }

    /**
     * Exchange Access Token
     *
     * @return String
     */
    public Boolean exchangeAccessToken()
    {
        return true;
    }

    /**
     * Is Access Token Expired
     *
     * @return String
     */
    public Boolean isAccessTokenExpired()
    {
        return true;
    }

    /**
     * Refresh Access Token
     *
     * @return String
     */
    public Boolean refreshAccessToken()
    {
        return true;
    }

    /**
     * Fetch User Data
     *
     * @return String
     */
    public Boolean fetchUserData()
    {
        return true;
    }
}
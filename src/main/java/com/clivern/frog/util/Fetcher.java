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
package com.clivern.frog.util;

import java.util.HashMap;
import java.util.Map;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import com.clivern.frog.contract.FetcherParser;
import com.clivern.frog.util.FetcherData;
import com.clivern.frog.exception.InvalidResponseData;

/**
 * Fetcher Class
 *
 * @author A.F
 * @since 1.0.0
 */
public class Fetcher {

    private OkHttpClient client = new OkHttpClient();
    private FetcherData fetcherData;
    private FetcherParser fetcherParser;
    private String response = "";

    /**
     * Class Constructor
     *
     * @param  fetcherData
     * @param  fetcherParser
     */
    public Fetcher(FetcherData fetcherData, FetcherParser fetcherParser)
    {
        this.fetcherData = fetcherData;
        this.fetcherParser = fetcherParser;
    }

    /**
     * Execute The Fetcher
     *
     * @return Boolean
     */
    public Boolean exec()
    {
        return true;
    }

    /**
     * Get Response
     *
     * @return Map<String, String>
     * @throws InvalidResponseData
     */
    public Map<String, String> getResponse() throws InvalidResponseData
    {
        this.fetcherParser.setResponse(this.response);
        if( this.fetcherParser.parse() ){
            return this.fetcherParser.getParsedData();
        }
        throw new InvalidResponseData("Error Parsing Response Data!");
    }

    @Override
    public String toString()
    {
        String data = "";
        data += (String) this.fetcherData.toString();
        return data;
    }
}
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

/**
 * Fetcher Data Class
 *
 * @author A.F
 * @since 1.0.0
 */
public class FetcherData {

    protected String url;
    protected String method;
    protected String bodyType = "JSON"; // JSON or FORM_DATA
    protected String body;
    protected Map<String, String> headers = new HashMap<String, String>();
    protected Map<String, String> urlParameters = new HashMap<String, String>();
    protected Map<String, String> cookies = new HashMap<String, String>();
    protected Map<String, String> formItems = new HashMap<String, String>();

    /**
     * Set URL
     *
     * @param  url
     * @return FetcherData
     */
    public FetcherData setUrl(String url)
    {
        this.url = url;

        return this;
    }

    /**
     * Set Method
     *
     * @param  method
     * @return FetcherData
     */
    public FetcherData setMethod(String method)
    {
        this.method = method;

        return this;
    }

    /**
     * Set Body Type
     *
     * @param  bodyType
     * @return FetcherData
     */
    public FetcherData setBodyType(String bodyType)
    {
        this.bodyType = bodyType;

        return this;
    }

    /**
     * Set Body
     *
     * @param  body
     * @return FetcherData
     */
    public FetcherData setBody(String body)
    {
        this.body = body;

        return this;
    }

    /**
     * Set Header
     *
     * @param  key
     * @param  value
     * @return FetcherData
     */
    public FetcherData setHeader(String key, String value)
    {
        this.headers.put(key, value);

        return this;
    }

    /**
     * Set URL Parameters
     *
     * @param  key
     * @param  value
     * @return FetcherData
     */
    public FetcherData setUrlParameter(String key, String value)
    {
        this.urlParameters.put(key, value);

        return this;
    }

    /**
     * Set Cookie
     *
     * @param  key
     * @param  value
     * @return FetcherData
     */
    public FetcherData setCookie(String key, String value)
    {
        this.cookies.put(key, value);

        return this;
    }

    /**
     * Set Form Item
     *
     * @param  key
     * @param  value
     * @return FetcherData
     */
    public FetcherData setFormItem(String key, String value)
    {
        this.formItems.put(key, value);

        return this;
    }

    /**
     * Get URL
     *
     * @return String
     */
    public String getUrl()
    {
        return this.url;
    }

    /**
     * Get Method
     *
     * @return String
     */
    public String getMethod()
    {
        return this.method;
    }

    /**
     * Get Body Type
     *
     * @return String
     */
    public String getBodyType()
    {
        return this.bodyType;
    }

    /**
     * Get Body
     *
     * @return String
     */
    public String getBody()
    {
        return this.body;
    }

    /**
     * Get Headers
     *
     * @return Map<String, String>
     */
    public Map<String, String> getHeaders()
    {
        return this.headers;
    }

    /**
     * Get URL Parameters
     *
     * @return Map<String, String>
     */
    public Map<String, String> getUrlParameters()
    {
        return this.urlParameters;
    }

    /**
     * Get Cookies
     *
     * @return Map<String, String>
     */
    public Map<String, String> getCookies()
    {
        return this.cookies;
    }

    /**
     * Get Form Data
     *
     * @return Map<String, String>
     */
    public Map<String, String> getFormItems()
    {
        return this.formItems;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString()
    {
        String data = "";
        data += "URL: " + this.url + "\n";
        data += "Method: " + this.method + "\n";
        data += "Body Type: " + this.bodyType + "\n";
        data += "Body: " + this.body + "\n";

        // Add Headers
        data += "Headers: ";
        data += "{";
        if( !this.headers.isEmpty() ){
            for(String key : this.headers.keySet()) {
                data += key + ":" + this.headers.get(key) + ",";
            }
        }
        data = data.replaceAll(",$", "");
        data += "}\n";

        // Add URL Parameters
        data += "URL Parameters: ";
        data += "{";
        if( !this.urlParameters.isEmpty() ){
            for(String key : this.urlParameters.keySet()) {
                data += key + ":" + this.urlParameters.get(key) + ",";
            }
        }
        data = data.replaceAll(",$", "");
        data += "}\n";

        // Add Cookies
        data += "Cookies: ";
        data += "{";
        if( !this.cookies.isEmpty() ){
            for(String key : this.cookies.keySet()) {
                data += key + ":" + this.cookies.get(key) + ",";
            }
        }
        data = data.replaceAll(",$", "");
        data += "}\n";

        // Add Form Data
        data += "Form Data: ";
        data += "{";
        if( !this.formItems.isEmpty() ){
            for(String key : this.formItems.keySet()) {
                data += key + ":" + this.formItems.get(key) + ",";
            }
        }
        data = data.replaceAll(",$", "");
        data += "}\n";

        return data;
    }
}
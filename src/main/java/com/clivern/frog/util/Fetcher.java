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

import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Fetcher Class
 *
 * @author A.F
 * @since 1.0.0
 */
public class Fetcher {

    private OkHttpClient client = new OkHttpClient();

    private MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    /**
     * Perform Get Request
     *
     * @param  url
     * @return String
     * @throws IOException
     */
    public String get(String url) throws IOException
    {
        Request request = new Request.Builder().url(url).build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    /**
     * Perform Post Request
     *
     * @param  url
     * @param  body
     * @return String
     * @throws IOException
     */
    public String post(String url, String body) throws IOException
    {
        RequestBody requestBody = RequestBody.create(this.JSON, body);

        Request request = new Request.Builder().url(url).post(requestBody).build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }
}
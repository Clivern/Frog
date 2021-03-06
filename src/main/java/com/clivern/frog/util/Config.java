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
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Config Class
 *
 * @author A.F
 * @since 1.0.0
 */
public class Config {

    /**
     * @var Map<String, String>
     */
    protected Map<String, String> configs = new HashMap<String, String>();


    /**
     * Constructor
     */
    public Config(){ }

    /**
     * Constructor
     *
     * @param path
     */
    public Config(String path) throws IOException
    {
        this.loadPropertiesFile(path);
    }

    /**
     * Load Properties File
     *
     * @param path
     * @return Boolean
     * @throws IOException
     */
    public Boolean loadPropertiesFile(String path) throws IOException
    {
        Properties prop = new Properties();
        InputStream input = null;

        try {

            input = new FileInputStream(path);
            prop.load(input);

            for(String key : prop.stringPropertyNames()) {
                String value = prop.getProperty(key);
                configs.put(key, value);
            }

            return true;
        } catch (IOException ex) {
            return false;
        }
    }

    /**
     * Store Configs in Properties File
     *
     * @param path
     * @return Boolean
     * @throws IOException
     */
    public Boolean storePropertiesFile(String path) throws IOException
    {
        Properties prop = new Properties();
        OutputStream output = null;

        try {

            output = new FileOutputStream(path);
            for (String key : configs.keySet()){
                prop.setProperty(key, configs.get(key));
            }
            prop.store(output, null);

            return true;

        } catch (IOException io) {
            return false;
        }
    }

    /**
     * Set Config
     *
     * @param key
     * @param value
     * @retun void
     */
    public void set(String key, String value)
    {
        configs.put(key, value);
    }

    /**
     * Get Config
     *
     * @param key
     * @param defaultValue
     * @return String
     */
    public String get(String key, String defaultValue)
    {
        if( configs.containsKey(key) ){
            return configs.get(key);
        }

        return defaultValue;
    }

    /**
     * Get All Configs
     *
     * @return Map<String, String>
     */
    public Map<String, String> getAll()
    {
        return configs;
    }
}
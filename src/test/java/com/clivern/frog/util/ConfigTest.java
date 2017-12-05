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

import junit.framework.TestCase;
import java.io.IOException;

/**
 * Config Class Test Cases
 *
 * @author A.F
 * @since 1.0.0
 */
public class ConfigTest extends TestCase {

	/**
	 * Test Set and Get Config
	 */
    public void testGetConfig()
    {
        Config config = new Config();
        config.set("app_name", "Frog");
        assertEquals(config.get("app_name", ""), "Frog");
    }

    /**
     * Test Store Prop. File
     *
     * @throws IOException
     */
    public void testStorePropFile() throws IOException
    {
        Config config = new Config();
    	config.set("app_name", "Frog Changed");
    	config.storePropertiesFile("src/main/java/resources/test_config.properties");
    }

    /**
     * Test Load Prop. File
     *
     * @throws IOException
     */
    public void testLoadPropFile() throws IOException
    {
        Config config = new Config("src/main/java/resources/test_config.properties");
    	assertEquals(config.get("app_name", ""), "Frog Changed");
    }
}
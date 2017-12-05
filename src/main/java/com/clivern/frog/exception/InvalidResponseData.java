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
package com.clivern.frog.exception;

/**
 * Invalid Response Data Custom Exception
 *
 * @author A.F
 * @since 1.0.0
 */
public class InvalidResponseData extends Exception {

    /**
     * Class Constructor
     *
     * @param  exception
     */
    public InvalidResponseData(Exception exception)
    {
        super(exception);
    }

    /**
     * Class Constructor
     *
     * @param  exception
     */
    public InvalidResponseData(String message)
    {
        super(message);
    }
}
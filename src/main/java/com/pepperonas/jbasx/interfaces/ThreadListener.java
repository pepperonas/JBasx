/*
 *    Copyright (c) 2018 Martin Pfeffer
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.pepperonas.jbasx.interfaces;

/**
 * The interface Thread listener.
 *
 * @author Martin Pfeffer (pepperonas)
 */
public interface ThreadListener {

    /**
     * On base thread success.
     *
     * @param message the message
     */
    void onBaseThreadSuccess(String message);

    /**
     * On base thread failed.
     *
     * @param message the message
     */
    void onBaseThreadFailed(String message);

}

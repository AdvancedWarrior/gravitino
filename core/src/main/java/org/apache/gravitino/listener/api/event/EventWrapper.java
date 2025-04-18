/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */

package org.apache.gravitino.listener.api.event;

import org.apache.gravitino.NameIdentifier;

/**
 * A generic wrapper class that extends {@link Event}. It serves to encapsulate an object of type
 * {@code T}. Unlike events generated by Gravitino operations such as table creation, the {@link
 * EventWrapper} is not directly produced by these actions. Instead, it is designed to dispatch
 * events for internal modules, specifically for components like lineage sinks within the system.
 *
 * @param <T> The type of the object to be wrapped
 */
public class EventWrapper<T> extends Event {
  private final T object;

  /**
   * Constructs an {@code EventWrapper} with the specified object.
   *
   * @param object the object to be wrapped
   */
  public EventWrapper(T object) {
    super("mockUser", NameIdentifier.of("mock"));
    this.object = object;
  }

  /**
   * Retrieves the wrapped generic object.
   *
   * @return the wrapped object of type {@code T}
   */
  public T getObject() {
    return object;
  }
}

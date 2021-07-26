/*
 * Copyright 2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.gradle.caching.internal;

import org.gradle.caching.BuildCacheKey;

import java.io.Closeable;
import java.io.IOException;

public interface BuildCacheServiceInternal extends Closeable {

    BuildCacheStoreOutcomeInternal store(BuildCacheKey key, BuildCacheEntryInternal entry);

    BuildCacheLoadOutcomeInternal load(BuildCacheKey key, BuildCacheEntryInternal entry);

    @Override
    void close() throws IOException;
}
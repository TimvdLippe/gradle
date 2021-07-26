/*
 * Copyright 2017 the original author or authors.
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

import org.gradle.caching.BuildCacheService;
import org.gradle.caching.BuildCacheServiceFactory;
import org.gradle.caching.configuration.BuildCache;

public interface BuildCacheServiceFactoryInternal<T extends BuildCache> extends BuildCacheServiceFactory<T> {

    BuildCacheServiceInternal createBuildCacheServiceInternal(T configuration, BuildCacheServiceFactory.Describer describer);

    @Override
    default BuildCacheService createBuildCacheService(T configuration, Describer describer) {
        throw new UnsupportedOperationException();
    }
}
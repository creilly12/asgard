/*
 * Copyright 2012 Netflix, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.netflix.asgard.push

final class RollingPushOptions {
    CommonPushOptions common
    Integer relaunchCount
    Integer concurrentRelaunches
    Boolean newestFirst
    Boolean rudeShutdown
    String iamInstanceProfile
    Boolean instanceMonitoringIsEnabled
    String spotPrice
    String keyName

    Boolean shouldWaitAfterBoot() {
        Math.max(0, common.afterBootWait) && !common.checkHealth
    }

    def propertyMissing(String name) { common[name] }
}

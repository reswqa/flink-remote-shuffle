/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.alibaba.flink.shuffle.coordinator.worker;

import com.alibaba.flink.shuffle.common.utils.CommonUtils;
import com.alibaba.flink.shuffle.core.ids.InstanceID;

import java.io.Serializable;

/** Location information of shuffle workers. */
public class ShuffleWorkerLocation implements Serializable {

    private static final long serialVersionUID = 5625612426180704010L;

    private final String externalAddress;

    private final int dataPort;

    private final InstanceID workerID;

    public ShuffleWorkerLocation(String externalAddress, int dataPort, InstanceID workerID) {
        CommonUtils.checkArgument(externalAddress != null, "Must be not null.");
        CommonUtils.checkArgument(CommonUtils.isValidHostPort(dataPort), "Illegal data port.");
        CommonUtils.checkArgument(workerID != null, "Must be not null.");

        this.externalAddress = externalAddress;
        this.dataPort = dataPort;
        this.workerID = workerID;
    }

    public InstanceID getWorkerID() {
        return workerID;
    }

    public int getDataPort() {
        return dataPort;
    }

    public String getExternalAddress() {
        return externalAddress;
    }
}

/*
 * Copyright (c) Microsoft Corporation
 *
 * All rights reserved.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and
 * to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of
 * the Software.
 *
 * THE SOFTWARE IS PROVIDED *AS IS*, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO
 * THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
 * TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.microsoft.azuretools.azurecommons.rediscacheprocessors;

import com.microsoft.azure.management.redis.RedisCache;
import com.microsoft.azure.management.redis.RedisCaches;
import com.microsoft.azure.management.resources.fluentcore.model.Creatable;

public class PremWithNewResGrp extends ProcessorBaseImpl {

    public PremWithNewResGrp(RedisCaches rediscaches, String dns, String regionName, String group,
            int capacity) {
        super(rediscaches, dns, regionName, group, capacity);
    }

    @SuppressWarnings("unchecked")
    @Override
    public ProcessingStrategy process() {
        Creatable<RedisCache> redisCacheDefinition = withDNSNameAndRegionDefinition()
                .withNewResourceGroup(this.ResourceGroupName())
                .withPremiumSku(this.Capacity());
        this.RedisCachesInstance().create(redisCacheDefinition);
        return this;
    }

    @Override
    public void waitForCompletion(String produce) throws InterruptedException {
        queue.put(produce);
    }
    @Override
    public void notifyCompletion() throws InterruptedException {
        queue.take();
    }
}

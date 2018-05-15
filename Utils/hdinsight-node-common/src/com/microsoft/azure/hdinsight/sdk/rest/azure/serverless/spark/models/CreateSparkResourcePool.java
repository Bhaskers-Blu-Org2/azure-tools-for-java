/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.hdinsight.sdk.rest.azure.serverless.spark.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Parameters used to submit a new Data Lake Analytics resource pool creation
 * request.
 */
public class CreateSparkResourcePool {
    /**
     * Friendly name of the resource pool to submit.
     */
    @JsonProperty(value = "name", required = true)
    private String name;

    /**
     * The spark resource pool specific properties.
     */
    @JsonProperty(value = "properties", required = true)
    private CreateSparkResourcePoolParameters properties;

    /**
     * Get the name value.
     *
     * @return the name value
     */
    public String name() {
        return this.name;
    }

    /**
     * Set the name value.
     *
     * @param name the name value to set
     * @return the CreateSparkResourcePool object itself.
     */
    public CreateSparkResourcePool withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get the properties value.
     *
     * @return the properties value
     */
    public CreateSparkResourcePoolParameters properties() {
        return this.properties;
    }

    /**
     * Set the properties value.
     *
     * @param properties the properties value to set
     * @return the CreateSparkResourcePool object itself.
     */
    public CreateSparkResourcePool withProperties(CreateSparkResourcePoolParameters properties) {
        this.properties = properties;
        return this;
    }

}
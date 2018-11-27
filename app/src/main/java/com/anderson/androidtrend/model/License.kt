package com.anderson.androidtrend.model

import android.os.Parcelable
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import kotlinx.android.parcel.Parcelize

@JsonInclude(JsonInclude.Include.NON_NULL)
@Parcelize
class License (
    @JsonProperty("key")
    var key: String? = null,
    @JsonProperty("name")
    var name: String? = null,
    @JsonProperty("spdx_id")
    var spdxId: String? = null,
    @JsonProperty("url")
    var url: String? = null,
    @JsonProperty("node_id")
    var nodeId: String? = null
): Parcelable
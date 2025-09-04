package com.maciejweglarz.rickandmortyapp.core.network.adapter

import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.ToJson

class ApiErrorJsonAdapter : JsonAdapter<ApiError>() {

    @FromJson
    override fun fromJson(reader: JsonReader): ApiError? {
        reader.beginObject()
        val type = reader.nextName()
        return when (type) {
            "HttpError" -> {
                val code = reader.nextInt()
                val message = reader.nextString()
                ApiError.HttpError(code, message)
            }

            "NetworkError" -> {
                val message = reader.nextString()
                ApiError.NetworkError(message)
            }

            "UnknownError" -> {
                val message = reader.nextString()
                ApiError.UnknownError(message)
            }

            else -> null
        }.also { reader.endObject() }
    }

    @ToJson
    override fun toJson(writer: JsonWriter, value: ApiError?) {
        when (value) {
            is ApiError.HttpError -> {
                writer.beginObject()
                writer.name("HttpError")
                writer.value(value.code)
                writer.value(value.message)
                writer.endObject()
            }
            is ApiError.NetworkError -> {
                writer.beginObject()
                writer.name("NetworkError")
                writer.value(value.message)
                writer.endObject()
            }
            is ApiError.UnknownError -> {
                writer.beginObject()
                writer.name("UnknownError")
                writer.value(value.message)
                writer.endObject()
            }
            null -> {}
        }
    }
}
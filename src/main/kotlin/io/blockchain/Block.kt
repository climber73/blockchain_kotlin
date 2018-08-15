package io.blockchain

import com.google.gson.GsonBuilder
import java.util.*
import java.security.MessageDigest

fun sha256(input: String): String {
    val digest = MessageDigest.getInstance("SHA-256")
    val hash = digest.digest(input.toByteArray(Charsets.UTF_8))
    return hash.joinToString("") {
        Integer.toHexString(0xff and it.toInt())
    }
}

class Block(
        private val prevHash: String,
        private val data: String
) {
    private val timeStamp: Long = Date().time
    val hash: String = sha256(prevHash + data + timeStamp)

    override fun toString(): String {
        return GsonBuilder().setPrettyPrinting().create().toJson(this)
    }
}

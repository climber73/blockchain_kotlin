package io.blockchain

import com.google.gson.GsonBuilder

class Blockchain : Iterable<Block> {
    private val blocks = ArrayList<Block>()

    init {
        blocks.add(Block("none", "genesis"))
    }

    fun getLastBlock(): Block {
        return blocks.last()
    }

    override fun iterator(): Iterator<Block> {
        return blocks.iterator()
    }

    fun add(b: Block) {
        blocks.add(b)
    }

    override fun toString(): String {
        return GsonBuilder().setPrettyPrinting().create().toJson(this)
    }
}

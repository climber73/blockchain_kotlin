package io.blockchain

fun main(args: Array<String>) {
    val blockchain = Blockchain()
    var b = Block(blockchain.getLastBlock().hash, "second block")
    blockchain.add(b)
    b = Block(b.hash, "third block")
    blockchain.add(b)
    print(blockchain)
}
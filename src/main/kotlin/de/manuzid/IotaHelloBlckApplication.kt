package de.manuzid

import org.iota.jota.IotaAPI
import org.iota.jota.error.ArgumentException
import org.iota.jota.model.Transfer
import org.iota.jota.utils.TrytesConverter

fun main(args : Array<String>) {
    val seed = "to fill"
    val address = "to fill"
    val addressChecksum = "to fill"

    val transfer = Transfer(address + addressChecksum, 0,
            TrytesConverter.asciiToTrytes("Griselda, Buffalo"),
            "999999999999999999999999999")

    val api = IotaAPI.Builder()
            .protocol("http")
            .host("node01.iotatoken.nl")
            .port(14265)
            .build()

    val response = api.getNodeInfo()

    try {
        val response = api.sendTransfer(seed, 2, 15, 18, listOf(transfer), null, null, true, false,null)
        val transactions = response.transactions
        println(transactions)
    } catch (argumentException: ArgumentException) {
        argumentException.printStackTrace();
    }
}
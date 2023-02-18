package com.example.grpc_client.network

import android.text.TextUtils
import com.example.grpc_client.GreeterGrpc
import com.example.grpc_client.HelloRequest
import io.grpc.ManagedChannel
import io.grpc.ManagedChannelBuilder

suspend fun sendMessage(
    message: String,
    host: String,
    portString: String
):Any? {
    val port = if (TextUtils.isEmpty(portString)) 0 else Integer.valueOf(portString)
    return try {
        val channel: ManagedChannel? = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build()
        val stub = GreeterGrpc.newBlockingStub(channel)
        val request = HelloRequest.newBuilder().setName(message).build()
        val reply = stub.sayHello(request)
        reply.message
    } catch (e: Exception) {
        e
    }
}
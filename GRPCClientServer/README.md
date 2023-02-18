## Jetpack Compose GRPC Client and Node Server

![img_alt](https://i.imgur.com/2k0elkA.png)

## How to generate GRPC Files in Android from PROTO

* Sync with gradle
* Build

After successful build, few files will be generated inside java(generated)

```
HelloReply
HelloReplyOrBuilder
HelloRequest
HelloRequestOrBuilder
HelloWorldProto
GreeterGrpc(will be in a different folder, still inside generated)
```

## How to connect with Node Server

IP - 10.0.2.2
Port - 50051

## How to start node server

* npm i
* node index.js
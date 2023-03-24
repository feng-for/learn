package com.proto.main;

import com.proto.server.NewsService;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

/**
 * @ClassName: GrpcServer
 * @Description:
 * @Author: wei
 * @DateTime: 2023/2/2 22:33
 * @Motto: 时间顺流而下，生活逆水行舟
 **/
public class GrpcServer {

    private final static int port = 8888;

    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(port).addService(new NewsService()).build().start();
        System.out.println(String.format("GRPC启动成功，端口: %d", port));
        server.awaitTermination();
    }
}

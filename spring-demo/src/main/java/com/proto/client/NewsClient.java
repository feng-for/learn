package com.proto.client;

import com.proto.NewsProto;
import com.proto.NewsServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.List;

/**
 * @ClassName: NewsClient
 * @Description:
 * @Author: wei
 * @DateTime: 2023/2/2 22:37
 * @Motto: 时间顺流而下，生活逆水行舟
 **/
public class NewsClient {

    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("127.0.0.1", 8888)
                .usePlaintext()
                .build();
        NewsServiceGrpc.NewsServiceBlockingStub blockingStub = NewsServiceGrpc.newBlockingStub(channel);
        NewsProto.NewsRequest request = NewsProto.NewsRequest.newBuilder().setDate("2023-02-02").build();
        NewsProto.NewsResponse response = blockingStub.list(request);
        List<NewsProto.News> newsList = response.getNewsList();
        newsList.forEach(System.out::println);
    }
}

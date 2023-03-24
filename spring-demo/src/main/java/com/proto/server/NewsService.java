package com.proto.server;

import com.proto.NewsProto;
import com.proto.NewsServiceGrpc;
import io.grpc.stub.StreamObserver;

/**
 * @ClassName: NewsService
 * @Description:
 * @Author: wei
 * @DateTime: 2023/2/2 22:22
 * @Motto: 时间顺流而下，生活逆水行舟
 **/
public class NewsService extends NewsServiceGrpc.NewsServiceImplBase {

    @Override
    public void list(NewsProto.NewsRequest request, StreamObserver<NewsProto.NewsResponse> responseObserver) {
        String requestDate = request.getDate();

        NewsProto.NewsResponse.Builder newBuilder = NewsProto.NewsResponse.newBuilder();
        for (int i = 0; i < 5; i++) {
            NewsProto.News news = NewsProto.News.newBuilder().setId(i)
                    .setContent(requestDate + "党日新闻内容" + i)
                    .setTitle("新闻标题")
                    .setCreateTime(System.nanoTime()).build();
            newBuilder.addNews(news);
        }
        NewsProto.NewsResponse response = newBuilder.build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}

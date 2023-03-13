package com.feng;

import com.google.protobuf.InvalidProtocolBufferException;
import io.netty.handler.codec.protobuf.ProtobufDecoder;

import java.util.Arrays;

/**
 * @ClassName: DemoTest
 * @Description:
 * @Author: wei
 * @DateTime: 2023/1/20 00:22
 * @Motto: 时间顺流而下，生活逆水行舟
 **/
public class DemoTest {

    public static void main(String[] args) throws InvalidProtocolBufferException {
        Demo.ProtoDemo.Builder builder = Demo.ProtoDemo.newBuilder().setId(18).setName("雏田");
        Demo.ProtoDemo demo = builder.build();
        byte[] bytes = demo.toByteArray();
        System.out.println(Arrays.toString(bytes));
        Demo.ProtoDemo protoDemo = Demo.ProtoDemo.parseFrom(bytes);
        System.out.println(protoDemo);
    }
}

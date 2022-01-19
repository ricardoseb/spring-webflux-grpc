package com.poc.grpcclient.service;

import com.poc.api.grpc.v1.HelloReply;
import com.poc.api.grpc.v1.HelloRequest;
import com.poc.api.grpc.v1.ReactorMyServiceGrpc;
import io.grpc.StatusRuntimeException;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * @author Ricardo Quiroga on 18-01-22
 */
@Slf4j
@Service
public class GrpcClientService {

    @GrpcClient("local-grpc-server")
    private ReactorMyServiceGrpc.ReactorMyServiceStub simpleStub;

    public Mono<HelloReply> sendMessage(final String name) {
        Mono<HelloRequest> req = Mono.just(
                HelloRequest.newBuilder().setName("ricardito").build()
        );
        return simpleStub.sayHello(req).doOnNext(r -> System.out.println("r = " + r));
    }

}

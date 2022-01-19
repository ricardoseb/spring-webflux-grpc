package com.poc.grpcback.service;

import com.poc.api.grpc.v1.HelloReply;
import com.poc.api.grpc.v1.HelloRequest;
import com.poc.api.grpc.v1.ReactorMyServiceGrpc;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * @author Ricardo Quiroga on 18-01-22
 */
@GrpcService
public class HelloService extends ReactorMyServiceGrpc.MyServiceImplBase {

    @Override
    public Mono<HelloReply> sayHello(Mono<HelloRequest> request) {
        return request.map(HelloRequest::getName )
                .map(name -> HelloReply.newBuilder().setText(name).build());
    }
}

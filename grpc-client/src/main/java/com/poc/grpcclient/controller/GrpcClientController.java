package com.poc.grpcclient.controller;

import com.poc.api.grpc.v1.HelloReply;
import com.poc.grpcclient.service.GrpcClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author Ricardo Quiroga on 18-01-22
 */
@RestController
public class GrpcClientController {

    private final GrpcClientService grpcClientService;


    public GrpcClientController(GrpcClientService grpcClientService) {
        this.grpcClientService = grpcClientService;
    }

    @RequestMapping("/")
    public Mono<HelloReply> printMessage(@RequestParam(defaultValue = "Rick") String name) {
        return grpcClientService.sendMessage(name);
    }


}

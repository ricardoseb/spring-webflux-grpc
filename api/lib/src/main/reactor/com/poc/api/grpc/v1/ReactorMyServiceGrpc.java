package com.poc.api.grpc.v1;

import static com.poc.api.grpc.v1.MyServiceGrpc.getServiceDescriptor;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;


@javax.annotation.Generated(
value = "by ReactorGrpc generator",
comments = "Source: Example.proto")
public final class ReactorMyServiceGrpc {
    private ReactorMyServiceGrpc() {}

    public static ReactorMyServiceStub newReactorStub(io.grpc.Channel channel) {
        return new ReactorMyServiceStub(channel);
    }

    /**
     * <pre>
     *  The greeting service definition.
     * </pre>
     */
    public static final class ReactorMyServiceStub extends io.grpc.stub.AbstractStub<ReactorMyServiceStub> {
        private MyServiceGrpc.MyServiceStub delegateStub;

        private ReactorMyServiceStub(io.grpc.Channel channel) {
            super(channel);
            delegateStub = MyServiceGrpc.newStub(channel);
        }

        private ReactorMyServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
            delegateStub = MyServiceGrpc.newStub(channel).build(channel, callOptions);
        }

        @Override
        protected ReactorMyServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ReactorMyServiceStub(channel, callOptions);
        }

        public reactor.core.publisher.Mono<com.poc.api.grpc.v1.HelloReply> sayHello(reactor.core.publisher.Mono<com.poc.api.grpc.v1.HelloRequest> reactorRequest) {
            return com.salesforce.reactorgrpc.stub.ClientCalls.oneToOne(reactorRequest, delegateStub::sayHello, getCallOptions());
        }

        public reactor.core.publisher.Mono<com.poc.api.grpc.v1.HelloReply> sayHello(com.poc.api.grpc.v1.HelloRequest reactorRequest) {
           return com.salesforce.reactorgrpc.stub.ClientCalls.oneToOne(reactor.core.publisher.Mono.just(reactorRequest), delegateStub::sayHello, getCallOptions());
        }

    }

    /**
     * <pre>
     *  The greeting service definition.
     * </pre>
     */
    public static abstract class MyServiceImplBase implements io.grpc.BindableService {

        public reactor.core.publisher.Mono<com.poc.api.grpc.v1.HelloReply> sayHello(reactor.core.publisher.Mono<com.poc.api.grpc.v1.HelloRequest> request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
            return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
                    .addMethod(
                            com.poc.api.grpc.v1.MyServiceGrpc.getSayHelloMethod(),
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            com.poc.api.grpc.v1.HelloRequest,
                                            com.poc.api.grpc.v1.HelloReply>(
                                            this, METHODID_SAY_HELLO)))
                    .build();
        }

        protected io.grpc.CallOptions getCallOptions(int methodId) {
            return null;
        }

    }

    public static final int METHODID_SAY_HELLO = 0;

    private static final class MethodHandlers<Req, Resp> implements
            io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
        private final MyServiceImplBase serviceImpl;
        private final int methodId;

        MethodHandlers(MyServiceImplBase serviceImpl, int methodId) {
            this.serviceImpl = serviceImpl;
            this.methodId = methodId;
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
                case METHODID_SAY_HELLO:
                    com.salesforce.reactorgrpc.stub.ServerCalls.oneToOne((com.poc.api.grpc.v1.HelloRequest) request,
                            (io.grpc.stub.StreamObserver<com.poc.api.grpc.v1.HelloReply>) responseObserver,
                            serviceImpl::sayHello);
                    break;
                default:
                    throw new java.lang.AssertionError();
            }
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public io.grpc.stub.StreamObserver<Req> invoke(io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
                default:
                    throw new java.lang.AssertionError();
            }
        }
    }

}

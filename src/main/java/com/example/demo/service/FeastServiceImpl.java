package com.example.demo.service;

import feast.proto.serving.ServingAPIProto;
import feast.proto.serving.ServingServiceGrpc;
import feast.proto.types.ValueProto;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class FeastServiceImpl extends ServingServiceGrpc.ServingServiceImplBase {
    @Override
    public void getOnlineFeaturesV2(ServingAPIProto.GetOnlineFeaturesRequestV2 request, StreamObserver<ServingAPIProto.GetOnlineFeaturesResponse> responseObserver) {

        ServingAPIProto.GetOnlineFeaturesResponse response = ServingAPIProto.GetOnlineFeaturesResponse
                .newBuilder()
                .addFieldValues(0, ServingAPIProto.GetOnlineFeaturesResponse.FieldValues
                        .newBuilder()
                        .putStatusesValue("qwe", 1)
                        .putStatuses("qwe2", ServingAPIProto.GetOnlineFeaturesResponse.FieldStatus.PRESENT)
                        .putFields("qwe2", ValueProto.Value.newBuilder().setStringVal("qweqweqew").build())
                        .build())
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}

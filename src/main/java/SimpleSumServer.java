import io.grpc.stub.StreamObserver;

public class SimpleSumServer extends SimpleSumGrpc.SimpleSumImplBase {

    @Override
    public void streamSimpleSum(Sum.SimpleSumRequest request, StreamObserver<Sum.SimpleSumResponse> responseObserver) {
        System.out.println("Sum requested from the client: \n" + request.getN1() + " + " + request.getN2());

        Sum.SimpleSumResponse response = Sum.SimpleSumResponse.newBuilder()
                .setSum(request.getN1() + request.getN2())
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}

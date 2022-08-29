import io.grpc.stub.StreamObserver;

public class StreamSumServer extends StreamSumGrpc.StreamSumImplBase {

    @Override
    public void streamStreamSum(Sum.StreamSumRequest request, StreamObserver<Sum.StreamSumResponse> responseObserver) {
        System.out.println("Sum requested from the client: \n" + request.getN1() + " + " + request.getN2());

        Sum.StreamSumResponse response = Sum.StreamSumResponse.newBuilder()
                .setSum(request.getN1() + request.getN2())
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
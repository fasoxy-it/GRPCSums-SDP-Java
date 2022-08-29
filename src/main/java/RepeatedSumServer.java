import io.grpc.stub.StreamObserver;

public class RepeatedSumServer extends RepeatedSumGrpc.RepeatedSumImplBase {

    @Override
    public void streamRepeatedSum(Sum.RepeatedSumRequest request, StreamObserver<Sum.RepeatedSumResponse> responseObserver) {
        System.out.println("Repeated sum requested from the client: \n" + request.getN() + " X " + request.getT() + " times");

        Sum.RepeatedSumResponse response = Sum.RepeatedSumResponse.newBuilder()
                .setSum(request.getN() * request.getT())
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}

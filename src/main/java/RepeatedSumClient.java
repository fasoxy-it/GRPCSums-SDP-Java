import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.concurrent.TimeUnit;

public class RepeatedSumClient {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Trying to call repeated asynchronous method: \n");

        asynchronousStreamCall();

        System.out.println("\n...Done!");
    }

    public static void asynchronousStreamCall() throws InterruptedException {
        final ManagedChannel channel = ManagedChannelBuilder
                .forTarget("localhost:8080")
                .usePlaintext()
                .build();

        RepeatedSumGrpc.RepeatedSumStub stub = RepeatedSumGrpc.newStub(channel);

        Sum.RepeatedSumRequest request = Sum.RepeatedSumRequest.newBuilder()
                .setN(10)
                .setT(5)
                .build();

        stub.streamRepeatedSum(request, new StreamObserver<Sum.RepeatedSumResponse>() {

            public void onNext(Sum.RepeatedSumResponse repeatedSumResponse) {
                System.out.println("The received asynchronous sum is: " + repeatedSumResponse.getSum());
            }


            public void onError(Throwable throwable) {

            }


            public void onCompleted() {
                channel.shutdown();
            }
        });

        channel.awaitTermination(10, TimeUnit.SECONDS);
    }
}

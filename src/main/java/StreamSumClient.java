import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.concurrent.TimeUnit;

public class StreamSumClient {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Trying to call repeated sum asynchronous method: \n");

        asynchronousStreamCall();

        System.out.println("\n...Done!");
    }

    public static void asynchronousStreamCall() throws InterruptedException{

        final ManagedChannel channel = ManagedChannelBuilder
                .forTarget("localhost:8080")
                .usePlaintext()
                .build();

        StreamSumGrpc.StreamSumStub stub = StreamSumGrpc.newStub(channel);

        Sum.StreamSumRequest request = Sum.StreamSumRequest.newBuilder()
                .setN1(1)
                .setN2(2)
                .build();

        stub.streamStreamSum(request, new StreamObserver<Sum.StreamSumResponse>() {

            public void onNext(Sum.StreamSumResponse streamSumResponse) {
                System.out.println("The received asynchronous sum is: " + streamSumResponse.getSum());
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

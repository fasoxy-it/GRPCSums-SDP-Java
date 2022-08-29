import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.concurrent.TimeUnit;

public class SimpleSumClient {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Trying to call simple sum synchronous method: \n");

        synchronousCall();

        System.out.println("\n...Done!");

        System.out.println("--------------");

        System.out.println("Now calling simple sum asynchronous method:\n");

        asynchronousStreamCall();

        System.out.println("\n...Done!");
    }

    public static void synchronousCall() {

        final ManagedChannel channel = ManagedChannelBuilder.forTarget("localhost:8080").usePlaintext().build();

        SimpleSumGrpc.SimpleSumBlockingStub stub = SimpleSumGrpc.newBlockingStub(channel);

        Sum.SimpleSumRequest request = Sum.SimpleSumRequest.newBuilder()
                .setN1(10)
                .setN2(20)
                .build();

        Sum.SimpleSumResponse response = stub.streamSimpleSum(request);

        System.out.println("The received sync sum is: " + response.getSum());

        channel.shutdown();

    }

    public static void asynchronousStreamCall() throws InterruptedException {
        final ManagedChannel channel = ManagedChannelBuilder
                .forTarget("localhost:8080")
                .usePlaintext()
                .build();

        SimpleSumGrpc.SimpleSumStub stub = SimpleSumGrpc.newStub(channel);

        Sum.SimpleSumRequest request = Sum.SimpleSumRequest.newBuilder()
                .setN1(10)
                .setN2(20)
                .build();

        stub.streamSimpleSum(request, new StreamObserver<Sum.SimpleSumResponse>() {

            public void onNext(Sum.SimpleSumResponse simpleSumResponse) {
                System.out.println("The received asynchronous sum is: " + simpleSumResponse.getSum());
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

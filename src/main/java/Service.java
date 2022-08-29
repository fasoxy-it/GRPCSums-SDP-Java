import io.grpc.ServerBuilder;
import io.grpc.Server;

import java.io.IOException;

public class Service {

    public static void main(String[] args) throws Exception {

        try {
            Server server = ServerBuilder.forPort(8080)
                    .addService(new SimpleSumServer())
                    .addService(new RepeatedSumServer())
                    .addService(new StreamSumServer())
                    .build();

            server.start();

            System.out.println("Server started!");

            server.awaitTermination();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

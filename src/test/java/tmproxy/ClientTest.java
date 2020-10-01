package tmproxy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tmproxy.response.ResponseStats;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {
    String api = "a5629971e791479352d9ffa3eeee8d55";
    Client client = new Client();

    @Test
    void stats() {
        ResponseStats stats = client.Stats(this.api);
        System.out.println(stats);
    }

    @Test
    void currentProxy() {
    }
}
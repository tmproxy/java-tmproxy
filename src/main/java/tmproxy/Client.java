package tmproxy;

import okhttp3.*;
import org.jetbrains.annotations.NotNull;
import tmproxy.request.Stats.RequestStatsBuilder;
import tmproxy.response.Converter;
import tmproxy.request.Stats.RequestStatsAPI;
import tmproxy.response.ResponseCurrentProxy;
import tmproxy.response.ResponseStats;

import java.io.IOException;
import java.util.Objects;

import static tmproxy.constant.Constant.TMPROXY_BETA_API;
import static tmproxy.constant.Constant.TMPROXY_PRODUCTION_API;

public class Client {
    private static final MediaType jsonContentType = MediaType.parse("application/json");
    private String urlServer = TMPROXY_PRODUCTION_API;
    private static final OkHttpClient client = new OkHttpClient();

    public Client() { }

    public Client(boolean betaMode) {
        urlServer = TMPROXY_BETA_API;
    }


    public ResponseStats Stats(@NotNull String apiKey) {
        try (Response response = request("/stats", new RequestStatsBuilder().withAPI(apiKey).build().toJsonString())) {
            if (response.isSuccessful()) {
                return ResponseStats.fromJsonString(Objects.requireNonNull(response.body()).string());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ResponseCurrentProxy CurrentProxy(@NotNull String apiKey) {
        try (Response response = request("/get-current-proxy", new RequestStatsBuilder().withAPI(apiKey).build().toJsonString())) {
            if (response.isSuccessful()) {
                return Converter.fromJsonString(Objects.requireNonNull(response.body()).string());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ResponseCurrentProxy NewProxy(@NotNull String apiKey) {
        try (Response response = request("/get-current-proxy", new RequestStatsBuilder().withAPI(apiKey).build().toJsonString())) {
            if (response.isSuccessful()) {
                return Converter.fromJsonString(Objects.requireNonNull(response.body()).string());

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Response request(String suffix, String jsonContent) throws IOException {
        String url = urlServer + suffix;
        RequestBody body = RequestBody.create(jsonContent, jsonContentType);
        Request request = new Request.Builder().
                url(url).
                post(body).
                build();
        return client.newCall(request).execute();
    }
}

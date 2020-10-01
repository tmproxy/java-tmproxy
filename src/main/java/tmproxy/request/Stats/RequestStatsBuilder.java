package tmproxy.request.Stats;

import org.jetbrains.annotations.NotNull;

public class RequestStatsBuilder {
    RequestStatsAPI statsAPI;

    public RequestStatsBuilder() {
        statsAPI = new RequestStatsAPI();
    }

    public RequestStatsBuilder withAPI(@NotNull String apiKey) {
        this.statsAPI.setApiKey(apiKey);
        return this;
    }

    public RequestStatsAPI build() {
        return this.statsAPI;
    }

}

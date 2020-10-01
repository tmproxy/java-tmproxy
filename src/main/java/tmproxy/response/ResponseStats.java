package tmproxy.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Date;

public class ResponseStats {
    @JsonProperty("code")
    private int code;

    @JsonProperty("message")
    private String message;
    @JsonProperty("data")
    private Data data;

    static class Data {
        @Override
        public String toString() {
            return "Data{" +
                    "id=" + id +
                    ", expiredAt='" + expiredAt + '\'' +
                    ", plan='" + plan + '\'' +
                    ", pricePerDay=" + pricePerDay +
                    ", timeout=" + timeout +
                    ", baseNextRequest=" + baseNextRequest +
                    ", note='" + note + '\'' +
                    ", apiKey='" + apiKey + '\'' +
                    ", maxIPPerDay=" + maxIPPerDay +
                    ", ipUsedToday=" + ipUsedToday +
                    '}';
        }

        @JsonProperty("id")
        private int id;
        @JsonProperty("expired_at")
        private String expiredAt;
        @JsonProperty("plan")
        private String plan;

        @JsonProperty("price_per_day")
        private int pricePerDay;
        @JsonProperty("timeout")
        private int timeout;
        @JsonProperty("base_next_request")
        private int baseNextRequest;
        @JsonProperty("note")
        private String note;
        @JsonProperty("api_key")
        private String apiKey;
        @JsonProperty("max_ip_per_day")

        private int maxIPPerDay;
        @JsonProperty("ip_used_today")
        private int ipUsedToday;
    }

    public static ResponseStats fromJsonString(String data) {
        try {
            ObjectMapper om = new ObjectMapper();

            return om.readValue(data, ResponseStats.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String toString() {
        return "ResponseStats{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}

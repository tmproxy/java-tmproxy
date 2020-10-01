package tmproxy.response;

import com.fasterxml.jackson.annotation.*;

public class Data {
    private String ipAllow;
    private String socks5;
    private String https;
    private long timeout;
    private long nextRequest;
    private String expiredAt;

    @JsonProperty("ip_allow")
    public String getIPAllow() { return ipAllow; }
    @JsonProperty("ip_allow")
    public void setIPAllow(String value) { this.ipAllow = value; }

    @JsonProperty("socks5")
    public String getSocks5() { return socks5; }
    @JsonProperty("socks5")
    public void setSocks5(String value) { this.socks5 = value; }

    @JsonProperty("https")
    public String getHTTPS() { return https; }
    @JsonProperty("https")
    public void setHTTPS(String value) { this.https = value; }

    @JsonProperty("timeout")
    public long getTimeout() { return timeout; }
    @JsonProperty("timeout")
    public void setTimeout(long value) { this.timeout = value; }

    @JsonProperty("next_request")
    public long getNextRequest() { return nextRequest; }
    @JsonProperty("next_request")
    public void setNextRequest(long value) { this.nextRequest = value; }

    @JsonProperty("expired_at")
    public String getExpiredAt() { return expiredAt; }
    @JsonProperty("expired_at")
    public void setExpiredAt(String value) { this.expiredAt = value; }
}

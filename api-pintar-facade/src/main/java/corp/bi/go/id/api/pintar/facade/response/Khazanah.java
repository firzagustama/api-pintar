package corp.bi.go.id.api.pintar.facade.response;

public class Khazanah {
    private String id;
    private String type;
    private String name;
    private String address;
    private long orderQuota;
    private String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getOrderQuota() {
        return orderQuota;
    }

    public void setOrderQuota(long orderQuota) {
        this.orderQuota = orderQuota;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

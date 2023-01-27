package corp.bi.go.id.api.pintar.facade.response;

import java.util.List;

public class CustomerList {
    public List<Customer> customers;

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}

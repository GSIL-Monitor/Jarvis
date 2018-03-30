package design_pattern.builder;

/**
 * Created by pokerface_lx on 16/9/8.
 */
public class Builder {

    private Product product = null;

    public Builder(Product products) {
        this.product = products;
    }

    public void buildDate(String dates) {
        product.setDate(dates);
    }

    public void buildSubject(String subjects) {
        product.setSubject(subjects);
    }

    public void buildContent(String contents) {
        product.setContent(contents);
    }

    public Product getProduct() {
        return product;
    }
}

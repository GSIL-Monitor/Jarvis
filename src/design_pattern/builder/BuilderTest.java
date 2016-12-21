package design_pattern.builder;

/**
 * Created by pokerface_lx on 16/9/8.
 */
public class BuilderTest {

    public static void main(String[] args) {
        Builder mBuilder = new Builder(new Product());
        Director mDirector = new Director();
        mDirector.buildDate(mBuilder, "2016/09/08");
        mDirector.buildSubject(mBuilder,"subject");
        mDirector.buildContent(mBuilder,"content");
        Product mProduct = mBuilder.getProduct();
        System.out.println(mProduct);
    }

}

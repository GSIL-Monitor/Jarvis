package design_pattern.builder;

/**
 * Created by pokerface_lx on 16/9/8.
 */
public class Product {

    private String date;
    private String subject;
    private String content;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "date:"+date+"--subject:"+subject+"--content:"+content;
    }
}

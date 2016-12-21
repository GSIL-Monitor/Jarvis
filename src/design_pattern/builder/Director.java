package design_pattern.builder;

/**
 * Created by pokerface_lx on 16/9/8.
 */
public class Director {

    public void buildDate(Builder builders, String dates) {
        builders.buildDate(dates);
    }

    public void buildSubject(Builder builders, String subjects) {
        builders.buildSubject(subjects);
    }

    public void buildContent(Builder builders, String contents) {
        builders.buildContent(contents);
    }

}

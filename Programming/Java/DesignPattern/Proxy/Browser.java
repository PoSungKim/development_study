package Proxy;

public class Browser implements IBrowser {

    private String url;

    public Browser(String url) {
        this.url = url;
    }

    @Override
    public HTML show() {
        System.out.println("Browser loading HTML from ... : " + url);

        return new HTML(url);
    }
}

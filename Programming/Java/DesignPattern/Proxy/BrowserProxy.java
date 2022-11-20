package Proxy;

public class BrowserProxy implements IBrowser{

    private String url;
    private HTML html;

    public BrowserProxy(String url) {
        this.url = url;
    }

    @Override
    public HTML show() {

        if (html == null) {
            this.html = new HTML(url);
            System.out.println("BrowserProxy loading HTML from ... : " + url);
        }

        System.out.println("BrowserProxy use cache HTML : " + url);

        return html;
    }
}

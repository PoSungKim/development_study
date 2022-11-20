package AOP;

import Proxy.HTML;
import Proxy.IBrowser;

public class AopBrowser implements IBrowser {

    private String url;
    private HTML html;
    private Runnable before;
    private Runnable after;

    public AopBrowser(String url, Runnable before, Runnable after) {
        this.url    = url;
        this.before = before;
        this.after  = after;
    }

    @Override
    public HTML show() {

        before.run();

        if (html == null) {
            html = new HTML(url);
            System.out.println("AOPBrowser HTML loading from : " + url);

            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        after.run();

        System.out.println("AOPBrowser HTML cache : " + url);

        return html;
    }
}

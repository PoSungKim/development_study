package AOP;

import Proxy.IBrowser;
import java.util.concurrent.atomic.AtomicLong;

public class Main {

    public static void main(String[] args) {

        AtomicLong start = new AtomicLong();
        AtomicLong end = new AtomicLong();

        IBrowser aopBrowser = new AopBrowser("www.google.com",
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("Before");
                        start.set(System.currentTimeMillis());
                    }
                }, new Runnable() {
                    @Override
                    public void run() {
                        long now = System.currentTimeMillis();
                        end.set(now - start.get());
                    }
                });

        aopBrowser.show();
        System.out.println("Loading Time " + end.get());
    }
}
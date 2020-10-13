package _2020_10_13_.designPatterns;

/**
 * 代理模式
 * @author ACER
 */
public class Proxy {
    Client client;

    public Proxy(Client client) {
        this.client = client;
    }

    public void eat(){
        System.out.println("买菜");
        client.eat();
        System.out.println("洗碗");
    }

    public static void main(String[] args) {
        Client gzq = new GZQClient();
        Proxy proxy = new Proxy(gzq);
        proxy.eat();
    }
}

interface Client{
    void eat();
}

class GZQClient implements Client{

    @Override
    public void eat() {
        System.out.println("吃饭");
    }
}
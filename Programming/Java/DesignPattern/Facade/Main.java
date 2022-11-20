package Facade;

public class Main {

    public static void main(String[] args) {
        main1();
        System.out.println("=======================================================");
        main2();
    }

    public static void main1() {
        FTP ftpClient = new FTP("www.google.com", 22, "/home/etc");
        ftpClient.connect();
        ftpClient.moveDirectory();

        Writer writer = new Writer("text.txt");
        writer.fileConnect();
        writer.fileWrite();

        Reader reader = new Reader("text.txt");
        reader.fileConnect();
        reader.fileRead();

        writer.fileDisconnect();
        reader.fileDisconnect();
        ftpClient.disconnect();
    }

    public static void main2() {
        SFTPClient sftpClient = new SFTPClient("www.google.com", 22, "/home/etc", "text.txt");
        sftpClient.connect();
        sftpClient.write();
        sftpClient.read();
        sftpClient.disconnect();
    }
}

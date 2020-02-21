package it.nextre.academy.pr130120.networking;

import java.nio.channels.Channel;

public class ConnectionSFTP {

    SessionClient sessionClient;

    public ConnectionSFTP(SessionClient sessionClient) {
        this.sessionClient = sessionClient;
    }

    public static void main(String[] args) {

        SessionClient sessionClient = new SessionClient(
                "vracademy",
                "",
                22,
                "ftp.vracademy.altervista.org"
        );

        ConnectionSFTP conn = new ConnectionSFTP(sessionClient);

    }//end main

/*
    public Session openSession() {
        try {
            String user = sessionClient.getUser();
            int port = sessionClient.getPort();
            String host = sessionClient.getHost();
            JSch jsch = new JSch();
            String path_identity = writeResourceToFile("risorsa.ppk");
            jsch.addIdentity(path_identity);
            session = jsch.getSession(user, host, port);
            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);
            session.connect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("Sessione aperta: " + session.isConnected());
        return session;
    }
    public ChannelSftp openChannel() {
        try {
            Channel channel = session.openChannel("sftp");
            channel.setInputStream(System.in);
            channel.setOutputStream(System.out);
            channel.connect();
            channelSftp = (ChannelSftp) channel;
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("Channel aperto: " + channelSftp.isConnected());
        return channelSftp;
    }
*/

}//end class



class SessionClient{
    private String user;
    private String password;
    private int port;
    private String host;

    public SessionClient() {
    }

    public SessionClient(String user, String password, int port, String host) {
        this.user = user;
        this.password = password;
        this.port = port;
        this.host = host;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    @Override
    public String toString() {
        return "SessionClient{" +
                "user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", port='" + port + '\'' +
                ", host='" + host + '\'' +
                '}';
    }
}
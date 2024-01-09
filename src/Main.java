import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class Main {
    public static void main(String[] args)  {
        System.setProperty("java.rmi.server.hostname","192.168.31.17");
        String answer, value = "Reflection in Java";
        MessageBuffer messageBuffer = new MessageBuffer();
        try {
            Chat obj = new Chat(messageBuffer);
            LocateRegistry.createRegistry(1900);
            Naming.rebind("rmi://localhost:1900" + "/geeksforgeeks", obj);
        } catch (RemoteException | MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Chat extends UnicastRemoteObject implements ChatInterface {

    private MessageBuffer messageBuffer;
    protected Chat(MessageBuffer messageBuffer) throws RemoteException {
        super();
        this.messageBuffer = messageBuffer;
    }

    @Override
    public void sendMessage(String msg) throws RemoteException {
        messageBuffer.produce(msg);
    }

    @Override
    public String fetchMessage() throws RemoteException {
        return messageBuffer.consume();
    }

}

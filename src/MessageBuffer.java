import java.util.ArrayList;

public class MessageBuffer {
    private ArrayList<String> buffer;
    private boolean isEmpty;


    public MessageBuffer() {
        this.buffer = new ArrayList<String>();
        this.isEmpty = true;
    }


    public synchronized String consume() {
        if(isEmpty) {
            try {
                wait();
            }
            catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        String str = buffer.getLast();
        if(buffer.size() == 1) {
            isEmpty = true;
        }
        else {
            buffer.removeFirst();
        }
        notifyAll();
        return str;
    }

    public synchronized void produce(String msg) {
        buffer.add(msg);
        isEmpty = false;
        notifyAll();
    }
}

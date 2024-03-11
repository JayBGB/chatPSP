package interfacechat;

import java.io.IOException;
import java.io.InputStream;

import static interfacechat.ChatWindow.chatScreenText;

/**
 * Thread to listen to every incoming message
 *
 * @author JayBGB
 */
class GetMessages extends Thread {

    InputStream is;

    public GetMessages(InputStream is) {
        this.is = is;
    }

    @Override
    public void run() {

        while (true) {
            try {
                // With this method que get the incoming messages
                byte[] incomingMessage = new byte[500];
                is.read(incomingMessage);
                String message = new String(incomingMessage);
                ChatWindow.chatScreenText.setText(chatScreenText.getText() + "\n" + message);
                ChatWindow.state.setText("Connected");
            } catch (IOException ex) {
                ChatWindow.state.setText("The server is closed.");
            }
        }

    }
}
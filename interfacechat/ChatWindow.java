package interfacechat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import javax.swing.JButton;

/**
 *
 * @author JayBGB
 */
public class ChatWindow extends javax.swing.JFrame {

    static Socket socketClient = new Socket();
    InputStream is;
    OutputStream os;
    boolean connected = false;
    /**
     * Creates new form NewChatInterface
     */
    public ChatWindow() {
        initComponents();
        setDefaultButton(sendButton);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        basePanel = new javax.swing.JPanel();
        chatWindow = new javax.swing.JScrollPane();
        chatScreenText = new javax.swing.JTextArea();
        messageText = new javax.swing.JTextField();
        sendButton = new javax.swing.JButton();
        state = new javax.swing.JLabel();
        ipAddressLabel = new javax.swing.JLabel();
        ipText = new javax.swing.JTextField();
        portLabel = new javax.swing.JLabel();
        portText = new javax.swing.JTextField();
        nickLabel = new javax.swing.JLabel();
        nickText = new javax.swing.JTextField();
        connectButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("HISPANIC IRC 2.0");
        setName("HISPANIC IRC 2.0"); // NOI18N
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        basePanel.setBackground(new java.awt.Color(255, 204, 153));
        basePanel.setForeground(new java.awt.Color(255, 204, 153));

        chatScreenText.setEditable(false);
        chatScreenText.setColumns(20);
        chatScreenText.setRows(5);
        chatWindow.setViewportView(chatScreenText);

        sendButton.setFont(new java.awt.Font("Gentium Basic", 1, 12)); // NOI18N
        sendButton.setText("Send");
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
            }
        });

        state.setBackground(new java.awt.Color(0, 204, 0));
        state.setFont(new java.awt.Font("Gentium Basic", 1, 12)); // NOI18N
        state.setText("Disconnected");

        ipAddressLabel.setFont(new java.awt.Font("Gentium Basic", 1, 12)); // NOI18N
        ipAddressLabel.setText("IP Address");

        ipText.setFont(new java.awt.Font("Gentium Basic", 1, 12)); // NOI18N
        ipText.setText("192.168.0.X");

        portLabel.setFont(new java.awt.Font("Gentium Basic", 1, 12)); // NOI18N
        portLabel.setText("Port");

        portText.setFont(new java.awt.Font("Gentium Basic", 1, 12)); // NOI18N
        portText.setText("6666");

        nickLabel.setFont(new java.awt.Font("Gentium Basic", 1, 12)); // NOI18N
        nickLabel.setText("Nickname");

        nickText.setFont(new java.awt.Font("Gentium Basic", 1, 12)); // NOI18N
        nickText.setText("JayBGB");
        nickText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nickTextActionPerformed(evt);
            }
        });

        connectButton.setFont(new java.awt.Font("Gentium Basic", 1, 12)); // NOI18N
        connectButton.setText("Connect");
        connectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectButtonActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfacechat/chatIcon.png"))); // NOI18N

        javax.swing.GroupLayout basePanelLayout = new javax.swing.GroupLayout(basePanel);
        basePanel.setLayout(basePanelLayout);
        basePanelLayout.setHorizontalGroup(
            basePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(basePanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(basePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(basePanelLayout.createSequentialGroup()
                        .addGroup(basePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(messageText)
                            .addComponent(chatWindow, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(basePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(basePanelLayout.createSequentialGroup()
                                .addGroup(basePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(basePanelLayout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(basePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(ipAddressLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(ipText, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(portLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(portText, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(nickLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(nickText, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(basePanelLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(basePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(sendButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(connectButton, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE))))
                                .addGap(0, 2, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, basePanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(basePanelLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(state, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        basePanelLayout.setVerticalGroup(
            basePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(basePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(state)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(basePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(basePanelLayout.createSequentialGroup()
                        .addComponent(ipAddressLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ipText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(portLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(portText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(nickLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nickText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(connectButton)
                        .addGap(23, 23, 23)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(sendButton)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(basePanelLayout.createSequentialGroup()
                        .addComponent(chatWindow, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(messageText, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(17, Short.MAX_VALUE))))
        );

        getContentPane().add(basePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 440));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void setDefaultButton(JButton button) {
    getRootPane().setDefaultButton(button);
    }
    
    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButtonActionPerformed
        if (connected == true) {
            if (!messageText.getText().equals("")) {
                try {
                    os.write(messageText.getText().getBytes());
                    if (messageText.getText().equals("/bye")) {
                        os.close();
                        is.close();
                        connected =false;
                        System.exit(0);
                    }
                    messageText.setText("");
                } catch (IOException ex) {
                    state.setText("Failed message delivery.");
                }
            }
        } else {
            state.setText("You must connect to a chatroom before sending a message.");
        }

    }//GEN-LAST:event_sendButtonActionPerformed

    
    private void nickTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nickTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nickTextActionPerformed

    private void connectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectButtonActionPerformed
        try {
            if (ipText.getText().equals("") || portText.getText().equals("") || nickText.getText().equals("")) {
                state.setText("You must fill all fields.");
            } else {
                //Establecemos conexión
                InetSocketAddress addr = new InetSocketAddress(ipText.getText(), Integer.parseInt(portText.getText()));
                socketClient.connect(addr,1000);

                if (socketClient.isConnected()) {
                    state.setText("On queue");
                    connected = true;
                    
                    //Abrimos conexión entrada y salida
                    is = socketClient.getInputStream();
                    os = socketClient.getOutputStream();

                    //Enviamos el nickname
                    os.write(nickText.getText().getBytes());

                    //Iniciamos hilo para recibir mensajes
                    GetMessages hilo = new GetMessages(is);
                    hilo.start();
                }else
                    state.setText("The server is full. Waiting for an empty spot.");

            }

        } catch (IOException ex) {
            state.setText("Server closed.");
        } catch (NumberFormatException ex2) {
            state.setText("The port has to be a numeric value.");
        }            
    }//GEN-LAST:event_connectButtonActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if(connected ==true){
            try {
                os.write("/bye".getBytes());
            } catch (IOException ex) {
                System.out.println("Exit error");
            }
        }
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ChatWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChatWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChatWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChatWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChatWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel basePanel;
    public static javax.swing.JTextArea chatScreenText;
    private javax.swing.JScrollPane chatWindow;
    private javax.swing.JButton connectButton;
    private javax.swing.JLabel ipAddressLabel;
    private javax.swing.JTextField ipText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField messageText;
    private javax.swing.JLabel nickLabel;
    private javax.swing.JTextField nickText;
    private javax.swing.JLabel portLabel;
    private javax.swing.JTextField portText;
    private javax.swing.JButton sendButton;
    public static javax.swing.JLabel state;
    // End of variables declaration//GEN-END:variables
}
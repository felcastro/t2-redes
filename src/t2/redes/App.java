package t2.redes;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class App extends javax.swing.JFrame {

    private Network network;
    private JScrollPane scroller;

    public App() {
        initComponents();
        getAgents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuNovaLeitura = new javax.swing.JRadioButtonMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Identificador de agentes");

        jMenu1.setText("Arquivo");

        menuNovaLeitura.setSelected(true);
        menuNovaLeitura.setText("Nova Leitura");
        menuNovaLeitura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuNovaLeituraActionPerformed(evt);
            }
        });
        jMenu1.add(menuNovaLeitura);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuNovaLeituraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuNovaLeituraActionPerformed
        getAgents();
    }//GEN-LAST:event_menuNovaLeituraActionPerformed

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
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new App().setVisible(true);
            }
        });
    }

    public void getAgents() {
        if(scroller != null){
            this.remove(scroller);
        }
        int btnSeparator = 15;
        readNetwork();
        Agent agenter = network.agents.get(0);
        network.agents.add(agenter);
        network.agents.add(agenter);
        network.agents.add(agenter);
        network.agents.add(agenter);
        network.agents.add(agenter);
        network.agents.add(agenter);
        network.agents.add(agenter);
        network.agents.add(agenter);
        network.agents.add(agenter);
        network.agents.add(agenter);
        network.agents.add(agenter);
        network.agents.add(agenter);
        network.agents.add(agenter);
        network.agents.add(agenter);
        network.agents.add(agenter);
        network.agents.add(agenter);
        network.agents.add(agenter);
        network.agents.add(agenter);
        network.agents.add(agenter);
        network.agents.add(agenter);
        network.agents.add(agenter);
        network.agents.add(agenter);
        network.agents.add(agenter);
        network.agents.add(agenter);
        network.agents.add(agenter);
        network.agents.add(agenter);
        network.agents.add(agenter);
        network.agents.add(agenter);
        network.agents.add(agenter);
        network.agents.add(agenter);
        network.agents.add(agenter);
        network.agents.add(agenter);
        network.agents.add(agenter);
        network.agents.add(agenter);
        network.agents.add(agenter);
        network.agents.add(agenter);
        network.agents.add(agenter);
        network.agents.add(agenter);

        JPanel panel = new JPanel();
        panel.setMinimumSize(new Dimension(300, 250));
        panel.setPreferredSize(new Dimension(300, (network.agents.size() * 40) / 3));

        for (Agent agent : network.agents) {
            JButton button = new JButton(agent.ipAddress);
            button.setSize(100, 30);
            button.setLocation(15, btnSeparator);
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.out.println("You clicked button " + e.getSource().toString());
                }
            });
            panel.add(button);
            btnSeparator += 40;
        }
        scroller = new JScrollPane(panel);
        scroller.setSize(new Dimension(380, 257));
        scroller.setLocation(10, 15);
        this.add(scroller, BorderLayout.CENTER);

        pack();
    }

    public void readNetwork() {
        this.network = new Network();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JRadioButtonMenuItem menuNovaLeitura;
    // End of variables declaration//GEN-END:variables
}

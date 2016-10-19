package t2.redes;

import java.awt.*;
import org.jfree.chart.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class App extends javax.swing.JFrame {

    private Network network;
    private float minValue;
    private float maxValue;
    private int interval;
    TimeSeries series;
    double lastValue;
    boolean runThread;

    private ArrayList<Point> pointList = new ArrayList<>();

    private int prev;

    public App() {
        initComponents();
        this.getContentPane().setBackground(new Color(37, 37, 37));
        addMibOptions();
        getMibOptionField();
        getAgents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ipsCombo = new javax.swing.JComboBox<>();
        lblChooseIp = new javax.swing.JLabel();
        searchCombo = new javax.swing.JComboBox<>();
        lblChoseSearch = new javax.swing.JLabel();
        mibOptionsCombo = new javax.swing.JComboBox<>();
        lblMibOptions = new javax.swing.JLabel();
        txtMinValue = new javax.swing.JTextField();
        lblMinValue = new javax.swing.JLabel();
        txtMaxValue = new javax.swing.JTextField();
        lblMaxValue = new javax.swing.JLabel();
        btnMinValue = new javax.swing.JButton();
        btnMaxValue = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        btnStartTool = new javax.swing.JButton();
        txtInterval = new javax.swing.JTextField();
        lblInterval = new javax.swing.JLabel();
        btnInterval = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAlerts = new javax.swing.JTextArea();
        jSeparator3 = new javax.swing.JSeparator();
        lblAlertOutput = new javax.swing.JLabel();
        pnlGraphic = new javax.swing.JPanel();
        btnStop = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuNovaLeitura = new javax.swing.JRadioButtonMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Identificador de agentes");
        setBackground(new java.awt.Color(37, 37, 37));
        setResizable(false);

        lblChooseIp.setForeground(new java.awt.Color(255, 255, 255));
        lblChooseIp.setText("Choose the desired IP address:");

        searchCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchComboActionPerformed(evt);
            }
        });

        lblChoseSearch.setForeground(new java.awt.Color(255, 255, 255));
        lblChoseSearch.setText("Choose the desired MIB search:");

        lblMibOptions.setForeground(new java.awt.Color(255, 255, 255));
        lblMibOptions.setText("Choose the desired MIB option:");

        txtMinValue.setText("0");

        lblMinValue.setForeground(new java.awt.Color(255, 255, 255));
        lblMinValue.setText("Min value:");

        txtMaxValue.setText("0");

        lblMaxValue.setForeground(new java.awt.Color(255, 255, 255));
        lblMaxValue.setText("Max value:");

        btnMinValue.setText("Apply");
        btnMinValue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinValueActionPerformed(evt);
            }
        });

        btnMaxValue.setText("Apply");
        btnMaxValue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMaxValueActionPerformed(evt);
            }
        });

        btnStartTool.setText("GO");
        btnStartTool.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartToolActionPerformed(evt);
            }
        });

        txtInterval.setText("0");

        lblInterval.setForeground(new java.awt.Color(255, 255, 255));
        lblInterval.setText("Interval:");

        btnInterval.setText("Apply");
        btnInterval.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIntervalActionPerformed(evt);
            }
        });

        txtAlerts.setColumns(20);
        txtAlerts.setRows(5);
        jScrollPane1.setViewportView(txtAlerts);

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        lblAlertOutput.setForeground(new java.awt.Color(255, 255, 255));
        lblAlertOutput.setText("Alerts output");

        javax.swing.GroupLayout pnlGraphicLayout = new javax.swing.GroupLayout(pnlGraphic);
        pnlGraphic.setLayout(pnlGraphicLayout);
        pnlGraphicLayout.setHorizontalGroup(
            pnlGraphicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 687, Short.MAX_VALUE)
        );
        pnlGraphicLayout.setVerticalGroup(
            pnlGraphicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 511, Short.MAX_VALUE)
        );

        btnStop.setText("Stop");
        btnStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStopActionPerformed(evt);
            }
        });

        jMenuBar1.setBackground(new java.awt.Color(94, 94, 94));

        jMenu1.setForeground(new java.awt.Color(255, 255, 255));
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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblMibOptions)
                                    .addComponent(lblChoseSearch)
                                    .addComponent(lblChooseIp)
                                    .addComponent(lblMinValue)
                                    .addComponent(lblMaxValue)
                                    .addComponent(lblInterval))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtInterval, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                                            .addComponent(txtMaxValue, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtMinValue, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnMinValue, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(btnMaxValue, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(btnInterval, javax.swing.GroupLayout.Alignment.TRAILING)))
                                    .addComponent(mibOptionsCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ipsCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(searchCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(lblAlertOutput)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                                .addComponent(btnStop, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnStartTool, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlGraphic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlGraphic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ipsCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblChooseIp))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(searchCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblChoseSearch))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(mibOptionsCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMibOptions))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMinValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMinValue)
                            .addComponent(btnMinValue))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMaxValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMaxValue)
                            .addComponent(btnMaxValue))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtInterval, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblInterval)
                            .addComponent(btnInterval))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnStartTool)
                            .addComponent(lblAlertOutput)
                            .addComponent(btnStop))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator3))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuNovaLeituraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuNovaLeituraActionPerformed
        getAgents();
    }//GEN-LAST:event_menuNovaLeituraActionPerformed

    private void searchComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchComboActionPerformed
        getMibOptionField();
    }//GEN-LAST:event_searchComboActionPerformed

    private void btnMinValueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinValueActionPerformed
        String input = txtMinValue.getText();
        if (tryParseFloat(input)) {
            minValue = Float.parseFloat(input);
            btnMinValue.setForeground(Color.green);
        } else {
            btnMinValue.setForeground(Color.red);
        }
    }//GEN-LAST:event_btnMinValueActionPerformed

    private void btnMaxValueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMaxValueActionPerformed
        String input = txtMaxValue.getText();
        if (tryParseFloat(input)) {
            maxValue = Float.parseFloat(input);
            btnMaxValue.setForeground(Color.green);
        } else {
            btnMaxValue.setForeground(Color.red);
        }
    }//GEN-LAST:event_btnMaxValueActionPerformed

    private void btnStartToolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartToolActionPerformed
        if (minValue > 0 && maxValue > 0 && minValue < maxValue) {
            Agent agent = network.getAgentByIp(ipsCombo.getSelectedItem().toString());
            MibOption option = (MibOption) searchCombo.getSelectedItem();
            String oid = option.getValue() + "." + mibOptionsCombo.getSelectedItem().toString();
            txtAlerts.setText(agent.getAgentInfo(oid));
            pnlGraphic.removeAll();
            series = new TimeSeries(1, Millisecond.class);
            TimeSeriesCollection dataset = new TimeSeriesCollection(series);
            lastValue = 10;
            series.add(new Millisecond(), 0);

            JFreeChart lineChart = ChartFactory.createTimeSeriesChart(
                    searchCombo.getSelectedItem().toString(),
                    "Time",
                    "Value",
                    dataset,
                    true, true, false
            );

            lineChart.setBackgroundPaint(Color.white);

            ChartPanel chartPanel = new ChartPanel(lineChart);
            chartPanel.setPreferredSize(pnlGraphic.getSize());
            JPanel panel = new JPanel();
            panel.add(chartPanel);
            JFrame frame = new JFrame();
            frame.add(panel);
            frame.pack();
            pnlGraphic.add(panel);
            pnlGraphic.revalidate();
            pnlGraphic.repaint();
            Thread t = new Thread() {
                @Override
                public void run() {
                    String agentIp = ipsCombo.getSelectedItem().toString();
                    MibOption option = (MibOption) searchCombo.getSelectedItem();
                    String oid = option.getValue() + "." + mibOptionsCombo.getSelectedItem().toString();
                    Agent agent = network.getAgentByIp(agentIp);
                    String agentInfo;
                    String fullResult;
                    double value;
                    double prevValue = 0;
                    runThread = true;
                    while (runThread) {
                        agentInfo = agent.getAgentInfo(oid);
                        if (agentInfo == null) {
                            value = 0;
                            series.add(new Millisecond(), 0);
                            txtAlerts.append("Falied to get agent info...\n");
                        } else {
                            fullResult = agentInfo.substring(agentInfo.indexOf("= ") + 2, agentInfo.indexOf("]"));
                            value = Double.parseDouble(fullResult);
                            if (prevValue == 0) {
                                prevValue = value - 1;
                            }
                            txtAlerts.append(agentInfo + getAlertStatus(value) + "\n");
                            series.add(new Millisecond(), value - prevValue);
                            prevValue = value;
                        }
                        try {
                            Thread.sleep(interval);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            };
            t.start();

        } else {
            JOptionPane.showMessageDialog(null, "Please inform valid maximum and\nminimum limits, and a search interval.", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnStartToolActionPerformed

    private void btnIntervalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIntervalActionPerformed
        String input = txtInterval.getText();
        if (tryParseInt(input)) {
            interval = Integer.parseInt(input);
            btnInterval.setForeground(Color.green);
        } else {
            btnInterval.setForeground(Color.red);
        }
    }//GEN-LAST:event_btnIntervalActionPerformed

    private void btnStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStopActionPerformed
        runThread = false;
    }//GEN-LAST:event_btnStopActionPerformed

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

    public String getAlertStatus(int value) {
        if (value < minValue) {
            return "Lower than minimum value!";
        } else if (value > maxValue) {
            return "Higher than maximum value!";
        } else {
            return "OK";
        }
    }

    public void getAgents() {
        ipsCombo.removeAllItems();
        readNetwork();
        network.agents.stream().forEach((agent) -> {
            ipsCombo.addItem(agent.ipAddress);
        });
    }

    public void readNetwork() {
        this.network = new Network();
    }

    public void addMibOptions() {
        searchCombo.addItem(new MibOption(".1.3.6.1.2.1.11.1", "snmpInPkts"));
        searchCombo.addItem(new MibOption(".1.3.6.1.2.1.11.2", "snmpOutPkts"));

        searchCombo.addItem(new MibOption(".1.3.6.1.2.1.6.10", "tcpInSegs"));
        searchCombo.addItem(new MibOption(".1.3.6.1.2.1.6.11", "tcpOutSegs"));

        searchCombo.addItem(new MibOption(".1.3.6.1.2.1.5.8", "icmpInEchos"));
        searchCombo.addItem(new MibOption(".1.3.6.1.2.1.5.21", "icmpOutEchos"));

        searchCombo.addItem(new MibOption(".1.3.6.1.2.1.2.2.1.10", "ifInOctetos"));
        searchCombo.addItem(new MibOption(".1.3.6.1.2.1.2.2.1.16", "ifOutOctetos"));
    }

    public void getMibOptionField() {
        mibOptionsCombo.removeAllItems();

        String option = searchCombo.getSelectedItem().toString();
        switch (option) {
            case "snmpInPkts":
                mibOptionsCombo.addItem("0");
                break;
            case "snmpOutPkts":
                mibOptionsCombo.addItem("0");
                break;
            case "tcpInSegs":
                mibOptionsCombo.addItem("0");
                break;
            case "tcpOutSegs":
                mibOptionsCombo.addItem("0");
                break;
            case "icmpInEchos":
                mibOptionsCombo.addItem("0");
                break;
            case "icmpOutEchos":
                mibOptionsCombo.addItem("0");
                break;
            case "ifInOctetos":
                mibOptionsCombo.addItem("1");
                mibOptionsCombo.addItem("2");
                mibOptionsCombo.addItem("3");
                break;
            case "ifOutOctetos":
                mibOptionsCombo.addItem("1");
                mibOptionsCombo.addItem("2");
                mibOptionsCombo.addItem("3");
                break;
        }
    }

    private boolean tryParseFloat(String value) {
        try {
            Float.parseFloat(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean tryParseInt(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInterval;
    private javax.swing.JButton btnMaxValue;
    private javax.swing.JButton btnMinValue;
    private javax.swing.JButton btnStartTool;
    private javax.swing.JButton btnStop;
    private javax.swing.JComboBox<String> ipsCombo;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblAlertOutput;
    private javax.swing.JLabel lblChooseIp;
    private javax.swing.JLabel lblChoseSearch;
    private javax.swing.JLabel lblInterval;
    private javax.swing.JLabel lblMaxValue;
    private javax.swing.JLabel lblMibOptions;
    private javax.swing.JLabel lblMinValue;
    private javax.swing.JRadioButtonMenuItem menuNovaLeitura;
    private javax.swing.JComboBox<String> mibOptionsCombo;
    private javax.swing.JPanel pnlGraphic;
    private javax.swing.JComboBox<MibOption> searchCombo;
    private javax.swing.JTextArea txtAlerts;
    private javax.swing.JTextField txtInterval;
    private javax.swing.JTextField txtMaxValue;
    private javax.swing.JTextField txtMinValue;
    // End of variables declaration//GEN-END:variables
}

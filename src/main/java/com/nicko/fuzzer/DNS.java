package com.nicko.fuzzer;

import javax.swing.*;
import java.awt.*;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class DNS {

    private final JFrame frame = new JFrame("URL Querier");
    private final JLabel header = new JLabel("", JLabel.CENTER);
    private final JLabel status = new JLabel("", JLabel.CENTER);
    private final JPanel panel = new JPanel();

    void dnsStart() {
            frame.setSize(600, 140);
            frame.setLayout(new GridLayout(3, 1));
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.add(header);
            frame.add(status);
            frame.add(panel);
            frame.setVisible(true);
        status.setSize(10, 10);
        panel.setLayout(new FlowLayout());

        header.setText("Consultar URL");
        JTextField URL = new JTextField(6);
        JButton resolve = new JButton("Buscar");

        JPanel ipPanel = new JPanel();
        ipPanel.setLayout(new GridLayout(3, 3));
        ipPanel.setBackground(Color.black);

        ipPanel.add(new JLabel("URL: "), BorderLayout.LINE_START);
        ipPanel.add(URL);
        ipPanel.add((resolve), BorderLayout.LINE_END);
        ipPanel.add(new JLabel(""), BorderLayout.LINE_END);
        ipPanel.add(new JLabel(""), BorderLayout.LINE_START);
        ipPanel.add(new JLabel(""));
        ipPanel.add(new JLabel(""), BorderLayout.LINE_END);
        ipPanel.add(new JLabel(""), BorderLayout.LINE_START);
        ipPanel.add(new JLabel(""));
        ipPanel.add(new JLabel(""), BorderLayout.LINE_END);

        resolve.addActionListener(e -> lookup(URL.getText()));

        panel.add(ipPanel);
        frame.setVisible(true);
    }
    void lookup(String URL) {
        try {
            InetAddress[] links = InetAddress.getAllByName(URL);
                for(InetAddress url : links) {
                    System.out.println("\nURL encontrada: " + url);
                }
        } catch (UnknownHostException err) {
            System.out.printf("\n" + "Não foi possível encontrar a URL %s", URL);
        }
    }

}

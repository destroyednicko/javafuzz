package com.nicko.fuzzer;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Dump {

    /**
     * Declares, and initializate the variables with modifiers.
     */
    private final JFrame frame = new JFrame("Dumpar Header");
    private final JLabel header = new JLabel("", JLabel.CENTER);
    private final JLabel status = new JLabel("", JLabel.CENTER);
    private final JPanel panel = new JPanel();

    // Create the Header copyier GUI.
    void dumpStart() {
        frame.setSize(600, 140);
        frame.setLayout(new GridLayout(3, 1));
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        status.setSize(10, 10);

        panel.setLayout(new FlowLayout());
        frame.add(header);
        frame.add(panel);
        frame.add(status);
        frame.setVisible(true);

        header.setText("Dumpar Header");

        JTextField URL = new JTextField(6);
        JButton URL_Reader = new JButton("Buscar Header");

        JPanel ipPanel = new JPanel();
        ipPanel.setLayout(new GridLayout(3, 3));
        ipPanel.setBackground(Color.black);

        ipPanel.add(new JLabel("Insira o URL: "), BorderLayout.LINE_START);
        ipPanel.add(URL);
        ipPanel.add(URL_Reader, BorderLayout.LINE_END);

        ipPanel.add(new JLabel(""), BorderLayout.LINE_START);
        ipPanel.add(new JLabel(""));
        ipPanel.add(new JLabel(""), BorderLayout.LINE_END);

        ipPanel.add(new JLabel(""), BorderLayout.LINE_START);
        ipPanel.add(new JLabel(""));
        ipPanel.add(new JLabel(""), BorderLayout.LINE_END);

        URL_Reader.addActionListener(e -> dump(URL.getText()));

        panel.add(ipPanel);
        frame.setVisible(true);

    }

    void dump(String input) {
        try {
            URL u = new URL(input);
            URLConnection uc = u.openConnection();
            System.out.printf("\nURL inserida: %s", uc.getURL());
            Map<String, List<String>> headers = uc.getHeaderFields();
            Set<Map.Entry<String, List<String>>> entrySet = headers.entrySet();
            for (Map.Entry<String, List<String>> entry : entrySet) {
                String header = entry.getKey();
                System.out.print(header);
                List<String> headerValues = entry.getValue();
                for (String value : headerValues) {
                    System.out.printf("\n : %s", value);
                }
                System.out.println(" ");
            }
        } catch (MalformedURLException err) {
            System.err.printf("\n%s não é uma URL válida", input);
        } catch (IOException e) {
            System.err.printf("\nUm erro ocorreu!\n%s", e);
        }
    }

}

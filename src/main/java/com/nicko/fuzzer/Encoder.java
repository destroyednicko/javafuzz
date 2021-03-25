package com.nicko.fuzzer;

import javax.swing.*;
import java.awt.*;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class Encoder {

    private final JFrame frame = new JFrame("Decoder e Encoder");
    private final JLabel header = new JLabel("", JLabel.CENTER);
    private final JLabel status = new JLabel("", JLabel.CENTER);
    private final JPanel panel = new JPanel();

    public void encoderStart() {
        frame.setSize(600, 140);
        frame.setLayout(new GridLayout(3, 1));
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        status.setSize(10, 10);

        panel.setLayout(new FlowLayout());

        frame.add(header);
        frame.add(panel);
        frame.add(status);
        frame.setVisible(true);

        header.setText("Decoder e Encoder");

        JTextField encode = new JTextField(6);
        JButton eButton = new JButton("Encode");
        JTextField decode = new JTextField(6);
        JButton dButton = new JButton("Decode");

        JPanel dePanel = new JPanel();
        dePanel.setLayout(new GridLayout(3, 3));
        dePanel.setBackground(Color.BLACK);

        dePanel.add(new JLabel("Decode: "), BorderLayout.LINE_START);
        dePanel.add(decode);
        dePanel.add(dButton, BorderLayout.LINE_END);
        dePanel.add(new JLabel("Encode: "), BorderLayout.LINE_START);
        dePanel.add(encode);
        dePanel.add(eButton, BorderLayout.LINE_END);
        dePanel.add(new JLabel(""), BorderLayout.LINE_START);
        dePanel.add(new JLabel(""));
        dePanel.add(new JLabel(""), BorderLayout.LINE_END);

        dButton.addActionListener(e -> {
            String result = URLDecoder.decode(decode.getText(), StandardCharsets.UTF_8);
            System.out.println(result);
        });

        eButton.addActionListener(e ->
                System.out.println(URLEncoder.encode(encode.getText(), StandardCharsets.UTF_8))
        );

        panel.add(dePanel);
        frame.setVisible(true);
    }
}

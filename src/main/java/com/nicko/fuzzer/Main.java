package com.nicko.fuzzer;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main {
    /**
     * TODO: Code a main-class. -> DONE
     * TODO: Document the class. -> ...
     * TODO: Make an API. -> Never
     * TODO: Add dependencies on 'pom.xml'. -> Not necessary.
     * TODO: Refactor the code. -> ...
     * TODO: Upload to Github. -> Done
     * TODO: Separate the code on classes. -> Done
     *
     * Só tenho a declarar que...
     * I'm only have to declare what...
     *
     * EU NÃO SEI O QUE ESTOU FAZENDO, OKAY?
     * I'M DON'T KNOW WHAT I'M MAKING, ALRIGHT?
     */

    /**
     * Declares, and initializate the variables with modifiers.
     */
    private final JFrame mFrame = new JFrame("NFZR"); // Define the GUI title.
    private final JLabel headerL = new JLabel("", JLabel.CENTER);
    private final JLabel statusL = new JLabel("", JLabel.CENTER);
    private final JPanel panel = new JPanel();
    static String banner =
            """
                    888b    888 8888888888 8888888888P 8888888b. \s
                    8888b   888 888              d88P  888   Y88b\s
                    88888b  888 888             d88P   888    888\s
                    888Y88b 888 8888888        d88P    888   d88P\s
                    888 Y88b888 888           d88P     8888888P" \s
                    888  Y88888 888          d88P      888 T88b  \s
                    888   Y8888 888         d88P       888  T88b \s
                    888    Y888 888        d8888888888 888   T88b\s
                    """; // Defines the ASCII of console.

    /**
     * The class constructor.
     */
    public Main() {
        gui();
    }

    /**
     * Start the program, and show the GUI.
     */
    public static void main(String[] args) {
        System.out.println(banner); // Print the banner on console.
        Main swingGui = new Main();
        swingGui.showLayout();
    }

    /**
     * Function create GUI.
     */
    public void gui() {
        mFrame.setSize(600, 135); // Define the size of gui
        mFrame.setLayout(new GridLayout(3, 3)); // ^^
        statusL.setSize(10, 10);

        /**
         * onClose event, when the MAIN GUI is closed, the program i'll stop.
         */
        mFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });

        // Add the 'frames' to main gui.
        panel.setLayout(new FlowLayout());
        mFrame.add(panel);
        mFrame.add(statusL);
        mFrame.add(headerL);
        mFrame.setVisible(true);
    }

    /**
     * The GUI 'designer'
     */
    private void showLayout() {
        headerL.setText("Simple 'fuzzer' made for CB Test. (don't use this.)"); // Define the 'footer' of program.

        /**
         * Add buttons to the gui.
         */
        JButton interfaceInfo = new JButton("Listar Interfaces de Rede");
        JButton dump = new JButton("Dumpar Header");
        JButton dns = new JButton("Buscar DNS");
        JButton deEncoder = new JButton("Codificar ou Decodificar");

        JPanel ipPanel = new JPanel();
               ipPanel.setLayout(new GridLayout(4, 3));
               ipPanel.setBackground(Color.black);
        ipPanel.add(interfaceInfo, BorderLayout.CENTER);
        ipPanel.add(dns);
        ipPanel.add((dump), BorderLayout.LINE_END);
        ipPanel.add(new JLabel(""), BorderLayout.LINE_END);
        ipPanel.add(new JLabel(""), BorderLayout.LINE_START);
        ipPanel.add(new JLabel(""));
        ipPanel.add(new JLabel(""), BorderLayout.LINE_END);
        ipPanel.add(new JLabel(""), BorderLayout.LINE_START);
        ipPanel.add(new JLabel(""));
        ipPanel.add(new JLabel(""), BorderLayout.LINE_END);

        /**
         * The button to create the gui of DNS Lookup or URL 'Querier'.
         */
        dns.addActionListener(e -> {
            DNS dnsObject = new DNS();
            dnsObject.dnsStart();
        });

        /**
         * The button what shows the ALL ethernet interfaces on console.
         */
        interfaceInfo.addActionListener(e -> {
            Handler h = new Handler();
            h.interfaceInfo();
        });

        /**
         * This shows the page header on console.
         */
        dump.addActionListener(e -> {
            statusL.setText("Dumpar Header");
            Dump d = new Dump();
            d.dumpStart();
        });

        /**
         * This function shows the Encoder/Decoder gui.
         */
        deEncoder.addActionListener(e -> {
            Encoder enc = new Encoder();
            enc.encoderStart();
        });

        panel.add(ipPanel);
        mFrame.setVisible(true);
    }
}

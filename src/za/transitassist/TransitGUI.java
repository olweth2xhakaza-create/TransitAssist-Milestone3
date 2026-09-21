package src.za.transitassist;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TransitGUI extends JFrame {
    
    // GUI Variables
    private JTextField originTF;
    private JTextField destTF;
    private JTextArea outputTA; 
    
    private JButton searchBtn;
    private JButton statsBtn;
    private JButton showAllBtn;
    private JButton clearBtn;
    
    // Backend manager
    private TransitManager manager;

    public TransitGUI() {
        // 1. Setup the window
        setTitle("Transit Assist - Group 07");
        setSize(700, 500); // Slightly wider and taller
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centers the window on your screen
        
        // Load your Milestone 3 data
        manager = new TransitManager();
        Main.loadSampleData(manager);

        // 2. Setup the Layout (BorderLayout is much better than GridLayout for the whole window)
        Container c = getContentPane();
        c.setLayout(new BorderLayout(10, 10));

        // --- TOP PANEL: Inputs ---
        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Search Criteria"));
        
        originTF = new JTextField(15);
        destTF = new JTextField(15);
        
        inputPanel.add(new JLabel("Enter Origin:", SwingConstants.LEFT));
        inputPanel.add(originTF);
        inputPanel.add(new JLabel("Enter Destination:", SwingConstants.LEFT));
        inputPanel.add(destTF);
        
        c.add(inputPanel, BorderLayout.NORTH);

        // --- CENTER PANEL: Output Text Area ---
        outputTA = new JTextArea();
        outputTA.setEditable(false);
        outputTA.setFont(new Font("Monospaced", Font.PLAIN, 13));
        outputTA.setLineWrap(true);
        outputTA.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(outputTA);
        c.add(scrollPane, BorderLayout.CENTER);

        // --- BOTTOM PANEL: Buttons ---
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        
        searchBtn = new JButton("Search Routes");
        showAllBtn = new JButton("Show All Routes");
        statsBtn = new JButton("Show Statistics");
        clearBtn = new JButton("Clear Screen");
        
        buttonPanel.add(searchBtn);
        buttonPanel.add(showAllBtn);
        buttonPanel.add(statsBtn);
        buttonPanel.add(clearBtn);
        
        c.add(buttonPanel, BorderLayout.SOUTH);

        // 3. Register Event Handlers
        searchBtn.addActionListener(new SearchHandler());
        showAllBtn.addActionListener(new ShowAllHandler());
        statsBtn.addActionListener(new StatsHandler());
        clearBtn.addActionListener(e -> outputTA.setText(""));
    }

    // --- Inner Classes for Button Actions ---

    private class SearchHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String origin = originTF.getText().trim();
            String dest = destTF.getText().trim();
            
            if (origin.isEmpty() || dest.isEmpty()) {
                JOptionPane.showMessageDialog(TransitGUI.this, 
                    "Please enter both an Origin and a Destination.", 
                    "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            outputTA.setText("Searching routes from " + origin + " to " + dest + "...\n\n");
            boolean found = false;
            
            for (int i = 0; i < manager.getRouteCount(); i++) {
                if (manager.getRoutes()[i].getOrigin().equalsIgnoreCase(origin) && 
                    manager.getRoutes()[i].getDestination().equalsIgnoreCase(dest)) {
                    
                    outputTA.append(manager.getRoutes()[i].getScreenText() + "\n\n");
                    found = true;
                }
            }
            
            if (!found) {
                outputTA.setText("No routes found from " + origin + " to " + dest + ".\nTry: Nongoma to Ulundi");
            }
        }
    }

    private class ShowAllHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            outputTA.setText("--- ALL " + manager.getRouteCount() + " ROUTES ---\n\n");
            for (int i = 0; i < manager.getRouteCount(); i++) {
                outputTA.append(manager.getRoutes()[i].getScreenText() + "\n\n");
            }
        }
    }

    private class StatsHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            outputTA.setText("--- TRANSIT ASSIST STATISTICS ---\n\n");
            double totalFare = 0;
            int count = manager.getRouteCount();
            
            for (int i = 0; i < count; i++) {
                totalFare += manager.getRoutes()[i].getFare();
            }
            
            outputTA.append("Total Routes: " + count + "\n");
            outputTA.append("Average Fare: R" + String.format("%.2f", totalFare / count) + "\n");
        }
    }

    // Main method to run the application
    public static void main(String[] args) {
        TransitGUI gui = new TransitGUI();
    }
}
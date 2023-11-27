package GUI;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import SQLite.DatabaseManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Chart extends JFrame {

    private int rowID;

    private Map<String, Integer> goalValues;
    private Map<String, Integer> actualValues;
    private DatabaseManager db = new DatabaseManager();

    public Chart(int rowID) {
        this.rowID = rowID;
        db.connectToDatabase();

        goalValues = fetchGoalDataFromDatabase(); // Fetch 
        actualValues = fetchActualDataFromDatabase(); // 

        db.closeConnection();

        setTitle("Macronutrient Tracking Chart");
        setSize(850, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel chartPanel = new ChartPanel();

        getContentPane().add(chartPanel, BorderLayout.CENTER);

         JButton backButton = new JButton("Back");
        backButton.setBackground(new Color(128, 128, 128));
        backButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            backButtonActionPerformed(e);
        }
    });

    chartPanel.add(backButton, BorderLayout.SOUTH);
    }

    public void buildButtons() {
         JButton backButton = new JButton("Back");
		 backButton.setBackground(new Color(128, 128, 128));
		 backButton.setBounds(100, 100, 89, 23);
		 backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backButtonActionPerformed(e);
			}
		});
		getContentPane().add(backButton);
    }
     public void backButtonActionPerformed(ActionEvent e) {
		UserData userdata = new UserData(rowID);
		userdata.setVisible(true);
		this.dispose();
	}

    private Map<String, Integer> fetchGoalDataFromDatabase() {
        Map<String, Integer> goalData = new HashMap<>();

        try {
            goalData.put("Fats", db.fatsGoal(rowID));
            goalData.put("Carbs", db.carbsGoal(rowID));
            goalData.put("Protein", db.proteinGoal(rowID));
            goalData.put("Calories", db.calorieGoal(rowID));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return goalData;
    }

    private Map<String, Integer> fetchActualDataFromDatabase() {
        Map<String, Integer> actualData = new HashMap<>();

        try {
            actualData.put("Fats", db.fatsAte(rowID));
            actualData.put("Carbs", db.carbsAte(rowID));
            actualData.put("Protein", db.proteinAte(rowID));
            actualData.put("Calories", db.calorieAte(rowID));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return actualData;
    }

    private class ChartPanel extends JPanel {

        public ChartPanel() {
        setLayout(new BorderLayout());
        }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            drawChart(g);
        }

        private void drawChart(Graphics g) {
            int barWidth = 90;
            int chartHeight = getHeight() - 50;

            // Draw axes
            g.setColor(Color.BLACK);
            g.drawLine(50, chartHeight, getWidth() - 50, chartHeight); // X-axis
            g.drawLine(50, chartHeight, 50, 20); // Y-axis

            // Draw axis labels
            int xLabelPosition = 50 + (getWidth() - 50) / (goalValues.size() * 2); 
            for (String nutrient : goalValues.keySet()) {
                g.drawString(nutrient, xLabelPosition, getHeight() - 5);
                xLabelPosition += (getWidth() - 50) / goalValues.size();
            }

            g.drawString("Macro Level", 10, getHeight() / 2);

            // Draw title
            g.setFont(new Font("Segoe UI", Font.BOLD, 20));
            g.drawString("Macronutrient Tracking Chart", (getWidth() - g.getFontMetrics().stringWidth("Macronutrient Tracking Chart")) / 2, 30);

            // Draw bars for each nutrient
            int xOffset = 0;
            for (String nutrient : goalValues.keySet()) {
                int goal = goalValues.get(nutrient);
                int actual = actualValues.get(nutrient);

                // Draw goal bar
                drawBar(g, nutrient + " Goal", goal, barWidth, new Color(70, 130, 180), xOffset);

                // Draw actual bar
                drawBar(g, nutrient + " Actual", actual, barWidth, new Color(135, 206, 250), xOffset + barWidth + 10);

                xOffset += 2 * (barWidth + 10);
            }

            
            drawKey(g);
        }

        private void drawKey(Graphics g) {
            int keyWidth = 150;
            int keyHeight = 60;
            int keyX = getWidth() - keyWidth - 20;
            int keyY = 20;

            
            g.setColor(Color.WHITE);
            g.fillRect(keyX, keyY, keyWidth, keyHeight);

            
            g.setColor(new Color(70, 130, 180));
            g.fillRect(keyX + 10, keyY + 10, 20, 20);

            g.setColor(new Color(135, 206, 250));
            g.fillRect(keyX + 10, keyY + 40, 20, 20);

            
            g.setColor(Color.BLACK);
            g.drawString("Goal", keyX + 40, keyY + 25);
            g.drawString("Actual", keyX + 40, keyY + 55);
        }

        private void drawBar(Graphics g, String label, int value, int barWidth, Color color, int xOffset) {
            int chartHeight = getHeight() - 0;

            int barHeight = (int) ((double) value / 100 * chartHeight);
            int x = 50 + xOffset;
            int y = chartHeight - barHeight - 50;

            g.setColor(color);
            g.fillRect(x, y, barWidth, barHeight);

            g.setColor(Color.BLACK);
            g.drawRect(x, y, barWidth, barHeight);

            // Draw labels
            //g.drawString(label, x + barWidth / 9 - label.length() * 1, getHeight() - 5);  // Adjusted the y-coordinate
            g.drawString(String.valueOf(value), x + barWidth / 2 - 10, y - 5);
        }
    }


  //  public static void main(String[] args) {
   //     int rowID = 1; // Replace with the actual rowID you want to fetch
   //     SwingUtilities.invokeLater(() -> {
   //         Chart chart = new Chart(rowID);
   //         chart.setVisible(true);
   //     });
  //  }
}

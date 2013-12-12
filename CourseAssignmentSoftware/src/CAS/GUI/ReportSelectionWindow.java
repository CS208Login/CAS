/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CAS.GUI;

import CAS.CourseAssignment;
import CAS.DataIO.DataIO;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Richard Hayes
 */
public class ReportSelectionWindow extends JFrame{
    
    JButton unfulfilledRequestButton;
    JButton courseButton;
    CourseAssignment courseAssignment;
    
    public ReportSelectionWindow(CourseAssignment courseAssignment) {
        setLayout(new GridLayout(2,1));
        this.courseAssignment = courseAssignment;
        buildPanels();
        pack();
        setVisible(true);
    }
    
    public void buildPanels() {
        JPanel topPanel = new JPanel();
        JPanel bottomPanel = new JPanel();
        topPanel.setLayout(new GridLayout(3, 1));
        GridLayout bottomPanelLayout = new GridLayout(1, 0);
        bottomPanelLayout.setHgap(20);
        bottomPanelLayout.setVgap(50);
        bottomPanel.setLayout(bottomPanelLayout);
        
        JLabel selectLabel = new JLabel("Please select the report you would like to view:");
        selectLabel.setHorizontalAlignment(JLabel.CENTER);
        topPanel.add(new JPanel());
        topPanel.add(selectLabel);
        topPanel.add(new JPanel());
        
        unfulfilledRequestButton = new JButton("Unfulfilled Request Report");
        unfulfilledRequestButton.addActionListener(new ButtonListener());
        courseButton = new JButton("Course Report");
        courseButton.addActionListener(new ButtonListener());
        
        bottomPanel.add(unfulfilledRequestButton);
        bottomPanel.add(courseButton);
        
        add(topPanel);
        add(bottomPanel);
    }
    
    private class ButtonListener implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
      if (e.getSource() == unfulfilledRequestButton)
      {
          JFrame jf = new JFrame();
          jf.setLayout(new BorderLayout());
          jf.setVisible(true);
          PrintWindow printWindow = new PrintWindow(DataIO.GetUnfulfilledRequestReport(courseAssignment.getCourses(), courseAssignment.getInstructors()));
          printWindow.setVisible(true);
          jf.add(printWindow);
          jf.pack();
      }
      else if (e.getSource() == courseButton)
      {
          JFrame jf = new JFrame();
          jf.setLayout(new BorderLayout());
          jf.setVisible(true);
          PrintWindow printWindow = new PrintWindow(DataIO.GetCourseReport(courseAssignment.getCourses(), true));
          printWindow.setVisible(true);
          jf.add(printWindow);
          jf.pack();
      }
    }
    }
}

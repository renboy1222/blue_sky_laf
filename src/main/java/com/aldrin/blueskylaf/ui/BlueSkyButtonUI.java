/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aldrin.blueskylaf.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicButtonUI;

/**
 *
 * @author Java Programming with Aldrin
 */
public class BlueSkyButtonUI extends BasicButtonUI {

    private static final Color defaultColor = new Color(51, 159, 214); // SteelBlue
    private static final Color hoverColor = new Color(0, 91, 184); // CornflowerBlue
    private static final Color clickColor = new Color(0, 68, 204); // RoyalBlue
    private static Color foregroundColor;

    public static ComponentUI createUI(JComponent c) {
        return new BlueSkyButtonUI();
    }

    @Override
    public void installUI(JComponent c) {
        super.installUI(c);
        AbstractButton button = (AbstractButton) c;
        button.setOpaque(false);
        button.setBackground(defaultColor);
        button.setBorderPainted(false);
        button.getForeground();
        button.setContentAreaFilled(false);
        setForegroundColor(button.getForeground());

        // Add mouse listener for hover and click effects
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(hoverColor); // Change color on hover
                button.repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(defaultColor); // Revert to default color
                button.repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                button.setBackground(clickColor); // Change color on click
                button.repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (button.contains(e.getPoint())) {
                    button.setBackground(hoverColor); // Revert to hover color if still hovering
                } else {
                    button.setBackground(defaultColor); // Revert to default color
                }
                button.repaint();
            }
        });
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        AbstractButton button = (AbstractButton) c;
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw the button background with the current color
        g2.setColor(button.getBackground());
        g2.fillRoundRect(0, 0, button.getWidth(), button.getHeight(), 8, 8);

        // Draw the button text
//        g2.setColor(Color.WHITE);
        g2.setColor(c.getForeground());
        FontMetrics fm = g2.getFontMetrics();
        int stringWidth = fm.stringWidth(button.getText());
        int stringHeight = fm.getAscent();
        g2.drawString(button.getText(), (button.getWidth() - stringWidth) / 2, (button.getHeight() + stringHeight) / 2 - 2);

        g2.dispose();
    }

    @Override
    public Dimension getPreferredSize(JComponent c) {
        return new Dimension(75, 25);
    }
    // Override the getPreferredSize method
//    @Override
//    public Dimension getPreferredSize(JComponent c) {
//        // Set a default preferred size
//        Dimension defaultSize = new Dimension(100, 40);
//
//        // If the JButton already has a set size, respect that
//        if (c.getPreferredSize() != null) {
//            return c.getPreferredSize();
//        }
//
//        return defaultSize;
//    }

    /**
     * @return the foregroundColor
     */
    public static Color getForegroundColor() {
        return foregroundColor;
    }

    /**
     * @param aForegroundColor the foregroundColor to set
     */
    public static void setForegroundColor(Color aForegroundColor) {
        foregroundColor = aForegroundColor;
    }
}

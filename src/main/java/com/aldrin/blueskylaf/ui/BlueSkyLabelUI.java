/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aldrin.blueskylaf.ui;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicLabelUI;

/**
 *
 * @author Java Programming with Aldrin
 */
public class BlueSkyLabelUI extends BasicLabelUI {

    public static ComponentUI createUI(JComponent c) {
        return new BlueSkyLabelUI();
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        JLabel label = (JLabel) c;
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(Color.WHITE);
        FontMetrics fm = g2.getFontMetrics();
        int stringWidth = fm.stringWidth(label.getText());
        int stringHeight = fm.getAscent();
        g2.drawString(label.getText(), (label.getWidth() - stringWidth) / 2, (label.getHeight() + stringHeight) / 2 - 2);

        g2.dispose();
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aldrin.blueskylaf.ui;

import javax.swing.*;
import javax.swing.plaf.basic.BasicTextFieldUI;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.RoundRectangle2D;
import javax.swing.plaf.ComponentUI;
import javax.swing.text.BadLocationException;
import javax.swing.text.Caret;
import javax.swing.text.JTextComponent;

/**
 *
 * @author Java Programming with Aldrin
 */
public class BlueSkyTextFieldUI extends BasicTextFieldUI {

    public static ComponentUI createUI(JComponent c) {
        return new BlueSkyTextFieldUI();
    }

    @Override
    protected void installListeners() {
        super.installListeners();
        getComponent().addKeyListener(new BackspaceKeyListener());

        getComponent().addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    JTextComponent textField = getComponent();
                    Caret caret = textField.getCaret();
                    int dot = caret.getDot();
                    int mark = caret.getMark();

                    if (dot != mark) {
                        // If text is highlighted, remove all text
                        textField.setText("");
                        e.consume(); // Prevent the default backspace behavior
                    }
                }
            }
        });
    }

    private Color backgroundColor = new Color(240, 240, 240);
    private Color borderColor = new Color(51, 159, 214);
    private boolean hasFocus = false;

    @Override
    protected void installDefaults() {
        super.installDefaults();
//        getComponent().setFont(new Font("Arial", Font.PLAIN, 14));
        getComponent().setForeground(Color.BLACK);
        getComponent().setBackground(backgroundColor);
        getComponent().setCaretColor(new Color(0, 153, 204));
        getComponent().setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        getComponent().setPreferredSize(new Dimension(71, 21));

        getComponent().setOpaque(false);
//        getComponent().setBorder(null); //adding default border

        Insets margin = (Insets) UIManager.get("TextField.margin");
        if (margin != null) {
            getComponent().setMargin(margin);
        }

        // Install default events
        getComponent().addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                hasFocus = true;
                borderColor = new Color(0, 91, 184);
                getComponent().repaint();
            }

            @Override
            public void focusLost(FocusEvent e) {
                hasFocus = false;
                borderColor = new Color(51, 159, 214);
                getComponent().repaint();
            }
        });

    }

    private static final int LEFT_INDENT = 10;

    @Override
    protected void paintSafely(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        JTextField textField = (JTextField) getComponent();

        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Paint the curved background
        Shape curvedShape = new RoundRectangle2D.Double(0, 0, textField.getWidth() - 1, textField.getHeight() - 1, 15, 15);
        g2d.setColor(textField.getBackground());
        g2d.fill(curvedShape);

        // Paint the border
        g2d.setColor(borderColor);
        g2d.setStroke(new BasicStroke(1));
        g2d.draw(curvedShape);

        // Paint the text
        super.paintSafely(g);
    }

    @Override
    protected void paintBackground(Graphics g) {
        // Do not paint the background to avoid default painting
    }

    private class BackspaceKeyListener extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            JTextComponent textField = getComponent();
            //adding margin 
            if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                try {
                    int caretPosition = textField.getCaretPosition();
                    if (caretPosition > 0) {
                        textField.getDocument().remove(caretPosition - 1, 1);

                    }
                } catch (BadLocationException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }



}

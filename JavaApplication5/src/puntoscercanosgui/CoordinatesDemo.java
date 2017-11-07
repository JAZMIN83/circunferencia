/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * Jazmin Patiño

 */
package puntoscercanosgui;

import Circuferencia.Circunferencia;
import Circuferencia.Punto;
import Circuferencia.PuntosAleatorios;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.event.MouseInputListener;

public class CoordinatesDemo {

    private JLabel label;
    private Point clickPoint, cursorPoint;
    private static double pi;
    
    private static final int NUMEROS_ALEATORIOS = 1000;
    private static final int DIMENSION_X = 500;
    private static final int DIMENSION_Y = DIMENSION_X;

    private void buildUI(Container container) {
        container.setLayout(new BoxLayout(container, BoxLayout.PAGE_AXIS));

        CoordinateArea coordinateArea = new CoordinateArea(this);
        container.add(coordinateArea);

        label = new JLabel();
        resetLabel();
        container.add(label);

        coordinateArea.setAlignmentX(Component.LEFT_ALIGNMENT);
        label.setAlignmentX(Component.LEFT_ALIGNMENT); // redundant
    }

    public void updateCursorLocation(int x, int y) {
        if (x < 0 || y < 0) {
            cursorPoint = null;
            updateLabel();
            return;
        }

        if (cursorPoint == null) {
            cursorPoint = new Point();
        }

        cursorPoint.x = x;
        cursorPoint.y = y;
        updateLabel();
    }

    public void updateClickPoint(Point p) {
        clickPoint = p;
        updateLabel();
    }

    public void resetLabel() {
        cursorPoint = null;
        updateLabel();
    }

    protected void updateLabel() {
        String text = "";

        if ((clickPoint == null) && (cursorPoint == null)) {
            text = "Click or move the cursor within the framed area.";
        } else {

            if (clickPoint != null) {
                // text += "Click en (" + clickPoint.x + ", " + clickPoint.y + "). ";
            }

            if (cursorPoint != null) {
                text += "Cursor en: (" + cursorPoint.x + ", " + cursorPoint.y + "). ";
                text += "Pi: (" + pi + "). ";
            }
        }

        label.setText(text);
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("CoordinatesDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        CoordinatesDemo controller = new CoordinatesDemo();
        controller.buildUI(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    public static class CoordinateArea extends JComponent implements MouseInputListener {

        //Point point = null;
        ArrayList<Point> points;

        CoordinatesDemo controller;

        Dimension preferredSize = new Dimension(DIMENSION_X, DIMENSION_Y);

        Color gridColor;

        private Circunferencia c = new Circunferencia((DIMENSION_X / 2) - 1);

        static int contador = 0;

        public CoordinateArea(CoordinatesDemo controller) {
            this.controller = controller;
            this.points = new ArrayList<>();
            // Add a border of 5 pixels at the left and bottom,
            // and 1 pixel at the top and right.
            //setBorder(BorderFactory.createMatteBorder(1, 5, 5, 1, Color.RED));

            addMouseListener(this);
            addMouseMotionListener(this);
            setBackground(Color.WHITE);
            setOpaque(true);

            c.procesar(NUMEROS_ALEATORIOS);
        }

        public Dimension getPreferredSize() {
            return preferredSize;
        }

        protected void paintComponent(Graphics g) {
            // Paint background if we're opaque.
            if (isOpaque()) {
                g.setColor(getBackground());
                g.fillRect(0, 0, getWidth(), getHeight());
            }

            // Paint 20x20 grid.
            g.setColor(Color.GRAY);
            //drawGrid(g, 20);

            drawCircle(g, 0);
            // If user has chosen a point, paint a small dot on top.

            for (int i = 0; i < points.size(); i++) {

                g.setColor(getForeground());
                g.drawOval(points.get(i).x - 2, points.get(i).y - 2, 4, 4);

                g.setColor(Color.RED);
                g.fillOval(points.get(i).x - 2, points.get(i).y - 2, 4, 4);

            }

            /*Calculador calculador = new Calculador();
             calculador.calcularMinimaDistancia(points); */
            /*if (points.size() > 1){
                
             g.setColor(getForeground());
             g.drawOval(points.get(calculador.indexPunto1).x - 2, points.get(calculador.indexPunto1).y - 2, 4, 4);
             g.setColor(Color.BLUE);
             g.fillOval(points.get(calculador.indexPunto1).x - 2, points.get(calculador.indexPunto1).y - 2, 4, 4);
                
             g.setColor(getForeground());
             g.drawOval(points.get(calculador.indexPunto2).x - 2, points.get(calculador.indexPunto2).y - 2, 4, 4);
             g.setColor(Color.BLUE);
             g.fillOval(points.get(calculador.indexPunto2).x - 2, points.get(calculador.indexPunto2).y - 2, 4, 4);
                
             }*/
        }

        // Draws a 20x20 grid using the current color.
        private void drawGrid(Graphics g, int gridSpace) {
            Insets insets = getInsets();
            int firstX = insets.left;
            int firstY = insets.top;
            int lastX = getWidth() - insets.right;
            int lastY = getHeight() - insets.bottom;

            // Draw vertical lines.
            int x = firstX;
            while (x < lastX) {
                g.drawLine(x, firstY, x, lastY);
                x += gridSpace;
            }

            // Draw horizontal lines.
            int y = firstY;
            while (y < lastY) {
                g.drawLine(firstX, y, lastX, y);
                y += gridSpace;
            }
        }

        private void drawCircle(Graphics g, int gridSpace) {
            g.setColor(getForeground());
            g.drawOval(1, 1, DIMENSION_X - 2, DIMENSION_Y - 2);
        }

        // Methods required by the MouseInputListener interface.
        public void mouseClicked(MouseEvent e) {
            /*int x = e.getX();
             int y = e.getY();
            
             Point point = new Point(x, y);
             points.add(point);*/

            //controller.updateClickPoint(point);
            repaint();
        }

        public void mouseMoved(MouseEvent e) {

            if (contador < NUMEROS_ALEATORIOS) {
                Punto p = c.getPuntosAleatorios().getPuntos().get(contador);
                contador++;

                Point point = new Point(p.getX() + (DIMENSION_X / 2), p.getY() + (DIMENSION_Y / 2));
                points.add(point);
                controller.updateClickPoint(point);
                pi = c.calcuarPi();
                repaint();
            }
            controller.updateCursorLocation(e.getX(), e.getY());            
        }

        public void mouseExited(MouseEvent e) {
            controller.resetLabel();
        }

        public void mouseReleased(MouseEvent e) {
        }

        public void mouseEntered(MouseEvent e) {
        }

        public void mousePressed(MouseEvent e) {
        }

        public void mouseDragged(MouseEvent e) {
        }
    }
}

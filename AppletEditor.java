import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.geom.Ellipse2D;

public class AppletEditor extends JFrame {
    private DrawingPanel drawPanel;
    private JPanel controlPanel;
    private JButton saveButton, addRectangleButton, addCircleButton, addTriangleButton, deleteButton, colorBackgroundButton, colorElementButton, colorSelectedElementButton;
    private ArrayList<DrawableElement> elements;
    private DrawableElement selectedElement;
    private DrawableElement resizingElement;
    private Point lastMousePosition;
    private Point clickOffset;
    private Color backgroundColor = Color.WHITE;
    private Color elementColor = Color.GRAY;

    public AppletEditor() {
        setTitle("Interactive Java Applet Editor");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        elements = new ArrayList<>();

        // Control Panel
        controlPanel = new JPanel();
        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));
        add(controlPanel, BorderLayout.WEST);

        addRectangleButton = new JButton("Add Rectangle");
        addRectangleButton.addActionListener(e -> addElement("Rectangle"));
        controlPanel.add(addRectangleButton);

        addCircleButton = new JButton("Add Circle");
        addCircleButton.addActionListener(e -> addElement("Circle"));
        controlPanel.add(addCircleButton);

        addTriangleButton = new JButton("Add Triangle");
        addTriangleButton.addActionListener(e -> addElement("Triangle"));
        controlPanel.add(addTriangleButton);

        deleteButton = new JButton("Delete Element");
        deleteButton.addActionListener(e -> deleteElement());
        controlPanel.add(deleteButton);

        colorBackgroundButton = new JButton("Set Background Color");
        colorBackgroundButton.addActionListener(e -> setBackgroundColor());
        controlPanel.add(colorBackgroundButton);

        colorElementButton = new JButton("Set Element Color");
        colorElementButton.addActionListener(e -> setElementColor());
        controlPanel.add(colorElementButton);

        // Add button to change the color of the selected element
        colorSelectedElementButton = new JButton("Set Selected Element Color");
        colorSelectedElementButton.addActionListener(e -> setSelectedElementColor());
        controlPanel.add(colorSelectedElementButton);

        saveButton = new JButton("Save as Applet Code");
        saveButton.addActionListener(e -> saveAppletCode());
        controlPanel.add(saveButton);

        // Drawing Panel
        drawPanel = new DrawingPanel();
        add(drawPanel, BorderLayout.CENTER);
    }

    private void addElement(String type) {
        DrawableElement element = null;
        switch (type) {
            case "Rectangle":
                element = new DrawableElement(100, 300, 150, 100, elementColor, "Rectangle");
                break;
            case "Circle":
                element = new DrawableElement(200, 200, 100, 100, elementColor, "Circle");
                break;
            case "Triangle":
                element = new DrawableElement(100, 100, 150, 75, elementColor, "Triangle");
                break;
        }
        elements.add(element);
        drawPanel.repaint();
    }

    private void deleteElement() {
        if (selectedElement != null) {
            elements.remove(selectedElement);
            selectedElement = null;
            drawPanel.repaint();
        }
    }

    private void setBackgroundColor() {
        backgroundColor = JColorChooser.showDialog(this, "Choose Background Color", backgroundColor);
        drawPanel.setBackground(backgroundColor);
        drawPanel.repaint();
    }

    private void setElementColor() {
        elementColor = JColorChooser.showDialog(this, "Choose Element Color", elementColor);
    }

    // Set the color of the selected element
    private void setSelectedElementColor() {
        if (selectedElement != null) {
            selectedElement.setColor(JColorChooser.showDialog(this, "Choose Color for Selected Element", selectedElement.getColor()));
            drawPanel.repaint();
        } else {
            JOptionPane.showMessageDialog(this, "Please select an element first!");
        }
    }

    private void saveAppletCode() {
        try (FileWriter writer = new FileWriter("GeneratedApplet.java")) {
            writer.write("import java.applet.Applet;\n");
            writer.write("import java.awt.*;\n\n");
            writer.write("public class GeneratedApplet extends Applet {\n");
            writer.write("    public void paint(Graphics g) {\n");
            writer.write("        g.setColor(Color.CYAN);\n");
            writer.write("        g.fillRect(0, 0, getWidth(), getHeight());\n");

            for (DrawableElement element : elements) {
                writer.write(element.getJavaCode());
            }
            writer.write("      //Generated Using Kenny's AppletEditor \n");
            writer.write("    }\n");
            writer.write("}\n");

            JOptionPane.showMessageDialog(this, "Applet code saved as GeneratedApplet.java!");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error saving file: " + ex.getMessage());
        }
    }

    private class DrawingPanel extends JPanel {
        public DrawingPanel() {
            setBackground(backgroundColor);
            addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent e) {
                    if (SwingUtilities.isLeftMouseButton(e)) {
                        for (int i = elements.size() - 1; i >= 0; i--) {
                            DrawableElement element = elements.get(i);
                            if (element.contains(e.getPoint())) {
                                selectedElement = element;
                                clickOffset = new Point(e.getX() - element.x, e.getY() - element.y);
                                break;  
                            }
                        }
                    } else if (SwingUtilities.isRightMouseButton(e)) {
                        for (int i = elements.size() - 1; i >= 0; i--) {
                            DrawableElement element = elements.get(i);
                            if (element.contains(e.getPoint())) {
                                resizingElement = element;
                                break;  
                            }
                        }
                    }
                    lastMousePosition = e.getPoint();
                }
            });

            addMouseMotionListener(new MouseAdapter() {
                public void mouseDragged(MouseEvent e) {
                    if (SwingUtilities.isLeftMouseButton(e) && selectedElement != null) {
                        selectedElement.setPosition(e.getX() - clickOffset.x, e.getY() - clickOffset.y);
                        repaint();
                    } else if (SwingUtilities.isRightMouseButton(e) && resizingElement != null) {
                        resizingElement.resize(e.getX() - lastMousePosition.x, e.getY() - lastMousePosition.y);
                        lastMousePosition = e.getPoint();
                        repaint();
                    }
                }

                public void mouseReleased(MouseEvent e) {
                    resizingElement = null;
                }
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (DrawableElement element : elements) {
                element.draw(g);
            }
        }
    }

    private class DrawableElement {
        private int x, y, width, height;
        private Color color;
        private String shapeType;
    
        public DrawableElement(int x, int y, int width, int height, Color color, String shapeType) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
            this.color = color;
            this.shapeType = shapeType;
        }
    
        public void draw(Graphics g) {
            g.setColor(color);
            switch (shapeType) {
                case "Rectangle":
                    g.fillRect(x, y, width, height);
                    break;
                case "Circle":
                    g.fillOval(x, y, width, height);
                    break;
                case "Triangle":
                    int[] xPoints = {x, x + width / 2, x + width};
                    int[] yPoints = {y + height, y - height, y + height};
                    g.fillPolygon(xPoints, yPoints, 3);
                    break;
            }
        }
    
        public void setPosition(int newX, int newY) {
            x = newX;
            y = newY;
        }
    
        public void resize(int dx, int dy) {
            width += dx;
            height += dy;
        }
    
        public boolean contains(Point p) {
            switch (shapeType) {
                case "Rectangle":
                    return new Rectangle(x, y, width, height).contains(p);
                case "Circle":
                    return new Ellipse2D.Float(x, y, width, height).contains(p);
                case "Triangle":
                    Polygon polygon = new Polygon(new int[]{x, x + width / 2, x + width}, new int[]{y + height, y - height, y + height}, 3);
                    return polygon.contains(p);
                default:
                    return false;
            }
        }
    
        public Color getColor() {
            return color;
        }
    
        public void setColor(Color color) {
            this.color = color;
        }
    
        public String getJavaCode() {
            StringBuilder code = new StringBuilder();
            code.append("        g.setColor(new Color(")
                .append(color.getRed()).append(", ")
                .append(color.getGreen()).append(", ")
                .append(color.getBlue()).append("));\n");
            
            switch (shapeType) {
                case "Rectangle":
                    code.append("        g.fillRect(").append(x).append(", ").append(y).append(", ").append(width).append(", ").append(height).append(");\n");
                    break;
                case "Circle":
                    code.append("        g.fillOval(").append(x).append(", ").append(y).append(", ").append(width).append(", ").append(height).append(");\n");
                    break;
                case "Triangle":
                    // Generate unique variable names for xPoints and yPoints
                    String xPointsVar = "xPoints_" + this.hashCode();
                    String yPointsVar = "yPoints_" + this.hashCode();
                    
                    code.append("        int[] ").append(xPointsVar).append(" = {" + x + ", " + (x + width / 2) + ", " + (x + width) + "};\n");
                    code.append("        int[] ").append(yPointsVar).append(" = {" + (y + height) + ", " + (y - height) + ", " + (y + height) + "};\n");
                    code.append("        g.fillPolygon(").append(xPointsVar).append(", ").append(yPointsVar).append(", 3);\n");
                    break;
            }
            return code.toString();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AppletEditor editor = new AppletEditor();
            editor.setVisible(true);
        });
    }
}

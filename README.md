# Interactive Java Applet Editor

This project is an interactive Java Applet Editor that allows users to add, move, resize, and delete basic shapes (Rectangle, Circle, Triangle) on a canvas. It also provides functionality to customize the colors of the background, elements, and selected elements. Finally, users can save their created applet as a Java code file, which can be used to generate a Java applet with the drawn elements.

## Features

- **Add Shapes:** Add Rectangles, Circles, and Triangles to the canvas.
- **Move Shapes:** Select and drag shapes to move them around the canvas.
- **Resize Shapes:** Right-click on a shape to resize it by dragging.
- **Delete Shapes:** Delete the selected shape from the canvas.
- **Color Customization:** Customize the background color, element colors, and the color of the selected element.
- **Save Applet Code:** Save the created applet as a `.java` file with the generated Java code for use in Java Applet development.

## Requirements

- Java 8 or higher
- Swing library for GUI components (comes with Java)

## How to Use

1. **Add Shapes:**
   - Click on the "Add Rectangle", "Add Circle", or "Add Triangle" buttons to add the corresponding shape to the canvas.
   
2. **Move Shapes:**
   - Click and drag a shape to move it to a new location on the canvas.

3. **Resize Shapes:**
   - Right-click on a shape and drag to resize it.

4. **Delete Shapes:**
   - Select a shape and click the "Delete Element" button to remove it from the canvas.

5. **Change Colors:**
   - Use the "Set Background Color" button to change the background color of the canvas.
   - Use the "Set Element Color" button to change the color of new shapes.
   - Use the "Set Selected Element Color" button to change the color of the currently selected shape.

6. **Save the Applet:**
   - Click the "Save as Applet Code" button to generate the Java code for your applet. The code will be saved as `GeneratedApplet.java` in your project directory.

## Installation

1. Clone the repository or download the source code.
2. Open the project in your preferred Java IDE (e.g., IntelliJ IDEA, Eclipse).
3. Run the `AppletEditor.java` file.

```bash
git clone https://github.com/Dev-ingame/AppletEditor/.git
cd AppletEditor
# Open the project in your IDE and run AppletEditor.java

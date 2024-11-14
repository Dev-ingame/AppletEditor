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

```

2. Open the project in your preferred Java IDE (e.g., IntelliJ IDEA, Eclipse).

3. **Run the Applet Editor:**
   - Locate the `AppletEditor.java` file inside your project directory.
   - Right-click on the `AppletEditor.java` file and select `Run` to start the app.
   
   Alternatively, you can run the app from the terminal:
   ```bash
   javac AppletEditor.java
   java AppletEditor
   ```

## Viewing the Output 
After running the app, you will see a GUI window where you can interact with the app:

1. **Canvas Area:** This is where you can add shapes (Rectangles, Circles, Triangles), move them around, and resize them.

2. **Buttons:** You will find buttons to change the background color, add shapes, delete shapes, and save the applet code.

   - Add Shapes: Add a shape by clicking on "Add Rectangle", "Add Circle", or "Add Triangle".
   - Move Shapes: Click on any shape and drag it to move it around the canvas.
   - Resize Shapes: Right-click on a shape to resize it by dragging the resizing handle.
   - Delete Shapes: Select a shape and click the "Delete Element" button to remove it from the canvas.
   - Change Colors: Use the color picker buttons to customize the colors of the background, shapes, and the selected shape.
   - Once you're done creating your applet, you can click on the "Save as Applet Code" button to generate the Java code. The generated code will be saved as a .java file in your project directory.

## How to Contribute 
If you’d like to contribute to the project, follow these steps:

Fork the repository.
1. Create a new branch (`git checkout -b feature-name`).
2. Commit your changes (`it commit -am 'Add feature'`).
3. Push to the branch (`git push origin feature-name`).
4. Create a new pull request.

## Troubleshooting
- **Java Version:** Make sure you are using Java 8 or higher. The application relies on Swing components which require this version.

- **IDE Configuration:** If you are having trouble running the app from your IDE, ensure that the Java SDK is properly configured.

- **Missing Classes or Errors:** If there are missing classes or any runtime errors, check your IDE’s console for details on what may need to be fixed.

## License
This project is licensed under the APACHE License - see the LICENSE file for details.

Enjoy creating and customizing your applets with the Interactive Java Applet Editor! 🎨👾


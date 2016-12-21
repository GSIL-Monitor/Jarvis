package heiheihei.d0175_mosaic_paint;// CS 0401 Fall 2016
// Assignment 5 "starter" program.  You may use this as a starting point for
// Assignment 5.  

// Note 1: You will only receive credit for your additions and not for any of
// the functionality that is already provided.

// Note 2: You are not obliged to use this code at all.  If you can implement
// the requirements of Assignment 5 from scratch with your own code, that is
// also fine.  However, you must use the Mosaic, MCircle and MSquare classes
// as given without any changes.

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
import java.awt.print.*;

public class Assig5 {
    public static String software = "Mosaic Art 1.0";
    private Mosaic m;
    private DrawPanel thePanel;    // DrawPanel is a subclass of JPanel
    // See details below.
    private JPanel buttonPanel;
    private JFrame theWindow;
    private JButton paintIt, eraseIt, editIt;

    // ArrayList of Mosaic to store the individual shapes.  Note that
    // since Mosaic is the superclass of both MCircle and MSquare, both
    // shapes can be stored in this ArrayList
    private ArrayList<Mosaic> chunks;

    private double X, Y;
    private double newSize;
    private Color newColor;
    private int selected;

    private boolean painting, erasing, editing;
    private boolean paintCircle, paintSquare;
    private boolean saved;
    private String currFile;

    private JMenuBar theBar;
    private JMenu fileMenu, defaultsMenu, effectsMenu;
    private JMenuItem newFile, openFile, saveFile, saveAsFile, saveAsJPGFile, printFile, exitFile;
    private JMenuItem setColor, setSize, setShape;
    private JMenuItem square, circle;
    private JMenuItem recolor, resize;

    public Assig5() {
        theWindow = new JFrame(software);
//		theWindow.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        theWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        thePanel = new DrawPanel(600, 600);
        newSize = 15;
        newColor = Color.RED;

        selected = -1;
        saved = false;
        painting = false;
        erasing = false;
        paintCircle = true;
        paintIt = new JButton("Paint");
        eraseIt = new JButton("Erase");
        editIt = new JButton("Edit");
        ActionListener bListen = new ButtonListener();
        paintIt.addActionListener(bListen);
        eraseIt.addActionListener(bListen);
        editIt.addActionListener(bListen);
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 3));
        buttonPanel.add(paintIt);
        buttonPanel.add(eraseIt);
        buttonPanel.add(editIt);
        theWindow.add(buttonPanel, BorderLayout.SOUTH);
        theWindow.add(thePanel, BorderLayout.NORTH);

        theBar = new JMenuBar();
        theWindow.setJMenuBar(theBar);
        fileMenu = new JMenu("File");
        theBar.add(fileMenu);
        newFile = new JMenuItem("New");
        openFile = new JMenuItem("Open");
        saveFile = new JMenuItem("Save");
        saveAsFile = new JMenuItem("Save As");
        saveAsJPGFile = new JMenuItem("Save As JPG");
        printFile = new JMenuItem("Print");
        exitFile = new JMenuItem("Exit");
        fileMenu.add(newFile);
        fileMenu.add(openFile);
        fileMenu.add(saveFile);
        fileMenu.add(saveAsFile);
        fileMenu.add(saveAsJPGFile);
        fileMenu.add(printFile);
        fileMenu.add(exitFile);
        newFile.addActionListener(bListen);
        openFile.addActionListener(bListen);
        saveFile.addActionListener(bListen);
        saveAsFile.addActionListener(bListen);
        saveAsJPGFile.addActionListener(bListen);
        printFile.addActionListener(bListen);
        exitFile.addActionListener(bListen);


        defaultsMenu = new JMenu("Defaults");
        theBar.add(defaultsMenu);
        setColor = new JMenuItem("Set Color");
        setSize = new JMenuItem("Set Size");
        setShape = new JMenu("Set Shape");
        defaultsMenu.add(setColor);
        defaultsMenu.add(setSize);
        defaultsMenu.add(setShape);
        setColor.addActionListener(bListen);
        setSize.addActionListener(bListen);

        square = new JMenuItem("Square");
        circle = new JMenuItem("Circle");
        setShape.add(square);
        setShape.add(circle);
        square.addActionListener(bListen);
        circle.addActionListener(bListen);

        effectsMenu = new JMenu("Effects");
        theBar.add(effectsMenu);

        theWindow.pack();
        theWindow.setVisible(true);
        theWindow.setLocationRelativeTo(null);
    }

    private class DrawPanel extends JPanel {
        private int prefwid, prefht;

        // Initialize the DrawPanel by creating a new ArrayList for the images
        // and creating a MouseListener to respond to clicks in the panel.
        public DrawPanel(int wid, int ht) {
            prefwid = wid;
            prefht = ht;

            chunks = new ArrayList<Mosaic>();

            // Add MouseListener to this JPanel to respond to the user
            // pressing the mouse.  In your assignment you will also need a
            // MouseMotionListener to respond to the user dragging the mouse.
            addMouseListener(new MListen());
            addMouseMotionListener(new MListen());
        }

        public void clear() {
            chunks = new ArrayList<>();
            repaint();
        }

        // This method allows a window that encloses this panel to determine
        // how much space the panel needs.  In particular, when the "pack()"
        // method is called from an outer JFrame, this method is called
        // implicitly and the result determines how much space is needed for
        // the JPanel
        public Dimension getPreferredSize() {
            return new Dimension(prefwid, prefht);
        }

        // This method is responsible for rendering the images within the
        // JPanel.  You should not have to change this code.
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            for (int i = 0; i < chunks.size(); i++) {
                chunks.get(i).draw(g2d);
            }
        }

        // Add a new Mosaic and repaint.  The repaint() method call requests
        // that the panel be redrawn.  Make sure that you call repaint()
        // after changes to your scenes so that the changes are actually
        // exhibited in the display.
        public void add(Mosaic m) {
            chunks.add(m);
            repaint();
        }

        // Remove the Mosaic at index i and repaint
        public void remove(int i) {
            if (chunks.size() > i)
                chunks.remove(i);
            repaint();
        }

        public void move(int i, double x, double y) {
            if (chunks.size() > i)
                chunks.get(i).move(x, y);
            repaint();
        }

        public void redraw(int i, boolean highlight) {
            m = chunks.get(i);
            chunks.remove(i);
            m.highlight(highlight);
            chunks.add(m);
            repaint();
        }

        public void redraw(int i, boolean highlight, Color color) {
            m = chunks.get(i);
            chunks.remove(i);
            m.highlight(highlight);
            m.setColor(color);
            chunks.add(m);
            repaint();
        }

        public void redraw(int i, boolean highlight, double size) {
            m = chunks.get(i);
            chunks.remove(i);
            m.highlight(highlight);
            m.setSize(size);
            chunks.add(m);
            repaint();
        }

        // Select a Mosaic that contains the point (x, y).  Note that this
        // is using the contains() method of the Mosaic class, which in turn
        // is checking within the underlying RectangularShape of the object.
        public int select(double x, double y) {
            for (int i = 0; i < chunks.size(); i++) {
                if (chunks.get(i).contains(x, y)) {
                    return i;
                }
            }
            return -1;
        }

        public Mosaic get(double x, double y) {
            for (int i = 0; i < chunks.size(); i++) {
                if (chunks.get(i).contains(x, y)) {
                    return chunks.get(i);
                }
            }
            return null;
        }
    }

    // Save the images within the window to a file.  Run this program to see the
    // format of the saved file.
    public void saveImages() {
        try {
            PrintWriter P = new PrintWriter(new File(currFile));
            P.println(chunks.size());
            for (int i = 0; i < chunks.size(); i++) {
                P.println(chunks.get(i).saveFile());
            }
            P.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(theWindow, "I/O Problem - File not Saved");
        }
    }

    public void loadImage(File file) {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(file));
            int len = Integer.parseInt(reader.readLine());
            chunks = new ArrayList<>(len);
            String s;
            while ((s = reader.readLine()) != null) {
                String kind = s.split(",")[0];
                double width = Double.parseDouble(s.split(",")[1]);
                double centerX = Double.parseDouble(s.split(",")[2]);
                double centerY = Double.parseDouble(s.split(",")[3]);
                int red = Integer.parseInt(s.split(",")[4].split(":")[0]);
                int green = Integer.parseInt(s.split(",")[4].split(":")[1]);
                int blue = Integer.parseInt(s.split(",")[4].split(":")[2]);
                if (kind.equals("Circle")) {
                    chunks.add(new MCircle(width, centerX, centerY, new Color(red, green, blue)));
                } else {
                    chunks.add(new MSquare(width, centerX, centerY, new Color(red, green, blue)));
                }
            }
            thePanel.repaint();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // Listener for some buttons.  Note that the JMenuItems are also listened
    // for here.  Like JButtons, JMenuItems also generate ActionEvents when
    // they are clicked on.  You will need to add more JButtons and JMenuItems
    // to your program and the logic of handling them will also be more
    // complex.  See details in the Assignment 5 specifications.
    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == paintIt) {
                painting = true;
                paintIt.setForeground(Color.RED);
                erasing = false;
                eraseIt.setForeground(Color.BLACK);
                editing = false;
                editIt.setForeground(Color.BLACK);
            } else if (e.getSource() == eraseIt) {
                painting = false;
                paintIt.setForeground(Color.BLACK);
                erasing = true;
                eraseIt.setForeground(Color.RED);
                editing = false;
                editIt.setForeground(Color.BLACK);
            } else if (e.getSource() == editIt) {
                painting = false;
                paintIt.setForeground(Color.BLACK);
                erasing = false;
                eraseIt.setForeground(Color.BLACK);
                editing = true;
                editIt.setForeground(Color.RED);
            } else if (e.getSource() == newFile) {
                if (currFile == null || currFile.equals("") || !saved) {
                    int a = JOptionPane.showConfirmDialog(theWindow, "Save Scene?");
                    if (a == 0) {
                        currFile = JOptionPane.showInputDialog(theWindow, "Enter new file name");
                        saveImages();
                        thePanel.clear();
                        saved = false;
                        newSize = 15;
                        newColor = Color.RED;
                        selected = -1;
                        painting = false;
                        erasing = false;
                        paintCircle = true;
                    }
                }
            } else if (e.getSource() == openFile) {
                JFileChooser jfc = new JFileChooser();
                jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
                jfc.showDialog(new JLabel(), "Choose file");
                File file = jfc.getSelectedFile();
                loadImage(file);
            } else if (e.getSource() == saveFile) {
                if (currFile == null || currFile.equals("")) {
                    int a = JOptionPane.showConfirmDialog(theWindow, "Save Scene?");
                    if (a == 0) {
                        currFile = JOptionPane.showInputDialog(theWindow, "Enter new file name");
                        saveImages();
                    } else {
                        saveImages();
                    }
                }
            } else if (e.getSource() == saveAsFile) {
                currFile = JOptionPane.showInputDialog(theWindow, "Enter new file name");
                saveImages();
                theWindow.setTitle(software + " - " + currFile);
            } else if (e.getSource() == exitFile) {
                System.exit(0);
            } else if (e.getSource() == printFile) {
                Printable thePPanel = new thePrintPanel(thePanel);
                PrinterJob job = PrinterJob.getPrinterJob();
                job.setPrintable(thePPanel);
                boolean ok = job.printDialog();
                if (ok) {
                    try {
                        job.print();
                    } catch (PrinterException ex) {
                      /* The job did not successfully complete */
                    }
                }
            } else if (e.getSource() == setColor) {
                newColor = JColorChooser.showDialog(null, "Set Default Color", newColor);
            } else if (e.getSource() == setSize) {
                String s = JOptionPane.showInputDialog(null, "Enter New Default Size");
                try {
                    newSize = Double.parseDouble(s);
                } catch (NumberFormatException en) {
                    JOptionPane.showMessageDialog(null, "Invalid format");
                }
            } else if (e.getSource() == square) {
                paintCircle = false;
            } else if (e.getSource() == circle) {
                paintCircle = true;
            }
        }
    }

    // Simple mouse event handling to allow a mousePressed to add or remove
    // a Mosaic from the display.  You will need to enhance this
    // MouseAdapter and you will also need to add a MouseMotionListener to
    // your program.  In this simple program all of the Mosaics drawn are
    // MCircles and they all have the same size and color.  You must add in
    // your program the ability to change all of these attributes.
    private class MListen extends MouseAdapter
//            Component implements MouseListener,MouseMotionListener
    {
//        public MListen(Component c) {
//            super(c);
//        }

        public void mousePressed(MouseEvent e) {
            switch (e.getButton()) {
                case 1:
//                    System.out.println(1);
                    X = e.getX();  // Get the location where mouse was pressed
                    Y = e.getY();
                    if (painting) {
                        // create new MCircle and add it to the ArrayList
                        if (paintCircle) {
                            m = new MCircle(newSize, X, Y, newColor);
                            thePanel.add(m);
                        } else {
                            m = new MSquare(newSize, X, Y, newColor);
                            thePanel.add(m);
                        }
                    } else if (erasing) {
                        // see if the point is within a shape -- if so delete
                        // that shape
                        int loc = thePanel.select(X, Y);
                        if (loc > -1) {
                            thePanel.remove(loc);
                        }
                    } else if (editing) {
                        m = thePanel.get(X, Y);
//                        System.out.println(X+" "+Y);
                    }
                    break;
                case 2:
//                    System.out.println(2);
                    break;
                case 3:
//                    System.out.println(3);
                    if (!editing) {
                        break;
                    }
                    int loc = thePanel.select(e.getX(), e.getY());
                    if (loc < 0) {
                        break;
                    }
                    JPopupMenu menu = new JPopupMenu();
                    recolor = new JMenuItem("Recolor");
                    resize = new JMenuItem("Resize");
                    menu.add(recolor);
                    menu.add(resize);
                    recolor.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ae) {
                            Color c = JColorChooser.showDialog(null, "Set Default Color", newColor);
                            thePanel.redraw(loc, false, c);
                        }
                    });
                    resize.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            String s = JOptionPane.showInputDialog(null, "Enter New Default Size");
                            double d = 0;
                            try {
                                d = Double.parseDouble(s);
                            } catch (NumberFormatException en) {
                                JOptionPane.showMessageDialog(null, "Invalid format");
                            }
                            thePanel.redraw(loc, false, d);
                        }
                    });

                    thePanel.redraw(loc, true);
                    menu.show(e.getComponent(), e.getX(), e.getY());
                    break;
            }
        }

        public void mouseDragged(MouseEvent e) {
            X = e.getX();
            Y = e.getY();
            if (erasing) {
                // see if the point is within a shape -- if so delete
                // that shape
                int loc = thePanel.select(X, Y);
                if (loc > -1) {
                    thePanel.remove(loc);
                }
            }
            if (editing && m != null) {
                int loc = thePanel.select(X, Y);
                if (loc > -1) {
                    thePanel.move(loc, X, Y);
                }
            }
        }

        public void mouseClicked(MouseEvent e) {

        }

        public void mouseReleased(MouseEvent e) {

        }

        public void mouseEntered(MouseEvent e) {

        }

        public void mouseExited(MouseEvent e) {

        }

        public void mouseMoved(MouseEvent e) {

        }

    }

//    private class PListener extends ComponentAdapter implements mou

    public static void main(String[] args) {
        new Assig5();
    }
}

// This class is taken from the Web and is somewhat buggy but it does a basic
// print of the panel.
class thePrintPanel implements Printable {
    JPanel panelToPrint;

    public int print(Graphics g, PageFormat pf, int page) throws
            PrinterException {
        if (page > 0) { /* We have only one page, and 'page' is zero-based */
            return NO_SUCH_PAGE;
        }

        /* User (0,0) is typically outside the imageable area, so we must
         * translate by the X and Y values in the PageFormat to avoid clipping
         */
        Graphics2D g2d = (Graphics2D) g;
        AffineTransform t = new AffineTransform();
        t.scale(0.9, 0.9);
        g2d.transform(t);
        g2d.translate(pf.getImageableX(), pf.getImageableY());
        //pf.setOrientation(PageFormat.REVERSE_LANDSCAPE);
        /* Now print the window and its visible contents */
        panelToPrint.printAll(g);

        /* tell the caller that this page is part of the printed document */
        return PAGE_EXISTS;
    }

    public thePrintPanel(JPanel p) {
        panelToPrint = p;
    }
}

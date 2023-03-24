package csd201_ws03_bst_finddelete_dohuynhanhvu_ce171446;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author Do Huynh Anh Vu - CE171446
 */
public class BSTPaper extends JPanel {

    private static final int FONT_SIZE = 12;
    BSTree tree;
    Graphics2D g;

    public BSTPaper(BSTree tree) {
        this.tree = tree;
    }

    public void addNode(int data) {
        tree.addNode(data);
        repaint();
    }
    
    public void deleteNode(int data) {
        this.tree.removeNode(data);
        this.tree.path.clear();
        repaint();
    }

    public void drawPath() {
        repaint();
    }

    public void drawCenteredString(Graphics g, String text, Rectangle rect, Font font) {
        // Get the FontMetrics
        FontMetrics metrics = g.getFontMetrics(font);
        // Determine the X coordinate for the text
        int x = rect.x + ((rect.width - metrics.stringWidth(text)) / 2);
        // Determine the Y coordinate for the text (note we add the ascent, as in java 2d 0 is on top)
        int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
        // Set the font
        g.setFont(font);
        g.drawString(text, x, y);
    }

    public void drawNode(BSTNode node) {
        if (node == null) {
            return;
        }

        int r = 10;
        int x = node.getX();
        int y = node.getY();

        g.setColor(Color.BLACK);
        //draw line from parent to left child
        if (node.hasLeftChild()) {
            g.drawLine(x, y, node.getLeftChild().getX(), node.getLeftChild().getY());
        }

        //draw line from parent to right child
        if (node.hasRightChild()) {
            g.drawLine(x, y, node.getRightChild().getX(), node.getRightChild().getY());
        }

        //draw fill circle
        g.setColor(Color.WHITE);
        g.fillOval(x - r, y - r, r * 2, r * 2);

        //draw outline
        g.setColor(Color.BLACK);
        g.drawOval(x - r, y - r, r * 2, r * 2);

        //draw node data
        drawCenteredString(g, node.getData() + "",
                new Rectangle(x - r, y - r, r * 2, r * 2),
                new Font("Arial", Font.PLAIN, FONT_SIZE));
        //draw node count
        drawCenteredString(g, "c = " + node.getCount(),
                new Rectangle(x - r, y + r, r * 2, r * 2),
                new Font("Arial", Font.PLAIN, FONT_SIZE));

        drawNode(node.getLeftChild());
        drawNode(node.getRightChild());
    }

    @Override
    public void paint(Graphics grphcs) {
        super.paint(grphcs); //To change body of generated methods, choose Tools | Templates.

        this.g = (Graphics2D) grphcs;
        drawNode(this.tree.getRoot());

        ArrayList<BSTNode> path = this.tree.getPath();
        if (path.size() > 0) {
            //draw line
            int x, y;
            BSTNode n1, n2;
            int r = 10;
            g.setColor(Color.red);
            for (int i = 0; i < path.size(); i++) {
                n1 = path.get(i);
                x = n1.getX();
                y = n1.getY();

                //draw fill circle
                g.setColor(Color.YELLOW);
                g.fillOval(x - r, y - r, r * 2, r * 2);

                //draw outline
                g.setColor(Color.RED);
                g.drawOval(x - r, y - r, r * 2, r * 2);

                //draw node data in circle
                drawCenteredString(g, n1.getData() + "",
                        new Rectangle(x - r, y - r, r * 2, r * 2),
                        new Font("Arial", Font.PLAIN, FONT_SIZE));

                //draw node count
                drawCenteredString(g, "c = " + n1.getCount(),
                        new Rectangle(x - r, y + r, r * 2, r * 2),
                        new Font("Arial", Font.PLAIN, FONT_SIZE));
            }
        }
    }
}

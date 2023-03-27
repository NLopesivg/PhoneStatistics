import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class fileDialog {

    private static String sourceRoute;

   public static String createWindow() {
        JFrame frame = new JFrame("Swing Tester");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createUI(frame);
        frame.setSize(560, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        return sourceRoute;
    }


    private static void createUI(final JFrame frame){
        JPanel panel = new JPanel();
        LayoutManager layout = new FlowLayout();
        panel.setLayout(layout);

        JButton button = new JButton("Click Me!");
        JButton next = new JButton("Seguinte");
        final JLabel label = new JLabel();

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int option = fileChooser.showOpenDialog(frame);
                if(option == JFileChooser.APPROVE_OPTION){
                    File source = fileChooser.getSelectedFile();
                    label.setText("File Selected: " + source.getName());
                    sourceRoute = source.getPath();
                    try {
                        interpretDocument.csvReader(sourceRoute);
                    } catch (FileNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                }else{
                    label.setText("Open command canceled");
                }
            }
        });

        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });

        panel.add(button);
        panel.add(label);
        panel.add(next);
        frame.getContentPane().add(panel, BorderLayout.CENTER);
    }

}

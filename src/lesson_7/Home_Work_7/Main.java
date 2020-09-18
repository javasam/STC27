package lesson_7.Home_Work_7;

import java.net.MalformedURLException;

import static javax.swing.SwingUtilities.invokeLater;

public class Main {
    public static void main(String[] args) throws MalformedURLException {
        Window window = new Window();
        invokeLater(window);
    }
}

package restaurant;

import javax.swing.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // TEST THE DATABASE CONNECTION
    java.sql.Connection testConn = DatabaseConnection.getConnection();
    if (testConn != null) {
        System.out.println("Success! Connected to Krusty Krab Database.");
    } else {
        System.out.println("Failure! Check your MySQL password.");
    }
    
    
        javax.swing.SwingUtilities.invokeLater(() -> {
              SoundPlayer.playBackgroundMusic();
            Welcome form = new Welcome();
            form.setVisible(true);
        });
      
        }
    }


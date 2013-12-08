package se;

import entity.Solution;
import readwriter.FileManager;

/**
 *
 * @author Rafał
 */
public class SE {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        
        FileManager fileManager = new FileManager();
        fileManager.readFileSolution("resources/solution.txt");
        fileManager.readFileInstance("resources/instance.txt");
        Solution solution = fileManager.getSolution();
    }
}

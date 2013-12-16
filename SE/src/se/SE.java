package se;


import entity.Route;
import entity.Solution;
import gui.SEFrame;
import readwriter.DBManager;
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
        
        DBManager db = new DBManager();
        db.create(solution);
        
        SEFrame frame = new SEFrame();
        
        
    }
}

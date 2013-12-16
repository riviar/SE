package readwriter;

import entity.Route;
import entity.Solution;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import tools.Validator;

/**
 *
 * @author Adam Szaraniec
 */
public class FileManager {

    String dataSolution = null;
    String dataInstance = null;
    Validator validator;
    
    public FileManager(){
        validator = new Validator();
    }
    
    public void readFileInstance(String filename) {
        String content = null;
        File file = new File(filename);
        try {
            FileReader reader = new FileReader(file);
            char[] chars = new char[(int) file.length()];
            reader.read(chars);
            content = new String(chars);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        dataInstance =  content;
    }
    
    public void readFileSolution(String filename) {
        String content = null;
        File file = new File(filename);
        try {
            FileReader reader = new FileReader(file);
            char[] chars = new char[(int) file.length()];
            reader.read(chars);
            content = new String(chars);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (validator.checkSolution(content)) {
            dataSolution =  content;
        } else {
            System.err.println("Dupa");
        }
        
    }

    
    public Solution getSolution() throws Exception {
        if (this.dataSolution == null ||  this.dataInstance == null) {
            throw new Exception("First load a file");
        }
        
        Solution solution = new Solution();
        String[] solutionLines = dataSolution.split("\n");
        String[] instanceLines = dataInstance.split("\n");
        String tmp[];
        
        tmp = solutionLines[0].split("Instance Name: "); 
        solution.setInstance(tmp[1]);
        
        tmp = solutionLines[1].split("Authors: "); 
        solution.setAuthors(tmp[1]);
        
        tmp = solutionLines[2].split("Date: ");      
        solution.setDate(new SimpleDateFormat("dd-MM-yyyy").parse(tmp[1]));
        
        tmp = solutionLines[3].split("Reference: "); 
        solution.setReference(tmp[1]);
        
        tmp = instanceLines[3].split(" ");
        solution.setNumberofvehicles(Integer.parseInt(tmp[0]));
        solution.setCapacity(Integer.parseInt(tmp[1].substring(0, tmp[1].length() - 1)));
        
        
        for (int i = 6; i < instanceLines.length; i++ ) {
            Route route = new Route();
            route.setData(instanceLines[i]);
            solution.addRoute(route);
        }

        return solution;
    }
}

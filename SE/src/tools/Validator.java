/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

/**
 *
 * @author Rafał
 */
public class Validator {
    
    private String[] requiredFields = {
        "Instance Name",
        "Authors",
        "Date",
        "Reference",
        "Solution",
        "Route"
    } ;
    
    private String[] instanceName ;
    private String[] authors ;
    private String[] date ;
    private String[] reference ;
    private String[] routes ;
    
    private String instanceNamePattern = "#Instance Name://s*([a-zA-Z0-9_//-//s]+)/s*#" ;
    private String authorsPattern = "#Authors://s*([a-zA-Z0-9//s//-//,]+)//s*#" ;
    private String datePattern = "#Date://s*(//d{2}-//d{2}-//d{2})//s*#" ;
    private String referencePattern = "#Reference://s*([a-zA-Z0-9_-]+)//s*" ;
    private String routePattern = "#Route//s*(//d+)//s*://s*([0-9//s]+)#" ;
    
    public boolean checkSolution(String fileContent) {
        
        int oks = 0 ;
        String[] lines = fileContent.split("\n") ;
        
        for (int i=0;i<lines.length;i++) {
            for (int j=0;j<requiredFields.length;j++) {
                if(lines[i].contains(requiredFields[j])) {
                    if (requiredFields[j].equals("Route")) 
                        routes = lines[i].split(routePattern) ;
                    if (requiredFields[j].equals("Reference"))
                        reference = lines[i].split(referencePattern) ;
                    if (requiredFields[j].equals("Date"))
                        date = lines[i].split(datePattern) ;
                    if (requiredFields[j].equals("Authors"))
                        authors = lines[i].split(authorsPattern) ;
                    if (requiredFields[j].equals("Instance Name"))
                        instanceName = lines[i].split(instanceNamePattern) ;
                    
                    oks++ ;
                }
            }
        }
        
        if (oks >= requiredFields.length)
            return true ;
        else return false ;
    }

    /**
     * @return the instanceName
     */
    public String[] getInstanceName() {
        return instanceName;
    }

    /**
     * @return the authors
     */
    public String[] getAuthors() {
        return authors;
    }

    /**
     * @return the date
     */
    public String[] getDate() {
        return date;
    }

    /**
     * @return the reference
     */
    public String[] getReference() {
        return reference;
    }

    /**
     * @return the routes
     */
    public String[] getRoutes() {
        return routes;
    }
}
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Properties;
import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {

        Properties props = new Properties();
        props.load(new FileInputStream("autosorter.properties"));

        String sourceFolderPath = null;
        ArrayList<FolderRule> foldersRules = new ArrayList<FolderRule>();
        for(String key : props.stringPropertyNames()){
            if(!key.equals("folder_path")){
                foldersRules.add(new FolderRule(key, props.getProperty(key).split(",")));
            }else
                sourceFolderPath = props.getProperty(key);
        }

        System.out.println(sourceFolderPath + "\n");
        FolderRule fr[] = foldersRules.toArray(new FolderRule[0]);
        for(int i = 0 ; i < fr.length; i++){
            System.out.println(fr[i]);
        }

        AutoSorter as = new AutoSorter(sourceFolderPath, foldersRules.toArray(new FolderRule[0])); 
        
        switch (as.sort()) {
            case 0:
                JOptionPane.showMessageDialog(null, "Operation completed in " + sourceFolderPath , "Message" , JOptionPane.INFORMATION_MESSAGE);
                break;
            case -1:
                JOptionPane.showMessageDialog(null, "Entered path doesn't exist" , "Error!" , JOptionPane.ERROR_MESSAGE);
                break;
            case -2:
                JOptionPane.showMessageDialog(null, "Entered path is a file or not a folder" , "Error!" , JOptionPane.ERROR_MESSAGE);
                break;
            case -3:
                JOptionPane.showMessageDialog(null, "Folder doesn't have read/write perms" , "Error!" , JOptionPane.ERROR_MESSAGE);
                break;
            
        }
    }
}

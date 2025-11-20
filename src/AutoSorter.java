import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;



public class AutoSorter {

    private String sourceFolderPath;
    private FolderRule foldersRules[];


    AutoSorter(String sourceFolderPath, FolderRule foldersRules[]){
        this.sourceFolderPath = sourceFolderPath;
        this.foldersRules = foldersRules;
    }

    public String getSourceFolderPath() {
        return sourceFolderPath;
    }

    public void setSourceFolderPath(String sourceFolderPath) {
        this.sourceFolderPath = sourceFolderPath;
    }

    private void baseSorting(File sourceFolder, String targetFolderName , String extensions[]){
        File targetFolder = new File(sourceFolder.getPath() + File.separator + targetFolderName);
        File[] files = sourceFolder.listFiles();
        if(!targetFolder.exists())
            targetFolder.mkdir();


        for(int i = 0; i < files.length ; i++){

            boolean control = false;
            for(String extension : extensions){
                if(files[i].toString().endsWith(extension)){
                    control = true;
                    break;
                }
            }

            if(control){
                try{
                    Files.move(Paths.get(files[i].getPath()), Paths.get(targetFolder.getPath() + File.separator +  files[i].getName()) );
                }catch(IOException e){
                    System.out.println(e.toString());
                }              
            }
        }
    }

    public int sort(){

        File sourceFolder = new File(sourceFolderPath);

        if(!sourceFolder.exists()){
            return -1; //entered path doesn't exist
        }else if(sourceFolder.isFile())
            return -2; //entered path is a file/not a folder
        else if(!sourceFolder.canWrite() || !sourceFolder.canRead())
            return -3; //folder doesn't have read/write perms
        
        for(int i = 0; i < foldersRules.length; i++){
            baseSorting(sourceFolder, foldersRules[i].getTargetFolder() , foldersRules[i].getLinkedExtensions());
        }
        
        return 0; //Successfull
    }
}

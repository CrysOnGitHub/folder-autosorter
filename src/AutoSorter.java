import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AutoSorter {

    private String source_folder_path;
    private String target_folders[]; 
    private String extensions_of_target_folders[][];



    AutoSorter(String source_folder_path, String target_folders[], String extensions_of_target_folders[][]){
        this.source_folder_path = source_folder_path;
        this.target_folders = target_folders;
        this.extensions_of_target_folders = extensions_of_target_folders;
    }

    public String getSource_folder_path() {
        return source_folder_path;
    }

    public void setSource_folder_path(String source_folder_path) {
        this.source_folder_path = source_folder_path;
    }

    private void baseSorting(File source_folder, String folder_name , String extensions[]){
        File target_folder = new File(source_folder.getPath() + "\\" + folder_name);
        File[] files = source_folder.listFiles();
        target_folder.mkdir();
        for(int i = 0; i < files.length ; i++){

            //checking extension match by scrolling the String array

            boolean control = false;
            for(String extension : extensions){
                if(files[i].toString().endsWith(extension)){
                    control = true;
                    break;
                }
            }

            if(control){
                try{
                    Files.move(Paths.get(files[i].toString()), Paths.get(target_folder.getPath() + "\\" +  files[i].getName()) );
                }catch(IOException e){
                    System.out.println(e.toString());
                }              
            }
        }
    }

    public int sort(){

        File source_folder = new File(source_folder_path);

        if(!source_folder.exists()){
            return -1; //entered path doesn't exist
        }else if(source_folder.isFile())
            return -2; //entered path is a file/not a folder
        else if(!source_folder.canWrite() && !source_folder.canWrite())
            return -3; //folder doesn't have read/write perms
        
        for(int i = 0; i < target_folders.length; i++){
            baseSorting(source_folder, target_folders[i], extensions_of_target_folders[i]);
        }
        
        return 0; //Successfull
    }
}

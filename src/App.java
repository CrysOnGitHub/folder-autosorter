public class App {
    public static void main(String[] args) throws Exception {

        //testing
        
        String path = "C:\\Users\\cryss\\Downloads\\ciao";
        String folders[] = {"Documenti" , "Audio" , "Immagini"};
        String extensions[][] = {
            {".pdf" , ".txt" , ".xlsx"},
            {".mp3"} ,
            {".jpeg"}
        };

        FolderRule folderrules[] = new FolderRule[3];
        for(int i = 0; i < folderrules.length ; i++){
            folderrules[i] = new FolderRule(folders[i] , extensions[i]);
            System.out.println(folderrules[i].toString());
        }


        AutoSorter as = new AutoSorter(path , folderrules);
        as.sort();
                
    }
}

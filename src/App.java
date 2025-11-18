public class App {
    public static void main(String[] args) throws Exception {

        String path = "C:\\Users\\cryss\\Downloads\\ciao";
        String folders[] = {"Documenti" , "Audio" , "Immagini"};
        String extensions[][] = {
            {".pdf" , ".txt" , ".xlsx"},
            {".mp3"} ,
            {".jpeg"}
        };
        AutoSorter as = new AutoSorter(path , folders , extensions);
        as.sort();
        
        //File file = new File("C:\\Users\\cryss\\Downloads\\ciao");
        
    //    File[] files;
    //    files = file.listFiles();
    //    for(int i = 0 ; i < files.length ; i++)
    //        System.out.println(files[i].toString());
        
        
    }
}

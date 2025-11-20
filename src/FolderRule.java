
public class FolderRule {

    private String targetFolder; 
    private String linkedExtensions[];

    FolderRule( String targetFolder,  String linkedExtensions[]){
        this.targetFolder = targetFolder;
        this.linkedExtensions = linkedExtensions;
    }

    public String[] getLinkedExtensions() {
        return linkedExtensions;
    }

    public String getTargetFolder() {
        return targetFolder;
    }

    @Override
    public String toString() {
        String str = targetFolder;
        for(String str2 : linkedExtensions)
            str = str + " " + str2;
        return str;
    }

}
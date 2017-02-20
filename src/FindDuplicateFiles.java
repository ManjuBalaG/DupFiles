import java.io.File;
import java.util.HashMap;
import java.util.*;

/**
 * Created by Manju on 2/19/17.
 * Assumption: Always we have a absolute file path
 * Other wise we are return nothing
 * Scope for extension is even if we get a directory we can search a identify and return map
 *
 */
public class FindDuplicateFiles {
    private static HashMap<FileDes,List<String>>  fileMap = new HashMap<FileDes,List<String>>();

    public static HashMap<FileDes,List<String>> findDup(String directory){
        if (directory.length() < 1) {
            System.out.println("Please supply a directory path");
            return fileMap;
        }
        File dir = new File(directory);
        if (!dir.isDirectory()) {
            System.out.println("Supplied directory does not exist.");
            return fileMap;
        }

        for (File dirChild : dir.listFiles()) {
            // Iterate all file sub directories recursively
            if (dirChild.isDirectory()) {
                findDup(dirChild.getAbsolutePath());
            } else {

                try {
                    // construct object
                    FileDes f = new FileDes(dirChild.getName(),dirChild.length());
                    String name = dirChild.getName();
                    String path = dirChild.getAbsolutePath();
                    if(fileMap.containsKey(f)){
                        fileMap.get(f).add(path);
                    }else {

                            ArrayList<String> a = new ArrayList<String>();
                            a.add(path);

                        fileMap.put(f, a);
                    }
                } catch (Exception e) {
                    // If we dont have permission we cant do a thing
                    throw new RuntimeException("cannot access file " + dirChild.getAbsolutePath(), e);
                }
            }
        }

        return fileMap;
    }
    // Main
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String filen = sc.next();
        if (filen.length() < 1) {
            System.out.println("Please supply a directory path");
            return;
        }
        File dir = new File(filen);
        if (!dir.isDirectory()) {
            System.out.println("Supplied directory does not exist.");
            return;
        }
        Map<FileDes,List<String>> lists = FindDuplicateFiles.findDup(dir.getAbsolutePath());


        for (FileDes st :lists.keySet() ) {

            System.out.println("Key: "+st.toString()+" Value: "+ (lists.get(st)).toString());

            }

        System.out.println("\n");
    }
}

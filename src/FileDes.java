import java.util.ArrayList;

/**
 * Created by Manju on 2/19/17.
 * Class to check even the filename is same we are checking for the size to confirm as it a duplicate.
 * We can also consider to read the file and digent the data and convert it to hash to make it.Its a scope for extension.
 * But we need to confirm whether we can read the data in the file.
 * This will stored as a key in our returning hashmap for further processing.
 *
 */
public class FileDes {
    String fileName;
    long fileSize;

    public FileDes(String fileName, long fileSize) {
        this.fileName = fileName;
        this.fileSize = fileSize;
    }

    public FileDes() {
    }

    @Override
    public String toString() {
        return "FileDes{" +
                "fileName='" + fileName + '\'' +
                ", fileSize=" + fileSize +

                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FileDes fileDes = (FileDes) o;

        if (fileSize != fileDes.fileSize) return false;
        return fileName.equals(fileDes.fileName);
    }

    @Override
    public int hashCode() {
        int result = fileName.hashCode();
        result = 31 * result + (int) (fileSize ^ (fileSize >>> 32));
        return result;
    }

    public String getFileName() {

        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }


}

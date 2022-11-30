package eirvidmovierentalsystem;

public class FileReader {
    public class FileReader extends Menu {

// Read the content from file
try(FileReader fileReader = new FileReader(absolutePath)) {

    int ch = fileReader.read();
    while(ch != -1) {
        System.out.print((char)ch);
        fileReader.close();
    }
    
} catch (FileNotFoundException e) {
    // Exception handling
} catch (IOException e) {
    // Exception handling
}

    }
}
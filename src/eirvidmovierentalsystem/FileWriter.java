package eirvidmovierentalsystem;

public class FileWriter {

    public class FileWriter extends Menu {

String directory = System.getProperty("user.home");
String fileName = "sample.txt";
String absolutePath = directory + File.separator + fileName;

// Write the content in file 
try(FileWriter fileWriter = new FileWriter(absolutePath)) {

    String fileContent = "The file will be added here later";
    fileWriter.write(fileContent);
    fileWriter.close();

} catch (IOException e) {
    // Exception handling
}



    }
}
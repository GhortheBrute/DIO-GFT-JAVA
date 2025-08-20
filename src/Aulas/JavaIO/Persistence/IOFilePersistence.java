package Aulas.JavaIO.Persistence;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class IOFilePersistence implements FilePersistence{
    private final String currentDir = System.getProperty("user.dir");
    private final String storedDir = "/managedFiles/IO/";
    private final String fileName;

    public IOFilePersistence(String fileName) throws IOException {
        this.fileName = fileName;
        var file = new File(currentDir + storedDir);
        if (!file.exists() && !file.mkdirs()) throw new IOException("Erro ao criar arquivo");

        clearFile();
    }

    @Override
    public String write(String data) {
        try(
                var fileWriter = new FileWriter(currentDir + storedDir + fileName, true);
                var bufferedWrite = new BufferedWriter(fileWriter);
                var printWriter = new PrintWriter(bufferedWrite);
        ){
            printWriter.println(data);
        }catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    @Override
    public boolean remove(String sentence) {
        var content = findAll();
        var contentList = new ArrayList<>(Stream.of(content.split(System.lineSeparator())).toList());

        if (contentList.stream().noneMatch(line -> line.contains(sentence))) return false;

        clearFile();
        contentList.stream().filter(line -> line.contains(sentence)).forEach(this.write());

        return true;
    }

    @Override
    public String replace(String oldContent, String newContent) {
        var content = findAll();
        var contentList = new ArrayList<>(Stream.of(content.split(System.lineSeparator())).toList());

        if (contentList.stream().noneMatch(line -> line.contains(oldContent))) return "";

        clearFile();
        contentList.stream().filter(line -> line.contains(oldContent)).forEach(line -> write(line.replace(oldContent, newContent)));
        return newContent;
    }

    @Override
    public String findAll() {
        var content = new StringBuilder();
        try(var reader = new BufferedReader(new FileReader(currentDir + storedDir + fileName))){
            String line;
            do{
                line = reader.readLine();
                if ((line !=null)) content.append(line)
                        .append(System.lineSeparator());
            }while(line != null);
        }catch (IOException e){
            e.printStackTrace();
        }
        return content.toString();
    }

    @Override
    public String findBy(String sentence) {
        String founded = "Not found!";
        try(var reader = new BufferedReader(new FileReader(currentDir + storedDir + fileName))){
            String line = reader.readLine();
            while(line != null){
                if (line.contains(sentence)){
                    founded = line;
                    break;
                }
                line = reader.readLine();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return founded;
    }

    private void clearFile() {
        try(OutputStream outputStream = new FileOutputStream(currentDir + storedDir + fileName)) {
            System.out.printf("Inicializando recursos (%s) \n", currentDir + storedDir + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createFile(){}
}

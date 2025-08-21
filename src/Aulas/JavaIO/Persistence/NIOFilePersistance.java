package Aulas.JavaIO.Persistence;

import java.io.*;
import java.nio.ByteBuffer;

public class NIOFilePersistance implements FilePersistence{

    private final String currentDir = System.getProperty("user.dir");
    private final String storedDir = "/managedFiles/NIO/";
    private final String fileName;

    public NIOFilePersistance(String fileName) throws IOException {
        this.fileName = fileName;
        var file = new File(currentDir + storedDir);
        if (!file.exists() && !file.mkdirs()) throw new IOException("Erro ao criar arquivo");

        clearFile();
    }

    @Override
    public String write(String data) {
        try (
                var file = new RandomAccessFile(currentDir + storedDir + fileName, "rw");
                var channel = file.getChannel();
        ) {
            file.seek(file.length());
            file.writeBytes(data + System.lineSeparator());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    @Override
    public boolean remove(String sentence) {
        return false;
    }

    @Override
    public String replace(String oldContent, String newContent) {
        return "";
    }

    @Override
    public String findAll() {
        var content = new StringBuilder();
        try (
                var file = new RandomAccessFile(currentDir + storedDir + fileName, "r");
                var channel = file.getChannel();
        ){
            var buffer = ByteBuffer.allocate((int) channel.size());
            var bytesRead = channel.read(buffer);
            while (bytesRead != -1) {
                buffer.flip();
                while (buffer.hasRemaining()) {
                    content.append((char) buffer.get());
                }
                buffer.clear();
                bytesRead = channel.read(buffer);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    @Override
    public String findBy(String sentence) {
        //var content = findAll();
        return "";
    }

    private void clearFile() {
        try(OutputStream outputStream = new FileOutputStream(currentDir + storedDir + fileName)) {
            System.out.printf("Inicializando recursos (%s) \n", currentDir + storedDir + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

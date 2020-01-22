package ru.avalon.java.actions;

import java.io.*;

/**
 * Действие, которое копирует файлы в пределах дискового
 * пространства.
 */
public class FileCopyAction implements Action {
    File source,dest;
    
    public FileCopyAction(String source, String dest) {
        this.source = new File(source);
        this.dest = new File(dest);
    }
    public void start() {
        new Thread(this).start();
        System.out.println("Запускаем поток копирования");
    }
    @Override
    public void run() {
        try( InputStream is = new FileInputStream(source);
          OutputStream os = new FileOutputStream(dest)) {
          byte[] buffer = new byte[1024];
          int length;
          while((length = is.read(buffer)) > 0) {
             os.write(buffer, 0, length);
          }
          os.flush();
          System.out.println("\nКопирование " + 
          source.getAbsolutePath() + "\n в " +
          dest.getAbsolutePath() + " завершено.\n> ");
        } catch(IOException ex) {
            System.out.println("Ошибка копирования файла"
                    + ex.getMessage());
        }
    }

  
    @Override
    public void close() throws Exception {
        source = null;
        dest = null;
    }
}

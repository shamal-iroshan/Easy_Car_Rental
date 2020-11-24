package lk.ijse.spring.service.impl;

import lk.ijse.spring.service.FileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

@Service
public class FileServiceImpl implements FileService {
    @Value("${app.IMG_DIR}")
    String path;
    HttpServletRequest request;
    private File file;
    private Path root = Paths.get("/uploads");

    @Override
    public void init() {

    }

    @Override
    public void save(MultipartFile img, String id, String rootPath) {
        file = new File("D:\\IJSE\\lessons\\2nd semester\\Spring\\Final coursework\\Easy Car Rental\\Easy_Car_Rental_Back_End\\src\\uploads" + id);
        if (!file.exists()) {
            if (!file.mkdirs()) {
                throw new RuntimeException("Not Created.!");
            }
        }
        Path imgPath = Paths.get(file.getAbsolutePath(), img.getOriginalFilename());
        try {
            Files.write(imgPath, img.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage() + "");
        }
    }

    @Override
    public void load(String filename, String rootPath) {
        File file = new File(rootPath + "/uploads/" + filename);
        File[] files = file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(".jpg") || pathname.getName().endsWith(".png")||pathname.getName().endsWith(".jpeg");
            }
        });
        for (File file1 : files) {
            System.out.println(file1.getPath());
            System.out.println(file1.getAbsolutePath());
            System.out.println(file1.getName());
            System.out.println();
        }
    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Stream<Path> loadAll() {
        try {
            return Files.walk(this.root, 1).filter(path -> !path.equals(this.root)).map(this.root::relativize);
        } catch (IOException e) {
            throw new RuntimeException("Could not load the files!");
        }
    }
}

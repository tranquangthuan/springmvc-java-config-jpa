package thuan.com.fa.demomvc.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.springframework.web.multipart.MultipartFile;

public class FilleUtils {

	public static String PATH_FILE = "D:/Image";

	public static String saveFile(MultipartFile file) throws IllegalStateException, IOException {
		String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
		File fileSave = new File(PATH_FILE, fileName);
		file.transferTo(fileSave);
		return fileName;
	}

	public static byte[] getImage(String imageName) {
		File file = new File(PATH_FILE + "/" + imageName);
		try {
			return Files.readAllBytes(file.toPath());
		} catch (IOException e) {
			System.out.println("File not found " + e.getMessage());
		}
		return null;
	}
}

package thuan.com.fa.demomvc.controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import thuan.com.fa.demomvc.service.FilleUtils;

@RestController
@RequestMapping("/image")
public class ImageController {

	@GetMapping("/{imageName:.+}")
	public byte[] getImage(@PathVariable(name = "imageName") String imageName) throws IOException {
		byte[] image = FilleUtils.getImage(imageName);
		return image;
	}
}

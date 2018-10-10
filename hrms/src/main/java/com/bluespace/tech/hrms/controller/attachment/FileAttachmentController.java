package com.bluespace.tech.hrms.controller.attachment;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bluespace.tech.hrms.util.Constants;

@RestController
public class FileAttachmentController {

	private static final Logger logger = LoggerFactory.getLogger(FileAttachmentController.class);
	private Path uploadLocation;

	@PostConstruct
	public void init() {
		this.uploadLocation = Paths.get(Constants.UPLOAD_LOCATION);
		try {
			Files.createDirectories(uploadLocation);
		} catch (IOException e) {
			throw new RuntimeException("Could not initialize storage: ", e);
		}
	}

	@GetMapping("/documents")
	public String index() {
		return "documents";
	}

	@PostMapping("/documents")
	public @ResponseBody String handleFileUpload(@RequestParam("file") MultipartFile file,
			RedirectAttributes redirectAttributes) {

		if (file.isEmpty()) {
			redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
			return "redirect:documents";
		}

		try {
			byte[] bytes = file.getBytes();
			Path path = Paths.get(uploadLocation + file.getOriginalFilename());
			logger.info("The path of the file stored is " + path);
			Files.write(path, bytes);
			redirectAttributes.addFlashAttribute("message",
					"You successfully uploaded '" + file.getOriginalFilename() + "'");

		} catch (IOException e) {
			return "The file was not uploaded successfully and failed with exception -> " + e.getMessage();
		}
		return "redirect:/documents";
	}
}
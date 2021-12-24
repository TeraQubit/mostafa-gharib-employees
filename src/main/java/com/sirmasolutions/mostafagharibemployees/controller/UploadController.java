package com.sirmasolutions.mostafagharibemployees.controller;

import java.io.IOException;
import java.util.List;

import com.sirmasolutions.mostafagharibemployees.model.Colleagues;
import com.sirmasolutions.mostafagharibemployees.service.Calculator;
import com.sirmasolutions.mostafagharibemployees.service.FileReader;
import com.sirmasolutions.mostafagharibemployees.service.UploadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class UploadController {

	final Logger LOGGER = LoggerFactory.getLogger(getClass());

	private final String UPLOAD_DIR = "src/main/resources/uploads/";

	@Autowired
	private Calculator calculator;

	@Autowired
	private UploadService uploadService;

	@Autowired
	private FileReader fileReader;

	@GetMapping("/")
	public String homepage() {
		return "index";
	}

	@PostMapping("/upload")
	public String uploadFile(@RequestParam("file") MultipartFile file, RedirectAttributes attributes)
			throws IOException {
		calculator.clearColleaguesList();
		if (file.isEmpty()) {
			attributes.addFlashAttribute("message", "Please select a file to upload.");
			return "redirect:/";
		}

		String fileName = uploadService.uploadFile(file, UPLOAD_DIR);
		fileReader.readFile(UPLOAD_DIR + fileName);
		LOGGER.info("FILE NAME IS: {} ", fileName);

		attributes.addFlashAttribute("message", "You successfully uploaded " + fileName + '!');
		return "redirect:/employees";
	}

	@GetMapping("/employees")
	public String listEmployees(Model model) throws IOException {
		List<Colleagues> colleagues = calculator.getColleaguesList();
		Colleagues longestWorkingTeam = calculator.getLongestWorkingTeam();
		model.addAttribute("longestWorkingTeam", longestWorkingTeam);
		model.addAttribute("colleagues", colleagues);
		return "/employees/list-employees";
	}

}

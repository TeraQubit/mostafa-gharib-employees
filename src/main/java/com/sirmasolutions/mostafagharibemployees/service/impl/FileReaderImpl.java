package com.sirmasolutions.mostafagharibemployees.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import com.sirmasolutions.mostafagharibemployees.model.Input;
import com.sirmasolutions.mostafagharibemployees.service.Calculator;
import com.sirmasolutions.mostafagharibemployees.service.FileReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FileReaderImpl implements FileReader {

	final Logger LOGGER = LoggerFactory.getLogger(getClass());

	private Calculator calculator;

	@Autowired
	public FileReaderImpl(Calculator calculator) {
		this.calculator = calculator;
	}

	@Override
	public void readFile(String fileName) throws IOException {
		ArrayList<String> result = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new java.io.FileReader(fileName))) {
			while (br.ready()) {
				result.add(br.readLine());
			}
			Input[] input = result.stream().skip(1).map(t -> {
				String[] a = t.split(",\\s+");
				LocalDate dateFrom = LocalDate.parse(a[2]);
				LocalDate dateTo = a[3].equals("NULL") ? LocalDate.now() : LocalDate.parse(a[3]);
				if (dateTo.isBefore(dateFrom) || dateTo.equals(dateFrom))
					throw new RuntimeException(a[2] + " must be before " + dateTo.toString());
				return new Input(Integer.parseInt(a[0]), Integer.parseInt(a[1]), LocalDate.parse(a[2]), dateTo);
			}).toArray(size -> new Input[size]);
			calculator.calculateColleaguesPairs(input);
		} catch (IOException e) {
			LOGGER.error("IOException", e);
		}

	}

}
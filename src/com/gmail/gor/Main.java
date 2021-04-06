package com.gmail.gor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import java.util.List;

import com.gmail.gor.exceptions.HaveNotFoundException;

public class Main {

	public static void main(String[] args) {
		File fileEng = new File("English.in");
		File fileUkr = new File("Ukrainian.out");

		String[] eng = loadFromFile(fileEng).replaceAll("[^\\dA-Za-z ]", " ").split(" ");
		Translator translator = new Translator();
		translator.addWord();
		translator.addWord();
		translator.addWord();
		System.out.println(translator.toString());
		List<String> ukrList = translateArr(eng, translator);

		saveToFile(fileUkr, ukrList);
		saveTranslator(translator);

	}

	public static List<String> translateArr(String[] eng, Translator translator) {
		List<String> ukrList = new ArrayList<>();
		for (String engWord : eng) {
			try {
				String ukrWord = translator.translateWord(engWord);
				ukrList.add(ukrWord);
			} catch (HaveNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return ukrList;
	}

	public static String loadFromFile(File file) {
		StringBuilder sb = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String text = "";
			for (; (text = br.readLine()) != null;) {
				sb.append(text).append(System.lineSeparator());

			}
		} catch (IOException e) {
			System.out.println(e);
		}

		return sb.toString();
	}

	public static void saveToFile(File file, List<String> ukrList) {
		try (PrintWriter pw = new PrintWriter(file)) {
			for (String text : ukrList) {
				pw.print(text + " ");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void saveTranslator(Translator translator) {
		try (ObjectOutputStream OOS = new ObjectOutputStream(new FileOutputStream("translator"))) {
			OOS.writeObject(translator);
		} catch (IOException e) {
			System.out.println("ERROR saving");
		}

	}

}

package com.example.hw14dev;

import com.example.hw14dev.entities.Note;
import com.example.hw14dev.servicies.NoteService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Hw14devApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Hw14devApplication.class, args);
		Note note = new Note();
		note.setContent("content");
		note.setTitle("title");

		NoteService noteService = new NoteService();

		noteService.add(note);
		System.out.println(noteService.listAll());
		note.setTitle("title2");
		noteService.update(note);
		System.out.println(noteService.listAll());
		Long id = noteService.listAll().get(0).getId();
		System.out.println(noteService.getById(id));
		noteService.deleteById(id);
		System.out.println(noteService.listAll());
	}

}

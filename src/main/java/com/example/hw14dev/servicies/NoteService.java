package com.example.hw14dev.servicies;

import com.example.hw14dev.entities.Note;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class NoteService {

    private Map<Long, Note> notes = new HashMap<>();


    //повертає список всіх нотаток
    public List<Note> listAll(){
        return notes.values().stream().collect(Collectors.toList());
    }

    //додає нову нотатку, генеруючи для цієї нотатки унікальний (випадковий) числовий ідентифікатор, повертає цю ж нотатку з згенерованим ідентифікатором.
    public Note add(Note note){
        Random random = new Random();
        Long id = random.nextLong(Integer.MAX_VALUE);
        note.setId(id);
        notes.put(id, note);
        return note;
    }

    //видаляє нотатку з вказаним ідентифікатором. Якщо нотатки з ідентифікатором немає - викидає виключення.
    public void deleteById(long id) throws Exception {
        if(notes.containsKey(id)){
            notes.remove(id);
        }else{
            throw new Exception("No id");
        }
    }

    //шукає нотатку по note.id. Якщо нотатка є - оновлює для неї title та content. Якщо нотатки немає - викидає виключення.
    public void update(Note note) throws Exception {
        Long id = note.getId();
        if(notes.containsKey(id)){
            notes.get(id).setTitle(note.getTitle());
            notes.get(id).setContent(note.getContent());
        }else{
            throw new Exception("No id");
        }
    }

    //повертає нотатку по її ідентифікатору. Якщо нотатки немає - викидає виключення.
    public Note getById(long id) throws Exception {
        if(notes.containsKey(id)){
            return notes.get(id);
        }else{
            throw new Exception("No id");
        }
    }
}

package englishcentral.staj.demo.Controller;

import englishcentral.staj.demo.Note;
import englishcentral.staj.demo.Service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/note")
public class NoteController {


    @Autowired
    private NoteService noteService;


    @PostMapping(value = "/save")
    private String saveNote(@RequestBody Note note){

        noteService.saveOrUpdate(note);
        return note.getId();
    }

    @GetMapping(value = "/getAll")
    public Iterable<Note> getAllNotes (){
        return noteService.getAll();
    }

    @GetMapping(value = "/getAllNotesById/{userId}")
    public List<Note> getAllNotes (@PathVariable(name = "userId")String userId){
        return noteService.getAllNoteById(userId);
    }


    @PutMapping(value = "/edit/{id}")
    private Note updateNote (@RequestBody Note note, @PathVariable(name = "id")String _id) {

        note.setId(_id);
        noteService.saveOrUpdate(note);
        return note;
    }

    @DeleteMapping(value = "/delete/{id}")
    private void deleteNote(@PathVariable("id") String _id){
        noteService.deleteNote(_id);
    }

    @DeleteMapping(value = "/deleteAll")
    private void deleteAllNote () {
        noteService.deleteAllNote();
    }

    @RequestMapping(value = "/note/{id}")
    private Note getNote (@PathVariable(name = "id")String _id) {
        return noteService.getNoteById(_id);
    }

}

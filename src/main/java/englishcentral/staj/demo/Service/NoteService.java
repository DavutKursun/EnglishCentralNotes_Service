package englishcentral.staj.demo.Service;

import englishcentral.staj.demo.Note;
import englishcentral.staj.demo.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    public void saveOrUpdate(Note note) {
        noteRepository.save(note);
    }


    public Iterable<Note> getAll() {
        return this.noteRepository.findAll();
    }

    public void deleteNote(String id) {
        noteRepository.deleteById(id);
    }

    public void deleteAllNote(){
        noteRepository.deleteAll();
    }
    public Note getNoteById(String noteid) {
        return this.noteRepository.findById(noteid).orElse(null);
    }
    public List<Note> getAllNoteById(String userId) {
        return this.noteRepository.findByUserId(userId);
    }
    public void deleteUsersAllNotes(String user){
        this.noteRepository.deleteNoteByUserId(user);
    }
}

package englishcentral.staj.demo.Service;

import englishcentral.staj.demo.Note;
import englishcentral.staj.demo.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.management.Query;
import java.util.ArrayList;
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
        /*ArrayList<Note> Notes = new ArrayList<>();
        for (int i = 0; i < this.noteRepository.count(); i++) {
            Notes.add(this.noteRepository.findById(userId).orElse(null));
        }*/
        return this.noteRepository.findByUserId(userId);
    }
}

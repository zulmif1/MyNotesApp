package id.ac.iainpekalongan.mynotesapp.helper;

import android.database.Cursor;

import java.util.ArrayList;

import id.ac.iainpekalongan.mynotesapp.entity.Note;
import id.ac.iainpekalongan.mynotesapp.db.DatabaseContract;

public class MappingHelper {

    public static ArrayList<Note> mapCursorToArrayList(Cursor notesCursor) {
        ArrayList<Note> notesList = new ArrayList<>();

        while (notesCursor.moveToNext()) {
            int id = notesCursor.getInt(notesCursor.getColumnIndexOrThrow(DatabaseContract.NoteColumns._ID));
            String title = notesCursor.getString(notesCursor.getColumnIndexOrThrow(DatabaseContract.NoteColumns.TITLE));
            String description = notesCursor.getString(notesCursor.getColumnIndexOrThrow(DatabaseContract.NoteColumns.DESCRIPTION));
            String date = notesCursor.getString(notesCursor.getColumnIndexOrThrow(DatabaseContract.NoteColumns.DATE));
            notesList.add(new Note(id, title, description, date));
        }

        return notesList;
    }
}
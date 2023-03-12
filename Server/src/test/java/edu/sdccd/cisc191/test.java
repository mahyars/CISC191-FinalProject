package edu.sdccd.cisc191;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class test {
    private MusicLibrary library;
    private final String DUMMY_FILE_PATH = "dummy/file/path.mp3";


    @Test
    public void testCompareTo() {
        MusicLibrary library1 = new MusicLibrary();
        MusicLibrary library2 = new MusicLibrary();

        // Add two tracks to library1
        library1.addTrack(new MusicTrack("Rock", "AC/DC", "Highway to Hell", "Highway to Hell", "3:28"));
        library1.addTrack(new MusicTrack("Rock", "Led Zeppelin", "Stairway to Heaven", "Led Zeppelin IV", "8:03"));

        // Add three tracks to library2
        library2.addTrack(new MusicTrack("Pop", "Michael Jackson", "Billie Jean", "Thriller", "4:54"));
        library2.addTrack(new MusicTrack("Pop", "Whitney Houston", "I Will Always Love You", "The Bodyguard", "4:32"));
        library2.addTrack(new MusicTrack("Pop", "Madonna", "Like a Virgin", "Like a Virgin", "3:08"));

        // Check that library2 is greater than library1
        assertTrue(library2.compareTo(library1) > 0);
    }

    @Test
    public void testConstructor() {
        MusicTrack track = new MusicTrack("Test Track", "Test Artist", "Test Album", "Test Genre", "path/to/test/file.mp3");
        assertNotNull(track);
        assertEquals("Test Track", track.getTitle());
        assertEquals("Test Artist", track.getArtist());
        assertEquals("Test Album", track.getAlbum());
        assertEquals("Test Genre", track.getGenre());
        assertEquals("path/to/test/file.mp3", track.getFilepath());
        assertEquals(0.0, track.getTrackDuration());
        assertNull(track.player);
    }
    @BeforeEach
    public void setUp() {
        library = new MusicLibrary();
        library.addTrack(new MusicTrack("Rock", "AC/DC", "Highway to Hell", "Highway to Hell", DUMMY_FILE_PATH));
        library.addTrack(new MusicTrack("Rock", "Led Zeppelin", "Stairway to Heaven", "Led Zeppelin IV", DUMMY_FILE_PATH));
        library.addTrack(new MusicTrack("Pop", "Michael Jackson", "Billie Jean", "Thriller", DUMMY_FILE_PATH));
        library.addTrack(new MusicTrack("Pop", "Whitney Houston", "I Will Always Love You", "The Bodyguard", DUMMY_FILE_PATH));
        library.addTrack(new MusicTrack("Pop", "Madonna", "Like a Virgin", "Like a Virgin", DUMMY_FILE_PATH));
    }
    @Test
    public void testGetTracksByAlbum() {
        // Check that only tracks with the specified album are returned
        String album = "Highway to Hell";
        for (MusicTrack track : library.getTracksByAlbum(album)) {
            assertEquals(album, track.getAlbum());
        }
    }
 }
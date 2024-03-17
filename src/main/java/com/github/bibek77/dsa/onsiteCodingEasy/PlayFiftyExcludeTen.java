package com.github.bibek77.dsa.onsiteCodingEasy;

import java.util.*;

/**
 * @author bibek
 * Implement a playlist which plays a random song from a list of 50 songs, but it shouldn't play one of the last 10 songs.
 * If the song is present in the last 10 songs, get another random song.
 */
public class PlayFiftyExcludeTen {

    static Queue<Song> queue;
    static Set<Song> set;
    static List<Song> songList;

    static Random random;

    public static void main(String[] args) {
        songList = new ArrayList<>();
        queue = new LinkedList<>();
        set = new HashSet<>();
        random = new Random();
        instantiateSongs(); // Adding 50 songs to list
        addLast10Songs(songList); // Adding last 10 played songs to set & queue
        // Get a random song to play which is not played in last 10 plays.
        Song song = getRandomSongToPlay();
        System.out.println(song.id + " " + song.name);

    }

    public static Song getRandomSongToPlay() {
        Song currentSong;

        while (true) {
            int getRandomIndex = random.nextInt(songList.size());
            currentSong = songList.get(getRandomIndex);
            if (set.contains(currentSong))
                continue;

            Song firstPlayedSong = queue.poll();
            set.remove(firstPlayedSong);

            queue.add(currentSong);
            set.add(currentSong);
            break;
        }
        return currentSong;
    }

    public static void addLast10Songs(List<Song> songList) {
        int i = 0;
        int n = songList.size();
        while (i < n && set.size() <= 10) {
            set.add(songList.get(i));
            queue.add(songList.get(i));
            i++;
        }
    }

    public static void instantiateSongs() {
        Song song1 = new Song(1, "Shape of You");
        Song song2 = new Song(2, "Bohemian Rhapsody");
        Song song3 = new Song(3, "Smells Like Teen Spirit");
        Song song4 = new Song(4, "Rolling in the Deep");
        Song song5 = new Song(5, "Hotel California");
        Song song6 = new Song(6, "Billie Jean");
        Song song7 = new Song(7, "Stairway to Heaven");
        Song song8 = new Song(8, "Uptown Funk");
        Song song9 = new Song(9, "Imagine");
        Song song10 = new Song(10, "Havana");
        Song song11 = new Song(11, "Wonderwall");
        Song song12 = new Song(12, "Hey Jude");
        Song song13 = new Song(13, "All About That Bass");
        Song song14 = new Song(14, "Radioactive");
        Song song15 = new Song(15, "Don't Stop Believin'");
        Song song16 = new Song(16, "Sweet Child o' Mine");
        Song song17 = new Song(17, "Shape of My Heart");
        Song song18 = new Song(18, "My Heart Will Go On");
        Song song19 = new Song(19, "Eye of the Tiger");
        Song song20 = new Song(20, "Take Me Home, Country Roads");
        Song song21 = new Song(21, "Wonderful Tonight");
        Song song22 = new Song(22, "Piano Man");
        Song song23 = new Song(23, "I Will Always Love You");
        Song song24 = new Song(24, "Despacito");
        Song song25 = new Song(25, "Wannabe");
        Song song26 = new Song(26, "Livin' on a Prayer");
        Song song27 = new Song(27, "Every Breath You Take");
        Song song28 = new Song(28, "I Want to Hold Your Hand");
        Song song29 = new Song(29, "Dancing Queen");
        Song song30 = new Song(30, "Thriller");
        Song song31 = new Song(31, "Someone Like You");
        Song song32 = new Song(32, "Born to Run");
        Song song33 = new Song(33, "Hound Dog");
        Song song34 = new Song(34, "Purple Rain");
        Song song35 = new Song(35, "Brown Eyed Girl");
        Song song36 = new Song(36, "Johnny B. Goode");
        Song song37 = new Song(37, "Take on Me");
        Song song38 = new Song(38, "Let It Be");
        Song song39 = new Song(39, "Superstition");
        Song song40 = new Song(40, "La Bamba");
        Song song41 = new Song(41, "All Star");
        Song song42 = new Song(42, "Sweet Caroline");
        Song song43 = new Song(43, "My Way");
        Song song44 = new Song(44, "Come Together");
        Song song45 = new Song(45, "I Will Survive");
        Song song46 = new Song(46, "Can't Help Falling in Love");
        Song song47 = new Song(47, "I Want It That Way");
        Song song48 = new Song(48, "Hello");
        Song song49 = new Song(49, "Total Eclipse of the Heart");
        Song song50 = new Song(50, "Firework");

        songList = Arrays.asList(
                song1, song2, song3, song4, song5, song6, song7, song8, song9, song10,
                song11, song12, song13, song14, song15, song16, song17, song18, song19, song20,
                song21, song22, song23, song24, song25, song26, song27, song28, song29, song30,
                song31, song32, song33, song34, song35, song36, song37, song38, song39, song40,
                song41, song42, song43, song44, song45, song46, song47, song48, song49, song50
        );
    }

    public static class Song {
        int id;
        String name;

        Song(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }
}

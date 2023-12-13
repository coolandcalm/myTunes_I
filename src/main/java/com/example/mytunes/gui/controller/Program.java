package com.example.mytunes.gui.controller;

/* The only important thing is to realize that the data structure is maintained by ArrayList (_list) and that we only have to worry about _pointer, which will tell us what the next file to play will be.
Finally, Program should only be used to see how the system works. We will add three files and tell it that we want to play “Next, Next, Previous, Next, Next, Next”. That would be 1, 2, 1, 2,3,1 (if the next of the last is requested, it returns the first).
The code would be:
*/
public class Program {

    private ListController listController;

    public Program() {
        listController = new ListController();

        MusicFile file1 = new MusicFile("File 1", "path1");
        MusicFile file2 = new MusicFile("File 2", "path2");
        MusicFile file3 = new MusicFile("File 3", "path3");

        listController.addFileToPlayList(file1);
        listController.addFileToPlayList(file2);
        listController.addFileToPlayList(file3);

        System.out.println("Next");
        System.out.println(listController.getNextFile());
        System.out.println("Next");
        System.out.println(listController.getNextFile());
        System.out.println("Previous");
        System.out.println(listController.getPreviousFile());
        System.out.println("Next");
        System.out.println(listController.getNextFile());
        System.out.println("Next");
        System.out.println(listController.getNextFile());
        System.out.println("Next");
        System.out.println(listController.getNextFile());

    }

    public static void main(String[] args) {
        new Program();
    }

}

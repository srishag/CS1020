import java.util.*;

public class FileM {
   private LinkedList<Folder> list = new LinkedList<Folder>();

   public static void main(String[] args) {
      FileM file = new FileM();
      file.run();
   }

   public void run() {
      Scanner scan = new Scanner(System.in);
      int q = scan.nextInt();
      doQ(scan, q);
   }

   public void doQ(Scanner s, int q) {
      int i;

      for(i = 0; i < q; i++) {
         String query = s.next();

         if(query.equals("Createfile")) {
            String filename = s.next();
            int filesize = s.nextInt();
            String folder = s.next();

            File filing = new File(filename, filesize);

            int j, index = 0;

            for(j = 0; j < list.size(); j++) {
               if(list.get(j).getName().equals(folder)) {
                  index = j;
                  break;
               }
            }
            list.get(index).addFile(filing);
         } else if(query.equals("Createfolder")) {
            String folder = s.next();
            ArrayList<File> file = new ArrayList<File>();

            list.add(new Folder(folder, file));
         } else if(query.equals("Deletefile")) {
            String filename = s.next();

            int a, b;

            for(a = 0; a < list.size(); a++) {
               if(list.get(a).searchFile(filename)) {
                  list.get(a).deleteFile(filename);
               }
            }
         } else if(query.equals("Count")) {
            String foldername = s.next();

            int a, index = 0;

            for(a = 0; a < list.size(); a++) {
               if(list.get(a).getName().equals(foldername)) {
                  index = a;
                  break;
               }
            }

            System.out.println(list.get(a).getSize());
         } else if(query.equals("Movefile")) {
            String filename = s.next();
            String foldername = s.next();
            int filesize = 0;

            int a, b;

            for(a = 0; a < list.size(); a++) {
               if(list.get(a).searchFile(filename)) {
                  filesize = list.get(a).fileSize(filename);
                  list.get(a).deleteFile(filename);
                  break;
               }
            }

            File f = new File(filename, filesize);

            for(b = 0; b < list.size(); b++) {
               if(list.get(b).getName().equals(foldername)) {
                  list.get(b).addFile(f);
               }
            }
         } else if(query.equals("Findlargest")) {
            int maxSize = 0, maxIndex = 0, a;

            for(a = 0; a < list.size(); a++) {
               if(list.get(a).getSize() > maxSize) {
                  maxSize = list.get(a).getSize();
                  maxIndex = a;
               }
            }
            System.out.println(list.get(maxIndex).getName());
         }
      }
   }
} 

class Folder {
   private String name;
   private ArrayList<File> fold;

   public Folder(String n, ArrayList<File> f) {
      name = n;
      fold = f;
      fold = new ArrayList<File>();
   }

   public String getName() {
      return name;
   }

   public void addFile(File f) {
      fold.add(f);
   }

   public boolean searchFile(String f) {
      int i;

      for(i = 0; i < fold.size(); i++) {
         if(fold.get(i).getName().equals(f)) {
            return true;
         }
      }
      return false;
   }

   public void deleteFile(String f) {
      int i;

      for(i = 0; i < fold.size(); i++) {
         if(fold.get(i).getName().equals(f)) {
            fold.remove(i);
            break;
         }
      }
   }

   public int fileSize(String f) {
      int i;

      for(i = 0; i < fold.size(); i++) {
         if(fold.get(i).getName().equals(f)) {
            return fold.get(i).getSize();
         }
      }
      return 0;
   }  

   public int getSize() {
      int i, size = 0;

      for(i = 0; i < fold.size(); i++) {
         size += fold.get(i).getSize();
      }
      return size;
   }
}  

class File {
   private String name;
   private int size;

   public File(String n, int s) {
      name = n;
      size = s;
   }

   public String getName() {
      return name;
   }

   public int getSize() {
      return size;
   }
}

import ra.entity.Girl;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        // tạo mới đối tượng File
        File file = new File("src/data.docx");
        // kiểm tra tồn tại
        System.out.println("file có ồn tại ko :"+ file.exists());
        // kiểm tra độ dài
        System.out.println("độ dài file : "+file.length());
        // tạo mới thư mục
        File dir = new File("util");
        if (!dir.exists()){
            dir.mkdirs();
//            dir.mkdir();
        }
        // tao mời file
        File txt  = new File("util/demo.txt");
        if (!txt.exists()){
            boolean check = txt.createNewFile();
        }else {
            // xóa file
//           boolean check = txt.delete();
        }
        // kiểm tra đường dẫn
//        File testFile = new File("src/ra/../data/../../util/demo.txt");
//        // tương đối
//        System.out.println("đường dẫn tương đối: "+testFile.getPath());
//        // tuyệt đối
//        System.out.println("đường dẫn tuyệt đối: "+testFile.getAbsolutePath());
//        // lý tưởng
//        System.out.println("đường dẫn lý tươởng: "+testFile.getCanonicalPath());
//        // lâ tên file
//        System.out.println(testFile.getName());
//
//        File pack = new File("src/ra/entity");
//        if (!pack.exists()){
//            pack.mkdirs();
//        }
//        File laptop = new File("src/ra/entity/Laptop.java");
//        if (!laptop.exists()){
//            laptop.createNewFile();
//        }
//        copyFile("demo.txt","C:/Users/AD/Downloads/output.txt");

        // đọc ghi nhị phân
        copyBinaryFile("demo.csv","huynhcongtinh.txt");

    }

    //hàm copy file từ 1 file chỉ định sang 1 file khác
    static  public  void copyFile(String pathInput, String pathOutput){
        File input = new File(pathInput);
        File output = new File(pathOutput);
        /// kiểm tra tồn tại
        if (!input.exists()){
            System.err.println("file input ko tồn tại ");
            return;
        }
        if (!output.exists()){
            System.err.println("file output ko tồn tại ");
            return;
        }
        // đọc các nội dung trong file demo
        Reader reader = null;
        BufferedReader buff = null;
        try{
        reader = new FileReader(input);
        buff = new BufferedReader(reader);

        Writer writer = new FileWriter(output);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);

        String line = "";
        while ((line=buff.readLine())!=null) { // đọc từng dòng
            bufferedWriter.write(line);
            bufferedWriter.newLine();
        }
        bufferedWriter.flush();
        // ghi ra ở file out
        }catch (FileNotFoundException e){

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (reader!=null){
                try {
                    reader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }


    // copy nhị phân
    static  public  void copyBinaryFile(String pathInput, String pathOutput){
        // check tồn tại
        InputStream ist = null ; // đọc vào
        BufferedInputStream buf =  null;
        OutputStream ous = null ;// ghi ra
        BufferedOutputStream bos = null;

        try {
            ist = new FileInputStream(pathInput);
            buf = new BufferedInputStream(ist);

            ous = new FileOutputStream(pathOutput);
            bos = new BufferedOutputStream(ous);
            int b ;
            while((b = buf.read())!= -1){
                bos.write(b);
            }
            bos.flush(); // đẩy vào file
            buf.close();
            bos.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    // đọc object tuwf file
    public static List<Girl> readListGirlFromFile(){
        List<Girl> list = new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try{
            fis = new FileInputStream("demo.txt");
            ois = new ObjectInputStream(fis);
            list = (List<Girl>) ois.readObject();
        }catch (EOFException e ){
            System.out.println("chưa có dữ liệu");
            // lỗi file rỗng
        } catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (ois!=null){
                    ois.close();
                }
                if (fis!=null){
                    fis.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return list;
    }
    // ghi 1 List<Girl> vào file
    public static void writeListGirlToFile(List<Girl> list){
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            fos = new FileOutputStream("demo.txt");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(list); // phương thuc để ghi ra file
        } catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if (oos!=null){
                    oos.close();
                }
                if (fos!=null){
                    fos.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
//
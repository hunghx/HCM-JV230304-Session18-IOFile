import ra.entity.Girl;

import java.util.ArrayList;
import java.util.List;

public class TestGirl {
    public static void main(String[] args) {
        List<Girl> list = Main.readListGirlFromFile();
//        Girl huyen = new Girl(60,40,60,1.5,40,"Mỹ Huyền",14);
//        list.add(huyen);
//        // lưu vào file
//        Main.writeListGirlToFile(list);

        System.out.println(list);
    }
}

package serialization;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ObjectKeeper {
    public void saveObjectList(List<Object> list, String fileName) {

        File file = new File(fileName);
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (Object ob : list) {
                oos.writeObject(ob);
                oos.flush();
                fos.flush();
            }
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null)
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

    }
    public List<Object> readObjectList(String fileName) {
        boolean cont = true;
        List<Object> list = new ArrayList<>();
        File file = new File(fileName);
        FileInputStream fis = null;
        if (file.exists()) {
            try {
                fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis);
                while(cont) {
                    try {
                        Object ob = (Object) ois.readObject();
                        list.add(ob);
                    } catch (EOFException e) {
                        cont = false;
                    }
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return list;
    }
}

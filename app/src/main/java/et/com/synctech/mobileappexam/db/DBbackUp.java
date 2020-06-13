package et.com.synctech.mobileappexam.db;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class DBbackUp {

        public static void copyDatabase(Context c) {

            String DATABASE_NAME = "retrofit.db";

            String databasePath = c.getDatabasePath(DATABASE_NAME).getPath();
            File f = new File(databasePath);
            OutputStream myOutput = null;
            OutputStream myOutputInternal = null;
            InputStream myInput = null;
            Log.d("dbpath", databasePath);


            try {

                File directoryIntenal = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/RETROFIT_DB/");
                if (!directoryIntenal.exists())
                    directoryIntenal.mkdir();

                myOutputInternal = new FileOutputStream(directoryIntenal.getAbsolutePath()
                        + "/" + DATABASE_NAME);

                myInput = new FileInputStream(databasePath);


                byte[] buffer = new byte[1024];
                int length;
                while ((length = myInput.read(buffer)) > 0) {
                    myOutputInternal.write(buffer, 0, length);
                }

                myOutputInternal.flush();
            } catch (Exception e) {
            } finally {
                try {
                    if (myOutputInternal != null) {
                        myOutputInternal.close();
                        myOutputInternal = null;
                    }
                    if (myInput != null) {
                        myInput.close();
                        myInput = null;
                    }
                } catch (Exception e) {
                }
            }
        }
    }

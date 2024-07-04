import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class GenerarArchivoJson {



    public void generarJson(Dinero dinero) throws IOException {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter describe = new FileWriter(dinero.base_code()+".json");
        describe.write(gson.toJson(dinero));
        describe.close();

    }
}

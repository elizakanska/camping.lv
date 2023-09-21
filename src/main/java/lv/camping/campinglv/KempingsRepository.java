package lv.camping.campinglv;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Value;

@Repository
public class KempingsRepository {
    private final String jsonFilePath;
    private final ObjectMapper objectMapper;

    public KempingsRepository(@Value("${json.path}")String jsonFilePath) {
        this.jsonFilePath = "static/Kempingi.json";
        this.objectMapper = new ObjectMapper();
    }

    public List<Kempings> getAllKempings() throws IOException {
        File jsonFile = new File(jsonFilePath);
        List<Kempings> kempingsList = objectMapper.readValue(jsonFile, new TypeReference<List<Kempings>>() {});
        return kempingsList;
    }

    public Kempings getKempingsById(int id) throws IOException {
        File jsonFile = new File(jsonFilePath);
        List<Kempings> kempingsList = objectMapper.readValue(jsonFile, new TypeReference<List<Kempings>>() {});

        // Find the Kempings object by ID (You can use a stream or loop here)
        for (Kempings kempings : kempingsList) {
            if (kempings.getID() == id) {
                return kempings;
            }
        }

        // Handle the case where the ID is not found
        return null;
    }

}


package athena.common.patch;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import java.io.IOException;
import org.springframework.boot.json.JsonParseException;

public interface PatchService {

  ObjectMapper objectMapper = new ObjectMapper();

  default <Data, Patch> Data patch(Data data, Patch patch) throws JsonParseException {
    ObjectReader objectReader = objectMapper.readerForUpdating(data);

    JsonNode patchNode = objectMapper.valueToTree(patch);
    try {
      return objectReader.readValue(patchNode);
    } catch (IOException e) {
      throw new JsonParseException(e);
    }
  }

}
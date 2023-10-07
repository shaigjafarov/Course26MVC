package az.code.course26mvc.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
@Data
public class  WeatherDTO {

    String location;
    String condition;
    @JsonProperty("hava_proqnozu_dto")
    HavaProqnozuDTO havaProqnozuDTO;


}

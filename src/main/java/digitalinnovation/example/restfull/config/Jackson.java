package digitalinnovation.example.restfull.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Jackson {

    @Bean
    public ObjectMapper objectMapper(){
        //Propriedades não mapeadas NÃO quebram
        objectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        //Falha se alguma propriedade estiver vazia
        objectMapper().configure(SerializationFeature.FAIL_ON_EMPTY_BEANS,false);
        //Serve para compatibilidade de arrays, quando tem um array com um item, caso não tenha esse config ele se perdeo
        objectMapper().enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        //Serelize datas
        objectMapper().registerModule(new JavaTimeModule());
        //objectMapper().registerModule(racaModuleMapper());
        return objectMapper();
    }
}

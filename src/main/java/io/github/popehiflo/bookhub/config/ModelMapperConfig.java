package io.github.popehiflo.bookhub.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Clase de configuración para beans de la aplicación.
 */
@Configuration
public class ModelMapperConfig {

    /**
     * Crea un bean de ModelMapper con una estrategia de mapeo estricta.
     * <p>
     * Usar {@link MatchingStrategies#STRICT} asegura que ModelMapper solo mapeará propiedades
     * que tengan exactamente el mismo nombre tanto en el objeto de origen como en el de destino. Esto previene
     * posibles errores y comportamientos inesperados derivados de un emparejamiento de nombres poco estricto.
     *
     * @return Una instancia configurada de ModelMapper.
     */
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;
    }
}

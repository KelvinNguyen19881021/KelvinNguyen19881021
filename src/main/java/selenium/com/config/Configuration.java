package selenium.com.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;
import org.aeonbits.owner.Config.LoadPolicy;
import org.aeonbits.owner.Config.LoadType;

@LoadPolicy(LoadType.MERGE)
@Sources({"system:properties",
        "system:env",
        "file:./src/test/resources/config/config.properties",
        "file:./src/test/resources/config/data.properties"})

public interface Configuration extends Config {

    @Key("TARGET")
    String TARGET();

    @Key("BROWSER")
    String BROWSER();

    @Key("HEADLESS")
    Boolean HEADLESS();

    @Key("URL_SADLIERCONNECT_USER")
    String URL_SADLIERCONNECT_USER();


    @Key("EXCEL_DATA_FILE_PATH")
    String EXCEL_DATA_FILE_PATH();

}

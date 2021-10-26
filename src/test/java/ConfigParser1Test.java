import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import com.company.ConfigParser1;
import static org.junit.jupiter.api.Assertions.*;

class ConfigParser1Test {
ConfigParser1 configparse;
    @BeforeEach
    void setUp() {
        configparse = new ConfigParser1("dev.txt");
    }

    @Test
    void readFromFIleTest() {
     configparse.readFromFIle();
     assertNotNull(configparse.getMap());
    }

    @Test
    void getValueByKey() {
     configparse.readFromFIle();
     configparse.getValueByKey("application1.name");
     assertNotNull(configparse.getValueByKey("application1.name"));
    }
}